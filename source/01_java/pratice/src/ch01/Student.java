package ch01;

public class Student {

	public static int serialNum;
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private int avg;
	
	public Student() {
	}

	public Student(String name, int kor, int eng, int math) {
		num = ++serialNum;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor + eng + math;
		avg = total / 3;
	}
	public void print() {
		System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%d\n",
				getNum(), getName(), getKor(), getEng(), getMath(), getTotal(), getAvg());
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
