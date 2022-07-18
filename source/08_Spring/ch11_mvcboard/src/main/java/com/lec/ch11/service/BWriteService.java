package com.lec.ch11.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;
import com.lec.ch11.dto.BoardDto;

public class BWriteService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		BoardDto dto = (BoardDto)map.get("dto");
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bip = request.getRemoteAddr();
		dto.setBip(bip);
		BoardDao dao = BoardDao.getInstance();
		model.addAttribute("writeResult", dao.write(dto));
	}

}
