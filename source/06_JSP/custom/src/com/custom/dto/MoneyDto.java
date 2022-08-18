package com.custom.dto;

import java.sql.Date;

public class MoneyDto {

	private int saleno;
	private int custno;
	private int cost;
	private int amount;
	private int price;
	private String pcode;
	private Date sdate;
	private String custname;
	private String gname;
	private int total;
	
	public MoneyDto() {
		
	}
	
	public MoneyDto(int saleno, int custno, int cost, int amount, int price, String pcode, Date sdate, String custname,
			String gname, int total) {
		this.saleno = saleno;
		this.custno = custno;
		this.cost = cost;
		this.amount = amount;
		this.price = price;
		this.pcode = pcode;
		this.sdate = sdate;
		this.custname = custname;
		this.gname = gname;
		this.total = total;
	}

	public int getSaleno() {
		return saleno;
	}

	public void setSaleno(int saleno) {
		this.saleno = saleno;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
