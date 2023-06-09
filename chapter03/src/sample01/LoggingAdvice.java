package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

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
		//System.out.println("하늘");
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("메소드 = " + methodName);
		
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		
		//핵심 코드 호출
		Object ob =	joinPoint.proceed();
		System.out.println(ob);
		
		
		//뒤에 삽입될 코드
		//System.out.println("땅");
		sw.stop();
		System.out.println("처리 시간 = " + sw.getTotalTimeMillis()/1000 + "초");
	}
}
