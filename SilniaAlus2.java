import java.math.*;
import java.util.*;
interface implementacja{
	//void usunNmniejszyElement();
	void dodajWynikSilni(int arg, BigInteger wyn);
	BigInteger liczSilnie (int arg);
}

class  WynikiSilni implements implementacja{
	int rozmiarBufora = 10;
	TreeMap<Integer, BigInteger> buforek = new TreeMap<Integer, BigInteger>();
	 LinkedList<Integer> kolejkaObliczen = new LinkedList<Integer>();
	 void licz(){
		 Collections.sort(kolejkaObliczen);
		 ListIterator<Integer> listIterator = kolejkaObliczen.listIterator();
			while (listIterator.hasNext()) {
				System.out.println(listIterator.next() +"	" + liczSilnie(listIterator.next()));
			}
	 }
	 void skolejkuj(){
		 String kolejnyArgumentSilni ="";
		 Scanner keyboard = new Scanner(System.in);
		 while(!kolejnyArgumentSilni.equals("koniec")){
				try{
					System.out.println("podaj kolejny argument lub wpisz koniec by zakonczyc wpisywanie i przejsc do obliczen");
					kolejnyArgumentSilni = keyboard.nextLine();
					if (kolejnyArgumentSilni.equals("koniec")){
						licz();
					}
					else{
						Integer arg = new Integer(kolejnyArgumentSilni);
						kolejkaObliczen.add(arg);
					}
					}
					catch(NumberFormatException e){
						System.out.println("nie podales liczby");
					}

		 }
	 }
	 
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

public class SilniaAlus2 {
	public static void main(String []args){
		WynikiSilni bufor = new WynikiSilni();
		/*if (args.length <= 0){
			System.out.println("wywolaj program z wlasciwa liczba argumentow");
		}
		else{*/
			try{
				bufor.skolejkuj();
			}
			catch(NumberFormatException e){
				System.out.println("nie podales liczby");
			}
			System.out.println(bufor.buforek);
		//}
	}
}