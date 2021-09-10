package com.twr.service;

import com.github.pagehelper.PageInfo;
import com.twr.entity.Blog;
import com.twr.queryvo.*;

import java.util.List;

public interface BlogService {

    int saveBlog(Blog blog);

    List<BlogQueryVO> getAllBlogs();

    PageInfo<BlogQueryVO> getAllBlogsPage(int pageNum, int pageSize);

    ShowBlogVO getEditBlogById(Long id);

    int updateBlog(ShowBlogVO showBlogVO);

    int removeBlogs(Long id);

    PageInfo<BlogQueryVO> searchBlog(SearchBlogVO searchBlogVO, int pageNum, int pageSize);

    List<RecommendBlogVO> getAllRecommendBlog();

    PageInfo<FirstPageBlogVO> getFirstPageBlog(int pageNum, int pageSize);

    PageInfo<FirstPageBlogVO> getSearchBlog(String query, int pageNum, int pageSize);


    DetailedBlogVO getDetailedBlog(Long id);

    //根据TypeId获取博客列表，在分类页进行的操作
    PageInfo<FirstPageBlogVO> getByTypeId(Long typeId, int pageNum, int pageSize);

    Integer getBlogTotal();

    Integer getBlogViewTotal();

    Integer getBlogCommentTotal();

    Integer getBlogMessageTotal();

}
