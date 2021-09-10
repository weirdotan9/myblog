package com.twr.queryvo;

import lombok.Data;

import java.util.Date;

/**
 * 具体页面展示单个文章数据实体类
 */
@Data
public class DetailedBlogVO {
    private  Long id;
    private String firstPicture;
    private String flag;
    private String title;
    private String content;

    private Integer views;
    private Integer commentCount;
    private Date updateTime;
    private boolean commentAble;
    private boolean shareStatement;
    private boolean appreciation;
    private String nickname;
    private String avatar;

    //Type
    private String typeName;

}
