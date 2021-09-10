package com.twr.service;

import com.github.pagehelper.PageInfo;
import com.twr.entity.Picture;

import java.util.List;

public interface PictureService {

    int savePicture(Picture picture);

    int updatePicture(Picture picture);

    void removePicture(Long id);

    Picture getPictureById(Long id);

    PageInfo<Picture> getAllPictureByPage(int pageNum, int pageSize);

    List<Picture> getAllPictures();
}
