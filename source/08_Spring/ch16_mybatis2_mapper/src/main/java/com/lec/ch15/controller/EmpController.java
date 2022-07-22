package com.lec.ch15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch15.model.Emp;
import com.lec.ch15.service.EmpService;
import com.lec.ch15.util.Paging;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping(value="empDeptList", method = {RequestMethod.GET, RequestMethod.POST})
	public String empList(String pageNum, Model model) {
		model.addAttribute("empDeptList", empService.empDeptList(pageNum));
		model.addAttribute("paging", new Paging(empService.totCnt(), pageNum, 10, 5));
		return "empDeptList";
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String detail(String pageNum, int empno, Model model) {
		model.addAttribute("detail", empService.detail(empno));
		model.addAttribute("pageNum", pageNum);
		return "detail";
	}
	
	@RequestMapping(value="dummy", method = RequestMethod.GET)
	public String dummy() {
		empService.dummy();
		return "redirect:empDeptList.do";
	}
	
	@RequestMapping(value="insertView", method = RequestMethod.GET)
	public String insertGet(Model model) {
		model.addAttribute("managerList", empService.managerList());
		model.addAttribute("deptList", empService.deptList());
		return "insert";
	}
	
	@RequestMapping(value="insert", method = RequestMethod.POST)
	public String insertPost(Emp emp, Model model) {
		try {
			model.addAttribute("insertResult", empService.insert(emp));
		} catch (Exception e) {
			model.addAttribute("insertResult", "필드값이 너무 길어 등록 불가");
			return "forward:insertView.do";
		}
		
		return "forward:empDeptList.do";
	}
	
	@RequestMapping(value="updateView", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateGet(String pageNum, int empno, Model model) {
		model.addAttribute("detail", empService.detail(empno));
		model.addAttribute("managerList", empService.managerList());
		model.addAttribute("deptList", empService.deptList());
		return "update";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String updatePost(String pageNum, Emp emp, Model model) {
		try {
			model.addAttribute("updateResult", empService.update(emp));
			model.addAttribute("pageNum", pageNum);
		} catch (Exception e) {
			model.addAttribute("updateResult", "필드 값이 너무 깁니다. 수정 실패");
			return "forward:updateView.do";
		}
		return "forward:empDeptList.do";
	}
	
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String delete(int empno, Model model) {
		model.addAttribute("deleteResult", empService.delete(empno));
		return "forward:empDeptList.do";
	}
	
	@RequestMapping(value="confirmNo", method = RequestMethod.GET)
	public String confirmNo(Emp emp, Model model) {
		if (empService.detail(emp.getEmpno()) == null) {
			model.addAttribute("msg", "사용가능한 사번입니다");
		} else {
			model.addAttribute("msg", "중복된 사번입니다");
		}
		return "forward:insertView.do";
	}
}
