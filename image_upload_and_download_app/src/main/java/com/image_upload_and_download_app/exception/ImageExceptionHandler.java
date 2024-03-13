package com.image_upload_and_download_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public interface ImageExceptionHandler {

	@ExceptionHandler(Exception.class)
	public static  ResponseEntity<String> handleException(Exception ex){
		//Log the exception
		ex.printStackTrace();
		
		//Return the appropriate response to the client:
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexcepeceted error occurred...");
	}
	
}
