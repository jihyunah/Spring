package spring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample01.MessageBeanImpl;

@Configuration //bean을 생성시킬 수 있는 환경설정파일이다. application.xml과 같은 역할의 파일.
public class SpringConfiguration {
	
	// sample01
	@Bean
	public MessageBeanImpl 메소드명() {
		return new MessageBeanImpl("사과");
	}
	
	// sample02
	

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
 