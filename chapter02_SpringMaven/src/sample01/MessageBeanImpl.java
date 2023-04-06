package sample01;

import java.util.zip.CheckedOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



//@Component //bean 생성하는 어노테이션. --> 생성자는 자동호출됨.

public class MessageBeanImpl implements MessageBean {
	private String fruit; //생성자로 받아오기 
	private int cost, qty; //setter로 받아오기 
	
	// Constructor Injection = fruit을 생성자 통해 받아오기 
	public MessageBeanImpl(@Value("사과") String fruit) {
		super(); //부모 생성자 부르는 코드.
		this.fruit = fruit;
	}
	
	@Autowired //bean 생성할 때 setCost도 같이 불러줘.
	 //Setter Injection = setter로 받아오기 
	public void setCost(@Value("5000") int cost) {
		this.cost = cost;
	}

	@Autowired //bean 생성할 때 setQty도 같이 불러줘.
	public void setQty(@Value("3") int qty) {
		this.qty = qty;
	}



	@Override
	public void sayHello() {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
		
	}

	@Override
	public void sayHello(String fruit, int cost) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
		
	}

	@Override
	public void sayHello(String fruit, int cost, int qty) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
		
	}

}
