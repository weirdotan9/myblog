package com.twr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusicController {

    @GetMapping("/music")
    public String toMusicPage(){

        return "music";
    }

}
