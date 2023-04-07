package sample04;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
public class SungJukOutput implements SungJuk {
	@Autowired
	@Qualifier("arrayList") //List가 부모로, 다형성으로 자식 arrayList라는 bean값 불러줄거라고 선언해야함. 
	private List<SungJukDTO2> list;
	
	
	@Override
	public void execute() {
		System.out.println();
		
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		
		for(SungJukDTO2 sungJukDTO2 : list) {
			System.out.println(sungJukDTO2); //toString()으로 override해놓음. 
		} //for
		

	}


}
