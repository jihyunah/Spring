package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserService;

@Component
public class HelloSpring {
	
	public void menu(ApplicationContext context) {
		Scanner scanner = new Scanner(System.in);
		UserService userService = null;
		int num;
		
		while(true) {
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 끝");
			
			System.out.print("번호 입력 : ");
			num = scanner.nextInt();
			
			if(num == 5) {
				break;
			}
			else if(num == 1) {
				userService = (UserService)context.getBean("userInsertService");
			}
			else if(num == 2) {
				userService = (UserService) context.getBean("userSelectService");
			}
			else if(num == 3) {
				userService = (UserService) context.getBean("userUpdateService");
			}
			else if(num == 4) {
				userService = (UserService) context.getBean("userDeleteService");
			}
			userService.execute();
		}	//while
		
	} // menu()

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		HelloSpring helloSpring = (HelloSpring)context.getBean("helloSpring");
		helloSpring.menu(context);
		System.out.println();
		System.out.println("프로그램을 종료합니다.");
	}

}
