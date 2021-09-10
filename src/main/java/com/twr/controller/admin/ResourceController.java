package com.twr.controller.admin;

import com.github.pagehelper.PageInfo;
import com.twr.entity.Category;
import com.twr.entity.Resource;
import com.twr.service.CategoryService;
import com.twr.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ResourceController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/resources")
    public String toResourcesPage(Model model,
                                  @RequestParam(defaultValue = "1", value = "pageNum") int pageNum,
                                  @RequestParam(defaultValue = "10", value = "pageSize") int pageSize) {
        PageInfo<Resource> pageInfo = resourceService.getAllResources(pageNum, pageSize);
        List<Category> categories = categoryService.getAllCategorys();
        model.addAttribute("categories", categories);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/resources";
    }

    @GetMapping("/resources/input")
    public String toInputPage(Model model) {
        List<Category> categories = categoryService.getAllCategorys();
        model.addAttribute("categories", categories);
        return "admin/resources-input";
    }


    @PostMapping("/resources")
    public String saveResources(Resource resource, RedirectAttributes attributes) {

        int i = resourceService.saveResource(resource);
        if (i>0){
            attributes.addFlashAttribute("message","添加资源成功");
        }else {
            attributes.addFlashAttribute("message","添加资源失败");
        }

        return "redirect:/admin/resources";
    }

    @GetMapping("/resources/{id}/input")
    public String toEditPage(@PathVariable("id") Long id , Model model){
        Resource resource = resourceService.getById(id);
        List<Category> categories = categoryService.getAllCategorys();
        model.addAttribute("categories", categories);
        model.addAttribute("resource",resource);
        return "admin/resources-input";
    }

    @PutMapping("/resources")
    public String editResource(Resource resource,RedirectAttributes attributes){
        int i = resourceService.updateResource(resource);
        if (i>0){
            attributes.addFlashAttribute("message","更新资源成功");
        }else {
            attributes.addFlashAttribute("message","更新资源失败");
        }
        return "redirect:/admin/resources";
    }

    @DeleteMapping("/resources/{id}")
    public  String removeResource(@PathVariable("id") Long id, RedirectAttributes attributes){
        resourceService.removeResource(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/resources";
    }

    @PostMapping("/resources/search")
    public String searchResources(Long categoryId,Model model,
                                  @RequestParam(defaultValue = "1", value = "pageNum") int pageNum,
                                  @RequestParam(defaultValue = "10", value = "pageSize") int pageSize){
        PageInfo<Resource> pageInfo = resourceService.getResourcesByCategory(categoryId, pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/resources::resourceList";
    }

}
