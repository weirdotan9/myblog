package com.twr.queryvo;

import lombok.Data;

/**
 * 推荐博客数据实体类
 * 只展示标题和图片
 */
@Data
public class RecommendBlogVO {
        private Long id;
        private String title;
        private String firstPicture;
        private boolean recommend;

}
