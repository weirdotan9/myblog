package com.twr.controller;

import com.twr.entity.Comment;
import com.twr.entity.User;
import com.twr.queryvo.DetailedBlogVO;
import com.twr.service.BlogService;
import com.twr.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;



    @GetMapping("/comment/{blogId}")
    public String getComment(@PathVariable("blogId") Long blogId, Model model) {
        List<Comment> comments = commentService.getCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String saveComment(Comment comment, HttpSession session, Model model) {
        Long blogId = comment.getBlogId();
        System.out.println(blogId);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAdminComment(true);
            comment.setAvatar(user.getAvatar());
        }

        if (comment.getParentComment().getId() != null) {
            comment.setParentCommentId(comment.getParentComment().getId());
        }
        commentService.saveComment(comment);
        List<Comment> comments = commentService.getCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
        return "blog::commentList";
    }

    @GetMapping("/comment/{blogId}/{id}/delete")
    public String delete(@PathVariable Long blogId, @PathVariable Long id, Comment comment, RedirectAttributes attributes, Model model) {
        commentService.removeComment(comment, id);
        DetailedBlogVO detailedBlog = blogService.getDetailedBlog(blogId);
        List<Comment> comments = commentService.getCommentByBlogId(blogId);
        model.addAttribute("blog", detailedBlog);
        model.addAttribute("comments", comments);
        return "blog";
    }

}
