package com.image_upload_and_download_app.utils;

import java.io.ByteArrayOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public interface ImageUtils {

	public static final int BIT_SIZE = 1000*1024;
	
	public static byte[] compressImage(byte[] data) throws Exception {
		Deflater deflater = new Deflater();
		deflater.setLevel(Deflater.BEST_COMPRESSION);
		deflater.setInput(data);
		deflater.finish();
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream(data.length);
		byte[] temp = new byte[BIT_SIZE];
		
		while(!deflater.finished()) {
			int size = deflater.deflate(temp);
			stream.write(temp, 0, size);
		}
		
		stream.close();
		return stream.toByteArray();
	}
	
	
	public static byte[] decompressImage(byte[] data) throws Exception {
		Inflater flater = new Inflater();
		flater.setInput(data);
		ByteArrayOutputStream stream = new ByteArrayOutputStream(data.length);
		byte[] temp = new byte[BIT_SIZE];
		
		while(!flater.finished()) {
			int size = flater.inflate(temp);
			stream.write(temp, 0, size);
		}
		stream.close();
		
		return stream.toByteArray();
		
	}
	
}
