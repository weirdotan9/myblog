package com.twr.controller.admin;

import com.github.pagehelper.PageInfo;
import com.twr.entity.Type;
import com.twr.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String getTypes(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageInfo<Type> pageInfo = typeService.getTypesPage(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/types";
    }

    @GetMapping("types/input")
    public String toEditType(Model model) {
        return "admin/types-input";
    }

    @PostMapping("/types")
    public String addType(Type type, RedirectAttributes attributes) {
        Type typeByName = typeService.getTypeByName(type.getName());
        System.out.println(type);
        if (typeByName != null) {
            attributes.addFlashAttribute("message", "该分类已存在");
            return "redirect:/admin/types/input";
        }

        typeService.saveType(type);
        attributes.addFlashAttribute("message", "新增成功");
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/input")
    public String toUpdateType(@PathVariable("id") Long id, Model model) {
        Type type = typeService.getTypeById(id);
        model.addAttribute("type", type);
        return "admin/types-input";
    }

    @PutMapping("/types")
    public String editType(Type type, RedirectAttributes attributes) {
        typeService.updateType(type);
        System.out.println(type+"update");
        attributes.addFlashAttribute("message", "修改成功");
        return "redirect:/admin/types";

    }

    @DeleteMapping("/types/{id}")
    public String removeType(@PathVariable("id") Long id, RedirectAttributes attributes) {
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";

    }


}
