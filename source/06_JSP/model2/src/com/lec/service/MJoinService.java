package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("mPhotoUp");
		int maxSize = 1024*1024*5;
		String mphoto = "";
		MultipartRequest mr = null;
		
		try {
			mr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramName = mr.getFileNames();
			String param = paramName.nextElement();
			mphoto = mr.getFilesystemName(param);
			
			String mid = mr.getParameter("mid");
			String mpw = mr.getParameter("mpw");
			String mname = mr.getParameter("mname");
			String memail = mr.getParameter("memail");
			mphoto = (mphoto == null) ? "NOIMG.JPG" : mphoto;
			String tempbirth = mr.getParameter("tempbirth");
			Date mbirth = null;
			if (!tempbirth.equals("")) {
				mbirth = Date.valueOf(tempbirth); 
			}
			String maddress = mr.getParameter("maddress");
			
			MemberDao dao = MemberDao.getInstance();
			MemberDto dto = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
			int result = dao.joinMember(dto);
			
			if (result == MemberDao.SUCCESS) {
				HttpSession session = request.getSession();
				session.setAttribute("mid", mid);
			}
			request.setAttribute("joinResult", result);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		File serverFile = new File(path + "/" + mphoto);
		if (serverFile.exists() && !mphoto.equals("NOIMG.JPG")) {
			InputStream is = null;
			OutputStream os = null;
			
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/webPro_jeong/source/06_JSP/model2/WebContent/mPhotoUp/" + mphoto);
				byte[] bs = new byte[(int)serverFile.length()];
				while (true) {
					int readCnt = is.read(bs);
					if (readCnt == -1) {
						break;
					}
					os.write(bs, 0, readCnt);
				}
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
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
		}
	}

}
