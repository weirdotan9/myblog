package com.twr.controller;

import com.twr.queryvo.BlogQueryVO;
import com.twr.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArchivesController {

    @Autowired
    BlogService blogService;

    @GetMapping("/archives")
    public String toArchives(Model model) {
        List<BlogQueryVO> blogs = blogService.getAllBlogs();
        model.addAttribute("blogs",blogs);
        return "archives";
    }
}
