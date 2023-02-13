package com.it.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import com.it.constants.Constants;


@Service
public class LoadingService {

	
	public byte[] getImage(String fileName) throws IOException {
		
		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		String filePath = path + File.separator + Constants.PATH_FOLDER_UPLOAD + File.separator + Constants.PATH_TYPE_INPUT + File.separator + fileName;
		File file = new File(filePath);
		FileInputStream fl = new FileInputStream(file);
        return StreamUtils.copyToByteArray(fl);
	}
}
