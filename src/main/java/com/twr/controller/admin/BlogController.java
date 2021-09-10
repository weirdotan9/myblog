package com.twr.controller.admin;


import com.github.pagehelper.PageInfo;
import com.twr.entity.Blog;
import com.twr.entity.Type;
import com.twr.entity.User;
import com.twr.queryvo.BlogQueryVO;
import com.twr.queryvo.SearchBlogVO;
import com.twr.queryvo.ShowBlogVO;
import com.twr.service.BlogService;
import com.twr.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/blogs")
    public String toBlogs(Model model,
                          @RequestParam(defaultValue = "1", value = "pageNum") int pageNum,
                          @RequestParam(defaultValue = "10", value = "pageSize") int pageSize) {

        PageInfo<BlogQueryVO> pageInfo = blogService.getAllBlogsPage(pageNum, pageSize);
        List<Type> types = typeService.getTypes();
        model.addAttribute("types", types);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/blogs";
    }

    @GetMapping("/blogs/input")
    public String toInputPage(Model model) {
        List<Type> types = typeService.getTypes();
        model.addAttribute("types", types);
        return "admin/blogs-input";
    }

    @PostMapping("/blogs")
    public String saveBlog(Blog blog, RedirectAttributes redirectAttributes,
                           HttpSession session) {
        User user = (User) session.getAttribute("user");
        blog.setUser(user);
        blog.setUserId(user.getId());
        Type type = typeService.getTypeById(blog.getTypeId());
        blog.setType(type);
        blog.setTypeId(type.getId());
        int i = blogService.saveBlog(blog);
        if (i > 0) {
            redirectAttributes.addFlashAttribute("message", "增加成功");
            return "redirect:/admin/blogs";
        } else {
            redirectAttributes.addFlashAttribute("message", "增加失败");
            return "redirect:/admin/blogs";
        }

    }

    @GetMapping("/blogs/{id}/input")
    public String toEditBlog(Model model, @PathVariable("id") Long id) {
        ShowBlogVO blog = blogService.getEditBlogById(id);
        List<Type> types = typeService.getTypes();
        model.addAttribute("types", types);
        model.addAttribute("blog", blog);
        return "admin/blogs-input";
    }

    @PutMapping("/blogs")
    public String updateBlog(ShowBlogVO showBlogVO, RedirectAttributes attributes) {
        int i = blogService.updateBlog(showBlogVO);
        if (i > 0)
            attributes.addFlashAttribute("message", "修改成功");
        else
            attributes.addFlashAttribute("message", "修改失败");

        return "redirect:/admin/blogs";
    }

    @DeleteMapping("/blogs/{id}")
    public String removeBlog(@PathVariable("id") Long id, RedirectAttributes attributes) {
        int i = blogService.removeBlogs(id);
        if (i > 0)
            attributes.addFlashAttribute("message", "删除成功");
        else
            attributes.addFlashAttribute("message", "删除失败");
        return "redirect:/admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String searchBlogs(Model model,
                              SearchBlogVO searchBlogVO,
                              @RequestParam(defaultValue = "1", value = "pageNum") int pageNum,
                              @RequestParam(defaultValue = "10", value = "pageSize") int pageSize) {
        PageInfo<BlogQueryVO> pageInfo = blogService.searchBlog(searchBlogVO, pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs::blogList";
    }


}
