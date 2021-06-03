package template.Application.controller.DB;

import java.util.ArrayList;

public class Reservation_DB {

	static ArrayList<String> Name;

	
	public static ArrayList<String> ButtonName(){
		Name = new ArrayList<>();
			for (int i = 0; i < 36; i++) {
				if ( i< 6)
					Name.add("A"+(i+1));
				else if ( i < 12)
					Name.add("B"+(i-5));
				else if ( i < 18)
					Name.add("C"+(i-11));
				else if ( i < 24)
					Name.add("D"+(i-17));
				else if ( i < 30)
					Name.add("E"+(i-23));
				else
					Name.add("D"+(i-29));
			}
		return Name;
	}
	
}
