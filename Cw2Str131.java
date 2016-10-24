import java.util.*;

public class Cw2Str131 {
	static boolean sprawdz(int wartosc1, int wartosc2){
		if (wartosc1 < wartosc2){
			System.out.println("Wartosc 1 < wartosci 2");
			return false;
		}
		if (wartosc1 > wartosc2){
			System.out.println("Wartosc 1 > wartosci 2");
			return false;
		}
		else{
			System.out.println("Wartosci sa rowne");
			return true;
		}
	}
	
	public static void main(String[] args){
		Random rand = new Random();
		int losowa1;
		int losowa2;
		for (int i = 0; i < 25; i++){
			losowa1 = rand.nextInt(50);
			losowa2 = rand.nextInt(50);
			System.out.println(losowa1 + "	" + losowa2);
			sprawdz(losowa1, losowa2);
		}
	}
}
