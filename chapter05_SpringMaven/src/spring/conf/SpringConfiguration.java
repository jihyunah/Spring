package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration //환경설정 파일 - xml과 같은 취급을 받는 환경설정 파일이다.
@PropertySource("classpath:spring/db.properties")	//클래스 파일의 경로
@EnableTransactionManagement //transaction 설정 
public class SpringConfiguration {
	 //롬복 아님!! 어디다가 정의하던 상관없음.
	private @Value("${jdbc.driver}") String driver;
	
	
	private @Value("${jdbc.url}") String url;
	
	
	private @Value("${jdbc.username}") String username;
	
	
	private @Value("${jdbc.password}") String password;
	
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
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));
		sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("user/dao/userMapper.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate SqlSession() throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		return sqlSessionTemplate;
		
	}
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
		
	}
	
}

//SpringConfiguration은 일반 자바 파일이 아니다
//applicationContext.xml과 같은 취급을 받는 환경설정 파일이다.