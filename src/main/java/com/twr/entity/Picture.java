package com.twr.entity;

import lombok.Data;

@Data
public class Picture {

    private Long id;
    private String pictureName;
    private String pictureTime;
    private String pictureAddress;
    private String pictureDescription;
}
