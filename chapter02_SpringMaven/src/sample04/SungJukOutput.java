package sample04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
@Scope("prototype")
public class SungJukOutput implements SungJuk {
	@Autowired
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
