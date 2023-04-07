package sample04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
@Scope("prototype") //싱글톤 해제 
public class SungJukInput implements SungJuk {
	@Autowired //SungjukDTO2 타입을 찾아서 자동으로 매핑해라 
	private SungJukDTO2 sungJukDTO2; 
	@Autowired
	@Qualifier("arrayList") //List가 부모로, 다형성으로 자식 arrayList라는 bean값 불러줄거라고 선언해야함. 
	private List<SungJukDTO2> list;
	

	
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		
		//데이터 
		System.out.println("이름 입력 : ");
		sungJukDTO2.setName(scan.next()); 
		System.out.println("국어 입력 : ");
		sungJukDTO2.setKor(scan.nextInt()); 
		System.out.println("영어 입력 : ");
		sungJukDTO2.setEng(scan.nextInt());
		System.out.println("수학 입력 : ");
		sungJukDTO2.setMath(scan.nextInt());
		System.out.println();
		
		sungJukDTO2.setTot(sungJukDTO2.getKor()+sungJukDTO2.getEng()+sungJukDTO2.getMath());
		
		sungJukDTO2.setAvg(sungJukDTO2.getTot()/3.);

		//ArrayList에 담기 
		list.add(sungJukDTO2);
		
		//출력 
		System.out.println(sungJukDTO2.getName() + "님의 데이터를 저장하였습니다.");
	}


	


	


	
}
