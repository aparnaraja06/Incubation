package bird;
import parrot.ParrotMod;
import duck.Duck;

public class BirdRunner {
	public static void main(String[] args) {
		 ParrotMod parrotObj=new ParrotMod();
		 parrotObj.fly();
		 parrotObj.speak();
		 
		 Duck duckObj=new Duck();
		 duckObj.fly();
		 duckObj.speak();
	}

}
