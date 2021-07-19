package com.team.springboot.service;

import java.util.List;

public interface ProductImagesService {

    public List<String> selectAllImages(int p_Id);

    public void insertOneImage(int p_Id, String p_Image);

    public void deleteOneImage(int p_Id, String p_Image);

    public void deleteAllImages(int p_Id);

}
