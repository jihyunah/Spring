package sample02;

import lombok.Setter;

public class CalcMul implements Calc {
	@Setter
	private int x, y;
	
	@Override
	public void calculate(int x, int y) {
		System.out.println(x + " * " + y + " = " + (x*y));
		System.out.println();

	}

}
