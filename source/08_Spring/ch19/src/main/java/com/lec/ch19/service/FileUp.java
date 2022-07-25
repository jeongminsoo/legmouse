package com.lec.ch19.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Service
public class FileUp {

	public boolean fileup(MultipartHttpServletRequest mr, ModelAndView mav) {
		boolean upload = false;
		
		String uploadPath = mr.getRealPath("bookImgFileUpload/");
		String backupPath = "D:/webPro_jeong/source/08_Spring/ch19/src/main/webapp/bookImgFileUpload/";
		String [] filenames = new String[2];
		
		int i = 0;
		Iterator<String> params = mr.getFileNames();
		
		while (params.hasNext()) {
			String param = params.next();
			MultipartFile mf = mr.getFile(param);
			filenames[i] = mf.getOriginalFilename();
			if (filenames[i] != null && !filenames[i].equals("")) {
				if (new File(uploadPath + filenames[i]).exists()) {
					filenames[i] = System.currentTimeMillis() + filenames[i];
				}
				try {
					mf.transferTo(new File(uploadPath + filenames[i]));
					upload = filecopy(uploadPath + filenames[i], backupPath + filenames[i]);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			i++;
		}
		
		return upload;
	}
	
	private boolean filecopy(String serverFile, String backupFile) {
		boolean copy = false;
		
		InputStream is = null;
		OutputStream os = null;
		
		File file = new File(serverFile);
		try {
			is = new FileInputStream(serverFile);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int)file.length()];
			while (true) {
				int readByte = is.read(buff);
				if (readByte == -1) {
					break;
				}
				os.write(buff, 0, readByte);
			}
			copy = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return copy;
	}
}
