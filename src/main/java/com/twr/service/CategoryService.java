package com.twr.service;

import com.twr.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategorys();

    List<Category> getAllCategoryAndResources();

}
