package sample04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
public class SungJukDelete implements SungJuk {
	@Autowired
	@Qualifier("arrayList") //List가 부모로, 다형성으로 자식 arrayList라는 bean값 불러줄거라고 선언해야함. 
	private List<SungJukDTO2> list;
	
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		int i = 0;
		int sw = 0;
		int count = 0;
		
		System.out.println();
		System.out.println("삭제할 이름 입력 : ");
		String name = scan.next();
		
		Iterator<SungJukDTO2> it = list.iterator();
		
		while(it.hasNext()) { //다음 항목을 가지고 있니;
			//it가 가리키는 곳의 항목을 꺼내서 저장한 후 저
			SungJukDTO2 sungJukDTO2 = it.next(); 
			
			if (sungJukDTO2.getName().equals(name)) {
				it.remove(); //아까 따로 보관한 항목을 제거 
				sw=1;
			} //if
			
			
		} //while
		
		
		if (sw==0) {
			System.out.println("회원의 정보가 없습니다.");
			
		}else System.out.println(sw + "건을 삭제하였습니다.");
		

	}

}
