package sample04;

public class CalcAdd implements Calc {
	private int sum;
	
	
	@Override
	public void calculate(int x, int y) {
		sum = x + y;
		System.out.println(x + " + " + y + " = " + sum);
		System.out.println();
	}

}
