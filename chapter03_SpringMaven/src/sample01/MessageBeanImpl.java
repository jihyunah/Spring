package sample01;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MessageBeanImpl implements MessageBean {
	//MessageBeanImpl이 타겟 클래스. 
	// override 된 함수들이 조인 포인트.
	// 적용될 함수 위에 두개만이 포인트 컷임.
	
	private String str;

	public void setStr(@Value("Have a nice day!!") String str) {
		this.str = str;
	}

	@Override
	public void showPrintBefore() {
		
		System.out.println("showPrintBefore 메세지 = " + str); //핵심 코드 

	}

	@Override
	public void viewPrintBefore() {
		try {
			Thread.sleep(1000); //1초 - 단위 1/1000초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintBefore 메세지 = " + str); //핵심 코드 

	}


	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter 메세지 = " + str); //핵심 코드 
		
	}

	@Override
	public void viewPrintAfter() {
		try {
			Thread.sleep(1000); //1초 - 단위 1/1000초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintAfter 메세지 = " + str); //핵심 코드 
		
	}
	

	@Override
	public String showPrint() {
		System.out.println("showPrint 메세지 = " + str); //핵심 코드 
		return "스프링";
		
	}

	@Override
	public void viewPrint() {
		try {
			Thread.sleep(1000); //1초 - 단위 1/1000초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrint 메세지 = " + str); //핵심 코드 
		
	}
	
	@Override
	public void display() {
		System.out.println("display 메세지 = " + str); //핵심 코드 

	}

}
