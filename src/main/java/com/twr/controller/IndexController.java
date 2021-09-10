package com.twr.controller;

import com.github.pagehelper.PageInfo;
import com.twr.entity.Comment;
import com.twr.queryvo.DetailedBlogVO;
import com.twr.queryvo.FirstPageBlogVO;
import com.twr.queryvo.RecommendBlogVO;
import com.twr.service.BlogService;
import com.twr.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(defaultValue = "1", value = "pageNum") int pageNum,
                        @RequestParam(defaultValue = "10", value = "pageSize") int pageSize,
                        RedirectAttributes attributes) {
        PageInfo<FirstPageBlogVO> pageInfo = blogService.getFirstPageBlog(pageNum, pageSize);
        List<RecommendBlogVO> recommendBlog = blogService.getAllRecommendBlog();
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("recommendedBlogs",recommendBlog);
        return "index";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        DetailedBlogVO detailedBlog = blogService.getDetailedBlog(id);
        List<Comment> comments = commentService.getCommentByBlogId(id);
        model.addAttribute("comments", comments);
        model.addAttribute("blog", detailedBlog);
        return "blog";
    }

    @PostMapping("/blogs/search")
    public String searchBlog(String query, Model model,
                             @RequestParam(defaultValue = "1", value = "pageNum") int pageNum,
                             @RequestParam(defaultValue = "10", value = "pageSize") int pageSize){
        PageInfo<FirstPageBlogVO> pageInfo = blogService.getSearchBlog(query, pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/footer/blogmessage")
    public String blogMessage(Model model){
        int blogTotal = blogService.getBlogTotal();
        int blogViewTotal = blogService.getBlogViewTotal();
        int blogCommentTotal = blogService.getBlogCommentTotal();
        int blogMessageTotal = blogService.getBlogMessageTotal();

        model.addAttribute("blogTotal",blogTotal);
        model.addAttribute("blogViewTotal",blogViewTotal);
        model.addAttribute("blogCommentTotal",blogCommentTotal);
        model.addAttribute("blogMessageTotal",blogMessageTotal);
        return "common/foot :: blogMessage";
    }



}
