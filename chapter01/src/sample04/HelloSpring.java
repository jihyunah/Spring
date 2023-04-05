package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample01.MessageBean;

public class HelloSpring {

	public static void main(String[] args) {
		// xml 파일 읽어라 
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Calc calc = (Calc) context.getBean("calc");
		calc.calculate(25, 36);
	}

}
