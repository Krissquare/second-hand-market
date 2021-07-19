package com.team.springboot.serviceImpl;

import com.team.springboot.mapper.ProductImagesMapper;
import com.team.springboot.service.ProductImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImagesServiceImpl implements ProductImagesService {

    @Autowired
    private ProductImagesMapper productImagesMapper;

    @Override public List<String> selectAllImages(int p_Id){ return productImagesMapper.selectAllImages(p_Id); }

    @Override public void insertOneImage(int p_Id, String p_Image){ productImagesMapper.insertOneImage(p_Id,p_Image);}

    @Override public void deleteOneImage(int p_Id, String p_Image){ productImagesMapper.deleteOneImage(p_Id,p_Image);}

    @Override public void deleteAllImages(int p_Id){ productImagesMapper.deleteAllImages(p_Id);}
}
