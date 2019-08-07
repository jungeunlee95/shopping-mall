package com.cafe24.shoppingmall.frontend.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileuploadService {

	private static final String SAVE_PATH = "/shoppingmall-uploads"; // d드라이브
	private static final String URL = "/image";
	
	public String restore(MultipartFile multipartFile) {
		String url = "";
		try {
			if(multipartFile.isEmpty()) {
				return url;
			}
			
			String originalFilename = multipartFile.getOriginalFilename();
			
			String extName = originalFilename.substring(originalFilename.lastIndexOf('.')+1);
			String saveFileName = generateSaveFileName(extName);
			
			long fileSize = multipartFile.getSize();
			
//			System.out.println("#############" + originalFilename);
//			System.out.println("#############" + extName);
//			System.out.println("#############" + saveFileName);
//			System.out.println("#############" + fileSize);
		
			byte[] fileData = multipartFile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
			os.write(fileData);
			os.close();
			
			url = URL + "/" + saveFileName;
			
		} catch (IOException e) {
			throw new RuntimeException("Fileupload error" + e);
		}
		
		return url;
	}

	private String generateSaveFileName(String extName) {
		String filename = "";
		
		Calendar calendar = Calendar.getInstance();
		//String += 연산은 for문 돌리면안돼!!!! String Buffer로 하던가!
		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += ("." + extName);
		
		return filename;
	}
}







