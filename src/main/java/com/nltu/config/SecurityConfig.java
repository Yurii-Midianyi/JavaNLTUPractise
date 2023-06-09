package com.nltu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private final UserDetailsService userDetailsService;
    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/management").hasRole("MANAGER")
                .antMatchers("/countries/**").hasRole("MANAGER")
                .antMatchers("/user/**").hasRole("MANAGER")
                .antMatchers("/hotel/new").hasRole("MANAGER")
                .antMatchers("/hotel/{id}/edit").hasRole("MANAGER")
                .antMatchers(HttpMethod.PATCH,"/hotel/{id}").hasRole("MANAGER")
                .antMatchers(HttpMethod.DELETE,"/hotel/{id}").hasRole("MANAGER")
                .antMatchers("/booking/list").hasRole("MANAGER")
                .antMatchers("/booking/**").hasAnyRole("MANAGER", "USER")              
                .antMatchers("/room/showFormForAdd/{hotelId}").hasRole("MANAGER")
                .antMatchers("/room/saveRoom").hasRole("MANAGER")
                .antMatchers("/room/showFormForUpdate/{roomId}").hasRole("MANAGER")
                .antMatchers("/room/delete/{roomId}").hasRole("MANAGER")
                .antMatchers("/room/book/{roomId}").authenticated()
                .antMatchers("/login").permitAll()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/home",true)
                //.failureUrl("/login")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout");
                //.logoutSuccessUrl("/login");

    }

    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**");
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
