package sample05;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample04.Calc;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SungJuk sungjuk = (SungJuk) context.getBean("sungJukImpl"); //calc 빈을 생성하기. 
		
		
		sungjuk.calc(); //함수 호출해오기.
		sungjuk.display();
	}

}
