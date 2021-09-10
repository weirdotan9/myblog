package com.twr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.twr.dao.ResourceDao;
import com.twr.entity.Resource;
import com.twr.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public PageInfo<Resource> getAllResources(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Resource> resources = resourceDao.getAllResources();

        return new PageInfo<>(resources);
    }

    @Override
    public int saveResource(Resource resource) {
        resource.setUpdateTime(new Date());
        return resourceDao.addResource(resource);
    }

    @Override
    public void removeResource(Long id) {

        resourceDao.removeResource(id);
    }

    @Override
    public Resource getById(Long id) {
        return resourceDao.getOneById(id);
    }

    @Override
    public int updateResource(Resource resource) {
        resource.setUpdateTime(new Date());
        return resourceDao.updateResource(resource);
    }

    @Override
    public PageInfo<Resource> getResourcesByCategory(Long categoryId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Resource> resources = resourceDao.getResourcesByCategoryId(categoryId);

        return new PageInfo<>(resources);
    }
}
