package com.twr.service;

import com.github.pagehelper.PageInfo;
import com.twr.entity.Resource;

import java.util.List;

public interface ResourceService {

    PageInfo<Resource> getAllResources(int pageNum, int pageSize);

    int saveResource(Resource resource);

    void removeResource(Long id);

    Resource getById(Long id);

    int updateResource(Resource resource);

    PageInfo<Resource> getResourcesByCategory(Long categoryId, int pageNum, int pageSize);

}
