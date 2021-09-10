package com.twr.queryvo;

import lombok.Data;

import java.util.Date;

/**
 *编辑修改文章实体类
 */
@Data
public class ShowBlogVO {

    private Long id;
    private String flag;
    private String title;
    private String content;
    private Long typeId;
    private String firstPicture;
    private String description;
    private boolean recommend;
    private boolean published;
    private boolean shareStatement;
    private boolean appreciation;
    private boolean commentAble;
    private Date updateTime;
}
