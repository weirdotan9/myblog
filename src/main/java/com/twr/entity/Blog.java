package com.twr.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Blog {

    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 首图
     */
    private String firstPicture;

    private String flag;
    private Integer views;

    private Integer commentCount;

    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentAble;
    private boolean published;
    private boolean recommend;
    private Date createTime;
    private Date updateTime;

    private Long typeId;
    private Long userId;
    private String description;
    private Type type;
    private User user;
    private List<Comment> comments = new ArrayList<>();



}
