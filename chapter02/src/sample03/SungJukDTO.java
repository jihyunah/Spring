package sample03;

import lombok.Getter;
import lombok.Setter;
	
@Getter
@Setter
public class SungJukDTO{
	private String name;
	private int kor, eng, math, sum;
	private double avg;
	
	@Override
	public String toString() {
		return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + sum + "\t" + String.format("%.3f", avg);
	}
	
	
	
	
}
