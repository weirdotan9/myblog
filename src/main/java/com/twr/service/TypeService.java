package com.twr.service;

import com.github.pagehelper.PageInfo;
import com.twr.entity.Type;
import com.twr.queryvo.FirstPageBlogVO;

import java.util.List;

public interface TypeService {


    void saveType(Type type);

    Type getTypeById(Long id);

    PageInfo<Type> getTypesPage(Integer pageNum, Integer pageSize);

    List<Type> getTypes();

    List<Type> getAllTypeAndBlog();

    Type getTypeByName(String name);

    void updateType(Type type);

    void deleteType(Long id);



}
