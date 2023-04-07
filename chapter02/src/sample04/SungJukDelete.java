package sample04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import lombok.Setter;

public class SungJukDelete implements SungJuk {
	@Setter
	private List<SungJukDTO2> list;
	@Setter
	private Iterator<SungJukDTO2> it;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		int i = 0;
		int sw = 0;
		int count = 0;
		
		System.out.println();
		System.out.println("삭제할 이름 입력 : ");
		String name = scan.next();
		
		it = list.iterator();
		while(it.hasNext()) {
			SungJukDTO2 sungJukDTO2 = it.next();
			
			if (sungJukDTO2.getName().equals(name)) {
				it.remove();
				count++;
			}
		} //while
		
		if (count==0) {
			System.out.println("회원의 정보가 없습니다.");
		}else System.out.println(count + "건을 삭제하였습니다.");
		
		

	}

}
