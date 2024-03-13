package com.image_upload_and_download_app.exception;

public class ImageNotFoundException extends RuntimeException{

	private String imageName;
	private String status;
	
	
	public ImageNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ImageNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	public ImageNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ImageNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public ImageNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public ImageNotFoundException(String imageName, String status) {
		super();
		this.imageName = imageName;
		this.status = status;
	}
	@Override
	public String toString() {
		return "ImageNotFoundException [imageName=" + imageName + ", status=" + status + "]";
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
