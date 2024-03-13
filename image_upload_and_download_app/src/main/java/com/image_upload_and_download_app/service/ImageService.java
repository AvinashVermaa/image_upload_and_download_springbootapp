package com.image_upload_and_download_app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageService {

	public String uploadImage(MultipartFile file) throws Exception;
	public byte[] downloadImage(String imageName) throws Exception;
	public byte[] downloadImageById(Long id) throws Exception;
}
