package com.twr.entity;

import com.twr.queryvo.ResourceShowVO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Category {

    private Long id;
    private String name;

    private List<ResourceShowVO> resources=new ArrayList<>();

}
