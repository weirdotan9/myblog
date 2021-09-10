package com.twr.entity;

import lombok.Data;

import java.util.Date;

@Data
public class FriendLink {
    private Long id;
    private String blogName;
    private String blogAddress;
    private String pictureAddress;
    private Date createTime;


}
