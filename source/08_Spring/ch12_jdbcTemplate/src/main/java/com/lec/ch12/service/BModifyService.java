package com.lec.ch12.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lec.ch12.dao.BoardDao;
import com.lec.ch12.dto.BoardDto;

public class BModifyService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		BoardDto dto = (BoardDto) map.get("dto");
		
		String bip = request.getRemoteAddr();
		
		dto.setBip(bip);
		BoardDao dao = BoardDao.getInstance();
		
		int result = dao.modify(dto);
		
		model.addAttribute("modifyResult", result);
		

	}

}