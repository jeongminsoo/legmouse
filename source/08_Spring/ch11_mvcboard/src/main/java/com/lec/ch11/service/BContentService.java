package com.lec.ch11.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;
import com.lec.ch11.dto.BoardDto;

public class BContentService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		
		int bid = Integer.parseInt((String)map.get("bid"));
		
		BoardDao dao = BoardDao.getInstance();
		
		BoardDto dto = dao.contentView(bid);
		model.addAttribute("content", dto);

	}

}
