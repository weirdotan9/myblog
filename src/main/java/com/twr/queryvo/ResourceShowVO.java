package com.twr.queryvo;

import lombok.Data;

@Data
public class ResourceShowVO {
    private Long id;
    private String resourceName;
    private String resourceAddress;
    private String resourcePicture;
    private String resourceDescription;
    private String type;
    private Long categoryId;
}
