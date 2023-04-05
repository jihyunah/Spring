package sample03;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("messageBean") //bean을 원하는 아이디로 생성해주는 어노테이션 
@Scope("prototype") //싱글톤 아닌 타입으로 만들어주겠다 
public class MessageBeanKo implements MessageBean {

	private int num; //필드는 0으로 자동 초기화 
	
	
	
	public MessageBeanKo() {
		System.out.println("MessageBeanKo 기본 생성자");
	}
	
	@Override
	public void sayHello(String name) {
		num++;
		System.out.println("num = " + num);
		System.out.println("안녕하세요 " + name);
		System.out.println();
		
	}
	
}
