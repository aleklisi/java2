import java.util.Random;

public class Cw3Str131 {
	static boolean sprawdz(int wartosc1, int wartosc2){
		if (wartosc1 < wartosc2){
			System.out.println("Wartosc 1 mniejsza od wartosci 2");
			return false;
		}
		if (wartosc1 > wartosc2){
			System.out.println("Wartosc 1 wieksza od wartosci 2");
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
		int i = 0;
		while (i > -1){
			losowa1 = rand.nextInt(50);
			losowa2 = rand.nextInt(50);
			System.out.println(losowa1 + " ... " + losowa2);
			sprawdz(losowa1, losowa2);
		}
	}
}
