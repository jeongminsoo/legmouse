package com.lec.ex3_student;

public class StudentDto {

	private String rank;
	private int sno;
	private String sName;
	private String mName;
	private int score;
	private int expel;
	
	public StudentDto() {
		
	}

	// 입력용
	public StudentDto(int sno, String sName, String mName, int score, int expel) {
		this.sno = sno;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
		this.expel = expel;
	}


	// 출력용
	public StudentDto(String rank, int sno, String sName, String mName, int score) {
		this.rank = rank;
		this.sno = sno;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}
	// 학생출력
	public StudentDto(String rank, String sName, String mName, int score) {
		this.rank = rank;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}
	// 제적자출력
	public StudentDto(String rank, String sName, String mName, int score, int expel) {
		this.rank = rank;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
		this.expel = expel;
	}
	// 학생수정 , 이름검색
	public StudentDto(int sno, String sName, String mName, int score) {
		this.sno = sno;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}
	// 학생입력
	public StudentDto(String sName, String mName, int score) {
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}
	
	
	
	@Override
	public String toString() {
		
		if (rank != null) {
			return rank + "\t" + sName + "\t" + mName + "\t" + score + "\n";
		} else {
			return sno + "\t" + sName + "\t" + mName + "\t" + score + "\n";
		}
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getExpel() {
		return expel;
	}

	public void setExpel(int expel) {
		this.expel = expel;
	}

}
