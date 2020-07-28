package com.app.manager.controller;

import com.app.manager.model.HelperMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class DashboardController {

    @GetMapping({"/dashboard", "/"})
    public String index(Model model) {
        return "views/dashboard";
    }
}
