package com.it.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.icu.text.SimpleDateFormat;
import com.it.constants.Constants;

public class Utils {
	
	public static void moveFile(MultipartFile file, String fileName, String pathType) throws IOException {

		if(null != file && StringUtils.isNotBlank(file.getOriginalFilename())) {

			Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
			
			String outputPathStr = path + File.separator + Constants.PATH_FOLDER_UPLOAD + File.separator + pathType + File.separator  + fileName;
			file.transferTo( new File(outputPathStr));
		}
	}
	
	public static void deleteFile( String fileName, String pathType) throws IOException {

		if(StringUtils.isNotBlank(fileName)) {
			
			Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
			
			String filePath = path + File.separator + Constants.PATH_FOLDER_UPLOAD + File.separator + pathType + File.separator  + fileName;
			
			File myObj = new File(filePath);
			
			if(null != myObj) {
				myObj.delete();
			}
		}
	}
	
	public static void copyFile( String fileName, String pathType, String prefixClone) throws IOException {
		
		if(StringUtils.isNotBlank(fileName)) {
			Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
			String filePathOld = path + File.separator + Constants.PATH_FOLDER_UPLOAD + File.separator + pathType + File.separator  + fileName;
			String fileCopiedPath = path + File.separator + Constants.PATH_FOLDER_UPLOAD + File.separator + pathType + File.separator  + prefixClone + fileName;
			
			File original = new File(filePathOld);
			File copied = new File(fileCopiedPath);
			
			FileCopyUtils.copy(original, copied);
		}
		 
	}
	
	public static String genaratePrefixFile() {

		Calendar today = Calendar.getInstance();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		String date = format1.format(today.getTime());
		Random random = new Random();  

		return date + "_" + random.nextInt(99999) + "_";
	}
	
	public static String concatStr(String main, String other) {
		
		return main.concat(other);
	}
}
