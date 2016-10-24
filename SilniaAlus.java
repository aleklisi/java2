import java.math.*;
import java.util.*;
interface implementacja{
	//void usunNmniejszyElement();
	void dodajWynikSilni(int arg, BigInteger wyn);
	BigInteger liczSilnie (int arg);
}
class  WynikiSilni implements implementacja{
	int rozmiarBufora = 3;
	TreeMap<Integer, BigInteger> buforek = new TreeMap<Integer, BigInteger>();
	 void usunNmniejszyElement(){ 
		buforek.remove(buforek.firstKey());
	}
	public void dodajWynikSilni(int arg, BigInteger wyn){
		if (!buforek.containsKey(arg)){
			if (buforek.size() > rozmiarBufora){
				usunNmniejszyElement();
			}
			buforek.put(arg,wyn);
		}
	}	
	public BigInteger liczSilnie (int arg){
		if (arg < 0){
			throw new RuntimeException(" nie mize");
		}
		int j = arg;
		while (j >= 2 && !buforek.containsKey(j)){
			--j;
		}
		BigInteger wynik = new BigInteger("1");
		if (j > 2){
			wynik = buforek.get(j);
		}
		for (int i = j; i <= arg; i++){	
			wynik = wynik.multiply(new BigInteger("" + i));
		}
		dodajWynikSilni(arg,wynik);
		return wynik;
	}

}

public class SilniaAlus {
	public static void main(String []args){
		WynikiSilni bufor = new WynikiSilni();
		/*if (args.length <= 0){
			System.out.println("wywolaj program z wlasciwa liczba argumentow");
		}
		else{*/
			try{
			bufor.dodajWynikSilni(90, bufor.liczSilnie(90));
			System.out.println("wywolaj 0");
			System.out.println(bufor.buforek);
			bufor.dodajWynikSilni(91, bufor.liczSilnie(91));
			bufor.dodajWynikSilni(92, bufor.liczSilnie(92));
			System.out.println("wywolaj 1");
			System.out.println(bufor.buforek);
			bufor.dodajWynikSilni(9, bufor.liczSilnie(9));
			System.out.println("wywolaj 2");
			System.out.println(bufor.buforek);
			bufor.dodajWynikSilni(9, bufor.liczSilnie(9));
			bufor.dodajWynikSilni(8, bufor.liczSilnie(8));
			System.out.println("wywolaj 3");
			System.out.println(bufor.buforek);
			bufor.dodajWynikSilni(7, bufor.liczSilnie(7));
			bufor.dodajWynikSilni(5, bufor.liczSilnie(5));
			bufor.dodajWynikSilni(15, bufor.liczSilnie(15));
			}
			catch(NumberFormatException e){
				System.out.println("nie podales liczby");
			}
			System.out.println("wywolaj 4");
			System.out.println(bufor.buforek);
		//}
		
	}
}