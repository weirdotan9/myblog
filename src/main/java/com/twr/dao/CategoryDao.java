package com.twr.dao;

import com.twr.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao {

    List<Category> getAllCategory();

    List<Category> getAllCategoryAndResources();

}
