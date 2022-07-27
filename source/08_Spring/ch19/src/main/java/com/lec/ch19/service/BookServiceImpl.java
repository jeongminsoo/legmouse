package com.lec.ch19.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dao.BookDao;
import com.lec.ch19.dto.Book;
import com.lec.ch19.util.Paging;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> listNewest() {
		return bookDao.listNewest();
	}

	@Override
	public List<Book> listTitle(String pageNum) {
		Paging paging = new Paging(bookDao.countBook(), pageNum, 3, 5);
		Book book = new Book();
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		return bookDao.listTitle(book);
	}

	@Override
	public Book contentBook(int bno) {
		return bookDao.contentBook(bno);
	}

	@Override
	public int add(MultipartHttpServletRequest mr, Book book) {
		
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
					filecopy(uploadPath + filenames[i], backupPath + filenames[i]);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println(filenames[i]);
			i++;
		}
		book.setBimg1(filenames[0]);
		book.setBimg2(filenames[1]);
		return bookDao.add(book);
	}

	@Override
	public int update(MultipartHttpServletRequest mr, Book book) {
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
					filecopy(uploadPath + filenames[i], backupPath + filenames[i]);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			i++;
		}
		book.setBimg1(filenames[0]);
		book.setBimg2(filenames[1]);
		return bookDao.update(book);
	}

	@Override
	public int countBook() {
		return bookDao.countBook();
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
