package com.lec.ch16.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch16.dto.Emp;

@Mapper
public interface EmpDao {

	public List<Emp> empList(Emp schEmp);
}
