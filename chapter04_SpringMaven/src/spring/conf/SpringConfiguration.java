package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration //환경설정 파일 - xml과 같은 취급을 받는 환경설정 파일이다.
@PropertySource("classpath:spring/db.properties")	//클래스 파일의 경로
public class SpringConfiguration {
	@Value("${jdbc.driver}") //롬복 아님!! 어디다가 정의하던 상관없음.
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource basicDataSource = new BasicDataSource();
		
		//basicDataSource.setDriverClassName("oralce.jdbc.driver.ORacleDriver");
		// 이렇게 사용해도 된다.
		
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		
		return basicDataSource;
	}
	
}

//SpringConfiguration은 일반 자바 파일이 아니다
//applicationContext.xml과 같은 취급을 받는 환경설정 파일이다.