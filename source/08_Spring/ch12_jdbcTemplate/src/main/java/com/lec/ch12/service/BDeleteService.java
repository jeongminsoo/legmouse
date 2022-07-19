package com.lec.ch12.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.ch12.dao.BoardDao;

public class BDeleteService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		
		int bid = Integer.parseInt((String)map.get("bid"));
		
		BoardDao dao = BoardDao.getInstance();
		
		int result = dao.delete(bid);
		
		model.addAttribute("deleteResult", result);

	}

}
