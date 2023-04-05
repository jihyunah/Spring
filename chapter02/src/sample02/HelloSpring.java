package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample02.Calc;

public class HelloSpring {

	public static void main(String[] args) {
		// xml 파일 읽어라 
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Calc calc = (Calc) context.getBean("calcAdd");
		calc.calculate(25, 36);
		
		calc = (Calc) context.getBean("calcMul");
		calc.calculate(25, 36);
	}

}
