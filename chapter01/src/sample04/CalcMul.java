package sample04;

public class CalcMul implements Calc {
	private int mul;
	
	@Override
	public void calculate(int x, int y) {
		mul = x * y;
		System.out.println(x + " * " + y + " = " + mul);
		System.out.println();
	}

}
