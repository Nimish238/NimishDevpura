package com.techeazy.may_batch4.rest;

import java.util.List;

import com.techeazy.may_batch4.entity.PictureEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.techeazy.may_batch4.service.PictureService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/picture")
public class PictureController {

	@Autowired
	private PictureService pictureService;

	@GetMapping(value = "/getAll")
	public List<PictureEntity> getAll() {
		return pictureService.getPictures();

	}

	@PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file,
										 @RequestParam String location
	)  throws Exception{

		pictureService.savePictures(file,location);
		return ResponseEntity.ok( "Image uploaded and saved");
	}
}