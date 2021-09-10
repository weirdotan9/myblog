package com.twr.controller;

import com.twr.entity.Picture;
import com.twr.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PictureShowController {

    @Autowired
    private PictureService pictureService;

    @GetMapping("/picture")
    public String toPictures(Model model) {
        List<Picture> pictures = pictureService.getAllPictures();
        model.addAttribute("pictures", pictures);
        return "picture";
    }
}
