package enumrunner;
import enumdemo.Colour;
public class EnumRunner {
	public static void main(String[] args) {
	
		for(Colour color:Colour.values()) {
			System.out.println("The Code of "+color+" is "+color.getValue());
		}
	}
}

