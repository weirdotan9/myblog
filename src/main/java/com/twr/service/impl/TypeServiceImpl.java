package com.twr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.twr.dao.TypeDao;
import com.twr.entity.Type;
import com.twr.queryvo.FirstPageBlogVO;
import com.twr.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public void saveType(Type type) {
        typeDao.addType(type);
    }

    @Override
    public Type getTypeById(Long id) {

        return typeDao.getTypeById(id);
    }

    @Override
    public PageInfo<Type> getTypesPage(Integer pageNum, Integer pageSize) {
        String orderBy="id desc";
        PageHelper.startPage(pageNum,pageSize,orderBy);
        List<Type> types = typeDao.getTypes();
        return new PageInfo<>(types);
    }

    @Override
    public List<Type> getTypes() {
        List<Type> types = typeDao.getTypes();
        return types;
    }


    @Override
    public List<Type> getAllTypeAndBlog() {
        return typeDao.getAllTypeAndBlogs();
    }

    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }

    @Override
    public void updateType(Type type) {
        typeDao.updateType(type);
    }

    @Override
    public void deleteType(Long id) {
        typeDao.removeType(id);
    }


}
