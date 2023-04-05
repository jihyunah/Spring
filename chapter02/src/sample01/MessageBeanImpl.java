package sample01;

import java.util.zip.CheckedOutputStream;

import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class MessageBeanImpl implements MessageBean {
	@NonNull //바로 밑에 줄 fruit만 non null로 생성자 잡아줌. 
	private String fruit; //생성자로 받아오기 
	@Setter //바로 밑에 줄 cost, qty만 setter가 잡힘. 
	private int cost, qty; //setter로 받아오기 
	
	// Constructor Injection = fruit을 생성자 통해 받아오기 
//	public MessageBeanImpl(String fruit) {
//		super(); //부모 생성자 부르는 코드.
//		this.fruit = fruit;
//	}
	
	// Setter Injection = setter로 받아오기 
//	public void setCost(int cost) {
//		this.cost = cost;
//	}
//
//	public void setQty(int qty) {
//		this.qty = qty;
//	}



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
