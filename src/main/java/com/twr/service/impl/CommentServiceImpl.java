package com.twr.service.impl;

import com.twr.dao.BlogDao;
import com.twr.dao.CommentDao;
import com.twr.entity.Comment;
import com.twr.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private BlogDao blogDao;

    private List<Comment> tempReplys=new ArrayList<>();

    @Override
    public List<Comment> getCommentByBlogId(Long blogId) {
        List<Comment> comments = commentDao.findByBlogIdParentIdNull(blogId, Long.parseLong("-1"));
        for (Comment c: comments
             ) {
            List<Comment> childComments = commentDao.findByBlogIdParentIdNotNull(blogId, c.getId());
            combineChildren(blogId, childComments, c.getNickname());
            c.setReplyComments(tempReplys);
            tempReplys = new ArrayList<>();

        }
        return comments;
    }

    private void combineChildren(Long blogId, List<Comment> childComments, String parentNickname1) {
//        判断是否有一级子评论
        if(childComments.size() > 0){
//                循环找出子评论的id
            for(Comment childComment : childComments){
                String parentNickname = childComment.getNickname();
                childComment.setParentNickname(parentNickname1);
                tempReplys.add(childComment);
                Long childId = childComment.getId();
//                    查询出子二级评论
                recursively(blogId, childId, parentNickname);
            }
        }
    }

    private void recursively(Long blogId, Long childId, String parentNickname1) {
//        根据子一级评论的id找到子二级评论
        List<Comment> replayComments = commentDao.findByBlogIdAndReplayId(blogId,childId);

        if(replayComments.size() > 0){
            for(Comment replayComment : replayComments){
                String parentNickname = replayComment.getNickname();
                replayComment.setParentNickname(parentNickname1);
                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                recursively(blogId,replayId,parentNickname);
            }
        }
    }

    @Override
    public int saveComment(Comment comment) {
        comment.setCreateTime(new Date());
        int i = commentDao.saveComment(comment);
        blogDao.getCommentCountById(comment.getBlogId());
        return i;
    }

    @Override
    public void removeComment(Comment comment, Long id) {

        commentDao.deleteComment(id);
        blogDao.getCommentCountById(comment.getBlogId());

    }
}
