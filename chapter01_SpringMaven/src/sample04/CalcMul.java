package sample04;

import org.springframework.stereotype.Component;

@Component
public class CalcMul implements Calc {
	//private int mul;
	
	@Override
	public void calculate(int x, int y) {
		//mul = x * y;
		System.out.println(x + " * " + y + " = " + (x*y));
		System.out.println();
	}

}
