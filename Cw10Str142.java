package liczbyWampirze;

class Funkcyje{
	static boolean kombunacyjeCyfr(int arg1, int arg2){
		int liczbaMozeWampirza = arg1 * arg2; 
		int a1 = (arg1 - (arg1 % 10)) / 10;
		int a2 = arg1 % 10;
		int a3 = (arg2 - (arg2 % 10)) / 10;
		int a4 = arg2 % 10;
		int pom = 0;
		pom = a1 + 10 * a2 + 100 * a3 + 1000 *a4;
		if (pom == liczbaMozeWampirza)
			return true;		
		pom = a1 + 10 * a2 + 100 * a4 + 1000 *a3;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a1 + 10 * a3 + 100 * a2 + 1000 *a4;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a1 + 10 * a4 + 100 * a2 + 1000 *a3;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a1 + 10 * a4 + 100 * a3 + 1000 *a2;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a1 + 10 * a3 + 100 * a4 + 1000 *a2;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a2 + 10 * a1 + 100 * a4 + 1000 *a3;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a2 + 10 * a1 + 100 * a3 + 1000 *a4;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a3 + 10 * a1 + 100 * a2 + 1000 *a3;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a4 + 10 * a1 + 100 * a2 + 1000 *a4;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a3 + 10 * a1 + 100 * a4 + 1000 *a2;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a4 + 10 * a1 + 100 * a3 + 1000 *a2;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a2 + 10 * a3 + 100 * a1 + 1000 *a3;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a2 + 10 * a4 + 100 * a1 + 1000 *a3;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a3 + 10 * a2 + 100 * a1 + 1000 *a4;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a4 + 10 * a2 + 100 * a1 + 1000 *a3;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a4 + 10 * a3 + 100 * a1 + 1000 *a2;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a3 + 10 * a4 + 100 * a1 + 1000 *a2;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a2 + 10 * a3 + 100 * a4 + 1000 *a1;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a2 + 10 * a4 + 100 * a3 + 1000 *a1;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a3 + 10 * a2 + 100 * a4 + 1000 *a1;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a4 + 10 * a2 + 100 * a3 + 1000 *a1;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a3 + 10 * a4 + 100 * a2 + 1000 *a1;
		if (pom == liczbaMozeWampirza)
			return true;
		pom = a4 + 10 * a3 + 100 * a2 + 1000 *a1;
		if (pom == liczbaMozeWampirza)
			return true;
		return false;
	}
	static boolean czyWampirza(int arg1, int arg2){
		if (arg1 * arg2 < 1000){  //nie 4 cyfrowa
			return false;
		}
		if (arg1 % 10 == 0 && arg2 % 10 == 0){  //ma 2 zera na koncu
			return false;
		}

		return kombunacyjeCyfr(arg1,arg2);
	}
}
public class liczbyWampirze {
	public static void main(String []args){
		for (int i = 10; i < 99; i++){
			for (int j = 10; j < 99; j++){
				if(Funkcyje.czyWampirza(i,j)){
					System.out.println(i + "	" + j + "	" + i * j);
				}
			}
		}
	}
}
