package com.lec.ch17.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {

	private int bno;
	private String bname;
	private String btitle;
	private String bcontent;
	private Date brdate;
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	private String bip;
	private int startRow;
	private int endRow;
}
