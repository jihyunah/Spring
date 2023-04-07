package sample04;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
public class SungJukUpdate implements SungJuk {
	@Autowired
	@Qualifier("arrayList") //List가 부모로, 다형성으로 자식 arrayList라는 bean값 불러줄거라고 선언해야함. 
	private List<SungJukDTO2> list;
	
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		System.out.println("수정할 이름 입력 : ");
		String name = scan.next();
		
		int sw = 0;
		for(SungJukDTO2 sungJukDTO2 : list) {
			if(sungJukDTO2.getName().equals(name)) {
				sw = 1;
				
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println(sungJukDTO2);
				
				System.out.println();
				System.out.println("국어 점수 입력 : ");
				sungJukDTO2.setKor(scan.nextInt());
				System.out.println("영어 점수 입력 : ");
				sungJukDTO2.setEng(scan.nextInt());
				System.out.println("수학 점수 입력 : ");
				sungJukDTO2.setMath(scan.nextInt());
				
				sungJukDTO2.setTot(sungJukDTO2.getKor()+sungJukDTO2.getEng()+sungJukDTO2.getMath());
				sungJukDTO2.setAvg(sungJukDTO2.getTot() / 3.);
				
				System.out.println(name+"님이 데이터를 수정하셨습니다. ");
				break;
			} //if
			
		} //for
		
		if(sw == 0) System.out.println("찾고자 하는 회원 정보가 없습니다. ");
	}

}
