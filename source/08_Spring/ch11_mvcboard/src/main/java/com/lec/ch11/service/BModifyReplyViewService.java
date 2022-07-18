package com.lec.ch11.service;

import java.util.Map;


import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;
import com.lec.ch11.dto.BoardDto;

public class BModifyReplyViewService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int bid = Integer.parseInt((String)map.get("bid"));
		BoardDao dao = BoardDao.getInstance();
		BoardDto dto = dao.modifyView_replyView(bid);
		
		model.addAttribute("bDto", dto);
		

	}

}
