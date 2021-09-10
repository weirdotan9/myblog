package com.twr.queryvo;

import lombok.Data;

import java.util.Date;

/**
 * 个人博客首页展示的博客数据实体类
 * 首页博客列表 至显示基础信息
 */
@Data
public class FirstPageBlogVO {
    private Long id;
    private String title;
    private String firstPicture;
    private Integer views;
    private Integer commentCount;
    private Date updateTime;
    private String description;

    //Type
    private String typeName;

    //User
    private String nickname;
    private String avatar;
}
