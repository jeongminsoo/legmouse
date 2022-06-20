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

public class MModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("imgcopy");
		int maxSize = 1024*1024;
		String image = "";
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramName = mr.getFileNames();

			String param = paramName.nextElement();
			image = mr.getFilesystemName(param);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		File serverfile = new File(path + "/" + image);
		if (serverfile.exists() && !image.equals("NOIMG.JPG")) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverfile);
				os = new FileOutputStream("D:/webPro_jeong/source/06_JSP/ch19_mvcmember/WebContent/imgcopy/" + image);
				byte[] bs = new byte[(int)serverfile.length()];
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
		HttpSession session = request.getSession();
		MemberDto dto = (MemberDto) session.getAttribute("member");
		
		
		String oldpw = mr.getParameter("oldpw");
		String mpw = mr.getParameter("mpw");
		String mpwchk = mr.getParameter("mpwChk");
		if (mpw.equals("") && mpwchk.equals("")) {
			mpw = oldpw;
			mpwchk = oldpw;
		}
		String mname = mr.getParameter("mname");
		String memail = mr.getParameter("memail");
		String mphoto = image == null ? dto.getMphoto() : image;
		String tempbirth = mr.getParameter("tempbirth");
		Date mbirth = null;
		if (!tempbirth.equals("")) {
			mbirth = Date.valueOf(tempbirth);
		}
		String maddress = mr.getParameter("maddress");
		
		MemberDao dao = MemberDao.getInstance();
		int result;
		if (dto.getMpw().equals(oldpw)) {
			if (mpw.equals(mpwchk)) {
				dto.setMpw(mpw);
				dto.setMname(mname);
				dto.setMemail(memail);
				dto.setMphoto(mphoto);
				dto.setMbirth(mbirth);
				dto.setMaddress(maddress);
				result = dao.modifyMember(dto);
				if (result == MemberDao.SUCCESS) {
					session.removeAttribute("member");
					session.setAttribute("member", dto);
				} 
			} else {
				result = 4;
			}
		} else {
			result = 5;
		}
		
		
		
		request.setAttribute("modifyResult", result);

	}

}
