package sample02;

public class HelloSpring {

	public static void main(String[] args) {
		//MessageBeanKo messageBeanKo = new MessageBeanKo(); // 1:1 관계, 결합도 100%. messageBeanKo는 얘만 가리킨다.
		
		//다형성, 부모 => 자식 의 관계를 좋아한다. 결합도가 낮아진다. 
		
		MessageBean messageBean = new MessageBeanKo();
		messageBean.sayHello("Spring");
		
		messageBean = new MessageBeanEn();
		messageBean.sayHello("Spring");

	}

}
