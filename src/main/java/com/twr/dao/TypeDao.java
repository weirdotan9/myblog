package com.twr.dao;

import com.twr.entity.Type;
import com.twr.queryvo.FirstPageBlogVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeDao {

    /**
     * 获取所有分类
     * @return
     */
    List<Type> getTypes();

    /**
     * 获取所有分类和该分类下的文章
     * @return
     */
    List<Type> getAllTypeAndBlogs();

    /**
     * 根据分类id来获取分类
     * @param id
     * @return
     */
    Type getTypeById(Long id);

    /**
     * 根据分类name来获取分类
     * @param name
     * @return
     */
    Type getTypeByName(String name);

    /**
     * 增加分类
     * @param type
     */
    void addType(Type type);

    /**
     * 修改分类
     * @param type
     */
    void updateType(Type type);

    /**
     * 删除分类
     * @param id
     */
    void removeType(Long id);


}
