package com.twr.service;

import com.twr.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentByBlogId(Long id);

    int saveComment(Comment comment);

    void removeComment(Comment comment,Long id);
}
