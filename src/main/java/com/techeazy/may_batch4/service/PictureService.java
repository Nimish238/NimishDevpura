package com.techeazy.may_batch4.service;

import java.io.IOException;
import java.util.List;

import com.techeazy.may_batch4.entity.PictureEntity;
import org.springframework.web.multipart.MultipartFile;


public interface PictureService {

	public void savePictures(MultipartFile file,String location) throws IOException;

	public List<PictureEntity> getPictures();

}
