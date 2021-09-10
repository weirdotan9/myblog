package com.twr.service.impl;

import com.twr.dao.CategoryDao;
import com.twr.entity.Category;
import com.twr.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategorys() {
        return categoryDao.getAllCategory();
    }


    @Override
    public List<Category> getAllCategoryAndResources() {
        return categoryDao.getAllCategoryAndResources();
    }
}
