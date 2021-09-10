package com.twr.queryvo;

import com.twr.entity.Type;
import lombok.Data;

import java.util.Date;

/**
 * 后台管理文章数据实体类
 */
@Data
public class BlogQueryVO {
    private  Long id;
    private String title;
    private Date updateTime;
    private Boolean recommend;
    private Boolean published;
    private Long typeId;
    private Type type;

}
