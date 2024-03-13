package com.image_upload_and_download_app.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long>{

	Optional<Image> findImageByName(String name);
}
