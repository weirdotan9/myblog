package com.twr.controller.admin;

import com.github.pagehelper.PageInfo;
import com.twr.entity.Picture;
import com.twr.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @GetMapping("/pictures")
    public String allPicture(Model model,
                             @RequestParam(defaultValue = "1",value = "pageNum") int pageNum,
                             @RequestParam(defaultValue = "10",value = "pageSize") int pageSize) {
        PageInfo<Picture> pageInfo = pictureService.getAllPictureByPage(pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/pictures";
    }

    @GetMapping("/pictures/input")
    public String toInput(){

        return "admin/pictures-input";
    }

    @GetMapping("/pictures/{id}/input")
    public String toEditPage(@PathVariable("id") Long id, Model model){
        Picture picture = pictureService.getPictureById(id);
        model.addAttribute("picture",picture);
        return "admin/pictures-input";
    }

    @PostMapping("/pictures")
    public String savePicture(Picture picture, RedirectAttributes attributes, BindingResult result){

        if(result.hasErrors()){
            return "admin/pictures-input";
        }
        int i = pictureService.savePicture(picture);
        if (i>0){
            attributes.addFlashAttribute("message","添加图片成功");
        }else {
            attributes.addFlashAttribute("message","添加图片失败");
        }
        return "redirect:/admin/pictures";
    }


    @PutMapping("/pictures")
    public String updatePicture(Picture picture,RedirectAttributes attributes){
        int i = pictureService.updatePicture(picture);
        if (i>0){
            attributes.addFlashAttribute("message","修改图片成功");
        }else {
            attributes.addFlashAttribute("message","修改图片失败");
        }
        return "redirect:/admin/pictures";
    }

    @DeleteMapping("/pictures/{id}")
    public String removePicture(@PathVariable("id") Long id,RedirectAttributes attributes){

        pictureService.removePicture(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/pictures";
    }


}
