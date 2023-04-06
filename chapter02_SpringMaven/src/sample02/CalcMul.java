package sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component //bean 생성 (생성자)
public class CalcMul implements Calc {
	private int x, y;
	
	@Autowired //bean 생성할 때 setX도 같이 불러줘.
	public void setX(@Value("25") int x) {
		this.x = x;
	}
	
	@Autowired //bean 생성할 때 setY도 같이 불러줘.
	public void setY(@Value("36") int y) {
		this.y = y;
	}

	@Override
	public void calculate() {
		System.out.println(x + " * " + y + " = " + (x*y));
		System.out.println();

	}

}
