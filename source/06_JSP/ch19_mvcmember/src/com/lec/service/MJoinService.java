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
		String mid = mr.getParameter("mid");
		String mpw = mr.getParameter("mpw");
		String mpwchk = mr.getParameter("mpwChk");
		String mname = mr.getParameter("mname");
		String memail = mr.getParameter("memail");
		String mphoto = image == null ? "NOIMG.JPG" : image;
		String tempbirth = mr.getParameter("tempbirth");
		Date mbirth = null;
		if (!tempbirth.equals("")) {
			mbirth = Date.valueOf(tempbirth);
		}
		String maddress = mr.getParameter("maddress");
		
		MemberDao dao = MemberDao.getInstance();
		int result = dao.idChk(mid);
		
		if (result == MemberDao.ID_NONEXISTENT) {
			if (mpw.equals(mpwchk)) {
				MemberDto member = new MemberDto();
				member.setMid(mid);
				member.setMpw(mpw);
				member.setMname(mname);
				member.setMemail(memail);
				member.setMphoto(mphoto);
				member.setMbirth(mbirth);
				member.setMaddress(maddress);
				result = dao.joinMember(member);
				if (result == MemberDao.SUCCESS) {
					HttpSession session = request.getSession();
					session.setAttribute("id", mid);
				}
			} else {
				result = 4;
			}
		}
		request.setAttribute("joinResult", result);
	}
}
