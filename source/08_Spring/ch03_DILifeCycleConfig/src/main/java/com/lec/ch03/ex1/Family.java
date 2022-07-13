package com.lec.ch03.ex1;

import lombok.Data;

@Data
public class Family {

	private String papa;
	private String mama;
	private String sister;
	private String brother;
	
	public Family(String papa, String mama) {
		this.papa = papa;
		this.mama = mama;
	}
	
}
