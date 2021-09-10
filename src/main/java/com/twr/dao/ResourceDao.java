package com.twr.dao;

import com.twr.entity.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceDao {

    int addResource(Resource resource);

    int updateResource(Resource resource);

    void removeResource(Long id);

    List<Resource> getResourcesByCategoryId(Long id);

    List<Resource> getAllResources();

    Resource getOneById(Long id);


}
