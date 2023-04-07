package spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample01.MessageBeanImpl;
import sample02.CalcAdd;
import sample02.CalcMul;
import sample04.SungJukDTO2;

@Configuration //bean을 생성시킬 수 있는 환경설정파일이다. application.xml과 같은 역할의 파일.
public class SpringConfiguration {
	
	// sample01
	@Bean
	public MessageBeanImpl 메소드명() {
		return new MessageBeanImpl("사과");
	}
	
	// sample02
	@Bean
	public CalcAdd calcAdd(){
		return new CalcAdd(22, 55);
	}
	
//	@Bean
//	public CalcMul calcMul() {
//		return new CalcMul();
//	}
	
	@Bean(name="calcMul")
	public CalcMul getCalcMul() {
		return new CalcMul();
	}
	
	//sample04 
	
	@Bean //Autowired에서 자동으로 여기 bean값을 가져감. 
	//public ArrayList<SungJukDTO2> arrayList() {
	public List<SungJukDTO2> arrayList(){ //다형성. 부모 -> 자식 
		return new ArrayList<SungJukDTO2>();
	}

	

}

/* 
 * @Bean
 * - 메소드에서 return 되는 값을 빈으로 생성해준다.
 * - 메소드의 이름은 반드시 빈의 id명으로 만들어야 한다. 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
 