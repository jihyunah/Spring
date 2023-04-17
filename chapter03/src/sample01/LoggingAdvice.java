package sample01;

import org.aspectj.lang.ProceedingJoinPoint;

//공통 관심 사항 (중복 코드를 설정)
public class LoggingAdvice {
	public void beforeTrace() {
		System.out.println("before trace");
	}
	
	public void afterTrace() {
		System.out.println("after trace");
	}
	
	//Around
	public void trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//앞에 삽입될 코드 
		System.out.println("하늘");
		
		
		//핵심 코드 호출
		joinPoint.proceed();
		
		
		//뒤에 삽입될 코드
		System.out.println("땅");
	}
}
