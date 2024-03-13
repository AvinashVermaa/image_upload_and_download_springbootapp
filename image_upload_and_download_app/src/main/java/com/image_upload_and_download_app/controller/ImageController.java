package com.image_upload_and_download_app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.image_upload_and_download_app.entity.ImageRepo;
import com.image_upload_and_download_app.service.ImageService;

import jakarta.servlet.annotation.MultipartConfig;

@RestController
@RequestMapping("/image")
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	@PostMapping("/saveImage")
	public ResponseEntity<String> saveImage(@RequestParam("image") MultipartFile file) throws Exception{
		String message = imageService.uploadImage(file);
		return ResponseEntity.status(HttpStatus.CREATED).body("Image Saved successfully...");
		
	}
	
	@GetMapping("/{getImage}")
	public ResponseEntity<?> downloadImage(@PathVariable("getImage") String imageName) throws Exception{
		byte[] imageData = imageService.downloadImage(imageName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.IMAGE_JPEG)
				.body(imageData);
	}
	
	@GetMapping("/getImage/{id}")
	public ResponseEntity<?> getImageById(@PathVariable("id") Long id) throws Exception{
		byte[] imageData = imageService.downloadImageById(id);
		return ResponseEntity.status(HttpStatus.OK).
				contentType(MediaType.IMAGE_JPEG).body(imageData);
	}
	
}
