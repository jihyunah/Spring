package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class SungJukImpl implements SungJuk {
	@Autowired //--> (@Component로.. 등등 ) 생성한 bean들 중에서 SungJukDTO 클래스를 찾아서 값을 얻어오기 
	private SungJukDTO sungJukDTO;
	
	
//	public SungJukImpl(SungJukDTO sungJukDTO) {
//		super();
//		this.sungJukDTO = sungJukDTO;
//	}
	
	@Override
	public void calcTot() {
		sungJukDTO.setSum(sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath());

	}

	@Override
	public void calcAvg() {
		sungJukDTO.setAvg(sungJukDTO.getSum()/3.0); 

	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균 ");
		System.out.println("-----------------------------------------------");
//		System.out.println(sungJukDTO.getName()+"\t"
//						  +sungJukDTO.getKor()+"\t"
//						  +sungJukDTO.getEng()+"\t"
//						  +sungJukDTO.getMath()+"\t"
//						  +sungJukDTO.getSum()+"\t"
//						  +String.format("%.3f", sungJukDTO.getAvg()));
		System.out.println(sungJukDTO);
			
	}

	@Override
	public void modify() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		sungJukDTO.setName(scan.next());
		System.out.print("국어 입력 : ");
		sungJukDTO.setKor(scan.nextInt());
		System.out.print("영어 입력 : ");
		sungJukDTO.setEng(scan.nextInt());
		System.out.print("수학 입력 : ");
		sungJukDTO.setMath(scan.nextInt());

	}

}
