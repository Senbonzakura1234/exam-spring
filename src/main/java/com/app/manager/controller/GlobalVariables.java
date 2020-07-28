package com.app.manager.controller;

import com.app.manager.model.SelectOption;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalVariables {
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("appName", "Sales Manager");
    }
}
