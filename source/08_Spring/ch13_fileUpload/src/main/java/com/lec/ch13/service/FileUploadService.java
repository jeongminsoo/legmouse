package com.lec.ch13.service;

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
public class FileUploadService {

	public boolean Fileup(MultipartHttpServletRequest mRequest, ModelAndView mav) {
		boolean isUpload = false;
		
		String uploadPath = mRequest.getRealPath("upload/");
		String backupPath = "D:/webPro_jeong/source/08_Spring/ch13_fileUpload/src/main/webapp/upload/";
		String[] filenames = new String[3];
		
		int i = 0;
		Iterator<String> params = mRequest.getFileNames();
		while (params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			filenames[i] = mFile.getOriginalFilename(); // param으로 첨부파일의 오리지널 파일명
			if (filenames[i] != null && !filenames[i].equals("")) { // 첨부한 파일이 있을 경우
				if (new File(uploadPath + filenames[i]).exists()) {
					filenames[i] = System.currentTimeMillis() + filenames[i];
				}
				try {
					mFile.transferTo(new File(uploadPath+filenames[i]));  // 서버에 파일 저장
					isUpload = filecopy(uploadPath + filenames[i], backupPath + filenames[i]);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			i++;
		}
		mav.addObject("filenames", filenames);
		
		return isUpload;
	}

	private boolean filecopy(String serverFile, String backupFile) {
		
		boolean isCopy = false;
		InputStream is = null;
		OutputStream os = null;
		
		try {
			File file = new File(serverFile);
			is = new FileInputStream(serverFile);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int)file.length()];
			while (true) {
				int nReadByte = is.read(buff);
				if (nReadByte == -1) {
					break;
				}
				os.write(buff, 0, nReadByte);
			}
			isCopy = true;
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
		
		return isCopy;
	}
}
