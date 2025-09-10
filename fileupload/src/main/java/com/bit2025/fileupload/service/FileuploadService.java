package com.bit2025.fileupload.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileuploadService {

	// 저장 디렉토리 위치
	private static final String SAVE_PATH = "/fileupload-uploads";
	private static final String URL = "/images";

	public String restore(MultipartFile multipartFile) throws RuntimeException {
		try {
			File uploadDirectory = new File(SAVE_PATH);

			// 디렉토리가 존재하지 않으면 생성
			if (!uploadDirectory.exists() && !uploadDirectory.mkdirs()) {
				return null;
			}
			if (multipartFile.isEmpty()) {
				return null;
			}
			
			// 사용자가 올린 원본 파일 이름
			String originalFileName = multipartFile.getOriginalFilename();
			// 원본 파일의 확장자명 찾기
			String extName = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
			// 실제로 저장할 파일 이름 만들기
			String saveFilename = generateSaveFilename(extName);
			long fileSize = multipartFile.getSize();

			System.out.println("originalFileName: " + originalFileName);
			System.out.println("fileSize: " + fileSize);

			// 임시 파일에 저장된 내용
			byte[] data = multipartFile.getBytes();

			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
			os.write(data);
			os.close();

			return URL + "/" + saveFilename;
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private String generateSaveFilename(String extName) {
		// 현재 날짜
		Calendar calendar = Calendar.getInstance();
		
		return "" 
				+ calendar.get(Calendar.YEAR) 
				+ calendar.get(Calendar.MONTH) 
				+ calendar.get(Calendar.DATE)
				+ calendar.get(Calendar.HOUR) 
				+ calendar.get(Calendar.MINUTE) 
				+ calendar.get(Calendar.SECOND)
				+ calendar.get(Calendar.MILLISECOND) 
				+ ("." + extName);
	}

}
