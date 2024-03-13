package com.image_upload_and_download_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.image_upload_and_download_app.entity.Image;
import com.image_upload_and_download_app.entity.ImageRepo;
import com.image_upload_and_download_app.exception.ImageNotFoundException;
import com.image_upload_and_download_app.utils.ImageUtils;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepo imageRepo;

	@Override
	public String uploadImage(MultipartFile file) throws Exception {
		Image img = new Image();
		img.setName(file.getOriginalFilename());
		img.setType(file.getContentType());
		img.setImageData(ImageUtils.compressImage(file.getBytes()));

		imageRepo.save(img);

		return "Image Saved successfully,fileName : " + file.getOriginalFilename();
	}

	@Override
	public byte[] downloadImage(String imageName) throws Exception {
		Image image = imageRepo.findImageByName(imageName)
				.orElseThrow(() -> new ImageNotFoundException(imageName, "Image Not Found"));

		byte[] imageData = ImageUtils.decompressImage(image.getImageData());

		return imageData;
	}

	@Override
	public byte[] downloadImageById(Long id) throws Exception {
		Image image = imageRepo.findById(id).orElseThrow(
				()-> new ImageNotFoundException(id.toString(), "Image Not Found with Id : "+id.toString())
				);
		
		byte[] imageData = ImageUtils.decompressImage(image.getImageData());
		
		return imageData;
	}

}
