package com.twr.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.twr.dao.BlogDao;
import com.twr.entity.Blog;
import com.twr.exception.NotFoundException;
import com.twr.queryvo.*;
import com.twr.service.BlogService;
import com.twr.utils.MarkDownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        return blogDao.addBlog(blog);
    }

    @Override
    public List<BlogQueryVO> getAllBlogs() {

        return blogDao.getAllBlogQuery();
    }

    @Override
    public PageInfo<BlogQueryVO> getAllBlogsPage(int pageNum,int pageSize) {
        String order="update_time desc";
        PageHelper.startPage(pageNum,pageSize,order);
        List<BlogQueryVO> blogs = blogDao.getAllBlogQuery();
        return new PageInfo<>(blogs);
    }

    @Override
    public ShowBlogVO getEditBlogById(Long id) {
        ShowBlogVO blog = blogDao.getShowBlogById(id);
        return blog;
    }

    @Override
    public int updateBlog(ShowBlogVO showBlogVO) {
        showBlogVO.setUpdateTime(new Date());
        int i = blogDao.updateBlog(showBlogVO);
        return i;
    }

    @Override
    public int removeBlogs(Long id) {
        int i = blogDao.removeBlog(id);
        return i;
    }

    @Override
    public PageInfo<BlogQueryVO> searchBlog(SearchBlogVO searchBlogVO, int pageNum, int pageSize) {
        String order="update_time desc";
        PageHelper.startPage(pageNum,pageSize,order);
        List<BlogQueryVO> blogs = blogDao.searchByTitleOrTypeOrRecommend(searchBlogVO);
        PageInfo<BlogQueryVO> pageInfo = new PageInfo<>(blogs);
        return pageInfo;
    }

    @Override
    public List<RecommendBlogVO> getAllRecommendBlog() {
        List<RecommendBlogVO> allRecommendBlog = blogDao.getAllRecommendBlog();
        return allRecommendBlog;
    }

    @Override
    public PageInfo<FirstPageBlogVO> getFirstPageBlog(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<FirstPageBlogVO> firstPageBlog = blogDao.getFirstPageBlog();
        PageInfo<FirstPageBlogVO> pageInfo = new PageInfo<>(firstPageBlog);
        return pageInfo;
    }

    @Override
    public PageInfo<FirstPageBlogVO> getSearchBlog(String query, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<FirstPageBlogVO> searchBlog = blogDao.getSearchBlog(query);
        PageInfo<FirstPageBlogVO> pageInfo = new PageInfo<>(searchBlog);
        return pageInfo;
    }

    @Override
    public DetailedBlogVO getDetailedBlog(Long id) {
        DetailedBlogVO detailedBlog = blogDao.getDetailedBlog(id);
        if (detailedBlog==null){
             throw new NotFoundException("该博客已不存在");
        }
        String s = MarkDownUtils.markdownToHtmlExtensions(detailedBlog.getContent());
        detailedBlog.setContent(s);
        blogDao.updateViews(id);
        blogDao.getCommentCountById(id);
        return detailedBlog;
    }

    @Override
    public PageInfo<FirstPageBlogVO> getByTypeId(Long typeId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<FirstPageBlogVO> blogs = blogDao.getByTypeId(typeId);
        PageInfo<FirstPageBlogVO> pageInfo = new PageInfo<>(blogs);
        return pageInfo;
    }

    @Override
    public Integer getBlogTotal() {
        return blogDao.getBlogTotal();
    }

    @Override
    public Integer getBlogViewTotal() {
        return blogDao.getBlogViewTotal();
    }

    @Override
    public Integer getBlogCommentTotal() {
        return blogDao.getBlogCommentTotal();
    }

    @Override
    public Integer getBlogMessageTotal() {
        return blogDao.getBlogMessageTotal();
    }
}
