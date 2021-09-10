package com.twr.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Resource {

    private Long id;
    private String resourceName;
    private String resourceAddress;
    private String resourcePicture;
    private String resourceDescription;
    private String type;
    private Date updateTime;
    private Long categoryId;
    private Category category;


}
