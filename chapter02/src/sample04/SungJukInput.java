package sample04;

import java.util.List;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import lombok.Setter;


public class SungJukInput implements SungJuk {
	@Setter
	private SungJukDTO2 sungJukDTO2; //생성자 or setter 사용해서 값을 얻어와야한다. 
	@Setter
	private List<SungJukDTO2> list;
	
//	public void setList(List<SungJukDTO2> list) {
//		this.list = list;
//	}
	
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
