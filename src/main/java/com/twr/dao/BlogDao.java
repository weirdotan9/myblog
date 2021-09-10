package com.twr.dao;

import com.twr.entity.Blog;
import com.twr.queryvo.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogDao {

    ShowBlogVO getShowBlogById(Long id);

    int addBlog(Blog blog);

    //List<Blog> getAllBlogs();

    List<BlogQueryVO> getAllBlogQuery();

    int removeBlog(Long id);

    int updateBlog(ShowBlogVO showBlogVO);

    List<BlogQueryVO> searchByTitleOrTypeOrRecommend(SearchBlogVO searchBlog);

    List<FirstPageBlogVO> getFirstPageBlog();

    List<RecommendBlogVO> getAllRecommendBlog();

//    List<FirstPageBlog> getNewBlog();

    List<FirstPageBlogVO> getSearchBlog(String query);

    DetailedBlogVO getDetailedBlog(Long id);

    int updateViews(Long id);

    //    根据博客id查询出评论数量
    int getCommentCountById(Long id);

    List<FirstPageBlogVO> getByTypeId(Long typeId);

    Integer getBlogTotal();

    Integer getBlogViewTotal();

    Integer getBlogCommentTotal();

    Integer getBlogMessageTotal();
}
