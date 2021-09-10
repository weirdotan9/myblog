package com.twr.controller;


import com.github.pagehelper.PageInfo;
import com.twr.entity.Type;
import com.twr.queryvo.FirstPageBlogVO;
import com.twr.service.BlogService;
import com.twr.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String showTypes(Model model,
                            @PathVariable("id") Long id,
                            @RequestParam(defaultValue = "1", value = "pageNum") int pageNum,
                            @RequestParam(defaultValue = "10", value = "pageSize") int pageSize) {

        List<Type> types = typeService.getAllTypeAndBlog();

        model.addAttribute("types",types);
        if (id==-1){
            id=types.get(0).getId();
        }

        PageInfo<FirstPageBlogVO> pageInfo = blogService.getByTypeId(id, pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeTypeId", id);
        return "types";

    }
}
