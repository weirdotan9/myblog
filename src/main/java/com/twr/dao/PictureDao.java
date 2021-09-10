package com.twr.dao;

import com.twr.entity.Picture;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureDao {

    int addPicture(Picture picture);

    void removePicture(Long id);

    int updatePicture(Picture picture);

    List<Picture> getAllPicture();

    Picture getPictureById(Long id);
}
