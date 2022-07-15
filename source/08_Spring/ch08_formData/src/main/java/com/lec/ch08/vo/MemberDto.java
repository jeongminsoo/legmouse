package com.lec.ch08.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

	private String id;
	private String pw;
	private String name;
	private int age;
	private String email;
	private String address;
	
	// formData 사용을 위해 getter, 기본 생성자 필요
}
