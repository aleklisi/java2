
public class Cw7Str136 {
	static void wypisz(int liczba){
		for (int i = 1; i < liczba; i++){
			System.out.print(i + ",	");
			if (i%10 == 0){
				System.out.println(" ");
			}
			if (i == 99) return;
			if (i == 99) break;
		}
	}
	
	public static void main(String[] args){
		System.out.println("Wypisz liczby od 1 do 100");
		wypisz(101);
	}
}
