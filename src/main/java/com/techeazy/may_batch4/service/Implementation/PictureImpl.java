package com.techeazy.may_batch4.service.Implementation;

import com.techeazy.may_batch4.entity.PictureEntity;
import com.techeazy.may_batch4.repository.PictureRepository;
import com.techeazy.may_batch4.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service
public class PictureImpl implements PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    private final String uploadDir = "uploads/";


    @Override
    public void savePictures(MultipartFile file,String location) throws IOException {
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            boolean created = dir.mkdirs();
            if (!created) {
                throw new IOException("Failed to create upload directory: " + uploadDir);
            }
        }

        String path = uploadDir+file.getOriginalFilename();
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(file.getBytes());
        fos.close();

        PictureEntity picture = new PictureEntity();
        picture.setFilePath(path);
        picture.setLocation(location);
        picture.setDate(LocalDateTime.now());


        pictureRepository.save(picture);
    }



    @Override
    public List<PictureEntity> getPictures() {
        return pictureRepository.findAll();
    }
}
