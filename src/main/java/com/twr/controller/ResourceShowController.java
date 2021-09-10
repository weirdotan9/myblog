package com.twr.controller;


import com.twr.entity.Category;
import com.twr.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ResourceShowController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/resources")
    public String toResourcePage(Model model){

        List<Category> categories = categoryService.getAllCategoryAndResources();
        model.addAttribute("categories",categories);
        return "resources";
    }


}
