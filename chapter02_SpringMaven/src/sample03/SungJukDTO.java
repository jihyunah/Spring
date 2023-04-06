package sample03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SungJukDTO{
	private String name;
	private int kor, eng, math, sum;
	private double avg;
	
	
	
	public String getName() {
		return name;
	}


	@Autowired
	public void setName(@Value("홍길동") String name) {
		this.name = name;
	}



	public int getKor() {
		return kor;
	}


	@Autowired
	public void setKor(@Value("97") int kor) {
		this.kor = kor;
	}



	public int getEng() {
		return eng;
	}


	@Autowired
	public void setEng(@Value("100") int eng) {
		this.eng = eng;
	}



	public int getMath() {
		return math;
	}


	@Autowired
	public void setMath(@Value("95") int math) {
		this.math = math;
	}



	public int getSum() {
		return sum;
	}



	public void setSum(int sum) {
		this.sum = sum;
	}



	public double getAvg() {
		return avg;
	}



	public void setAvg(double avg) {
		this.avg = avg;
	}



	@Override
	public String toString() {
		return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + sum + "\t" + String.format("%.3f", avg);
	}
	
	
	
	
}
