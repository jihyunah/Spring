package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		
		//xml파일 읽어라.
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MessageBean messageBean = (MessageBean) context.getBean("messageBean"); //bean의 (주소)값을 꺼내와라 (괄호에는 id이름 적기)
		messageBean.sayHello("Spring");
		
		MessageBean messageBean2 = context.getBean("messageBean", MessageBean.class); //bean의 (주소)값을 꺼내와라 (괄호에는 id이름 적기)
		messageBean2.sayHello("Spring");
		
		MessageBean messageBean3 = (MessageBean) context.getBean("messageBean"); //bean의 (주소)값을 꺼내와라 (괄호에는 id이름 적기)
		messageBean3.sayHello("Spring");
	}

}
