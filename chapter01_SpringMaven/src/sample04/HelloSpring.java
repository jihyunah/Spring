package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloSpring {

	public static void main(String[] args) {
		// xml 파일 읽어라 
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Calc calc = (Calc) context.getBean("calcAdd"); //calc 빈을 생성하기. 
		calc.calculate(25, 36); //함수 호출해오기.
		
		calc = context.getBean("calcMul", Calc.class);
		calc.calculate(25, 36);
	}

}
