package com.nltu.controller;

import com.nltu.dao.CountryDAO;
import com.nltu.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagementController {

    @RequestMapping(value = {"/management"})
    public String showManagementPage() {
        return "management";
    }

}
