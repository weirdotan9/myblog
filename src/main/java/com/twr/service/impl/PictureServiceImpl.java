package com.twr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.twr.dao.PictureDao;
import com.twr.entity.Picture;
import com.twr.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;

    @Override
    public int savePicture(Picture picture) {
        return pictureDao.addPicture(picture);
    }

    @Override
    public int updatePicture(Picture picture) {
        return pictureDao.updatePicture(picture);
    }

    @Override
    public void removePicture(Long id) {

        pictureDao.removePicture(id);
    }

    @Override
    public Picture getPictureById(Long id) {
        return pictureDao.getPictureById(id);
    }

    @Override
    public PageInfo<Picture> getAllPictureByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Picture> allPicture = pictureDao.getAllPicture();
        PageInfo<Picture> pageInfo = new PageInfo<>(allPicture);
        return pageInfo;
    }

    @Override
    public List<Picture> getAllPictures() {
        return pictureDao.getAllPicture();
    }
}
