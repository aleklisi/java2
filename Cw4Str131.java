
public class Cw4Str131 {
	static boolean czyPierwsza(int arg){
		for (int j = 2; j <= Math.sqrt(arg); j++){
			if (arg % j == 0){
				return false;
			}
		}
		return true;
	}
	static void znajdzLiczbePierwsza(int zakres){
		for (int i = 2; i < zakres; i++){
				if (czyPierwsza(i)){
					System.out.println(i);
				}
		}
	}
	
	public static void main(String[] args){
		znajdzLiczbePierwsza(20);
	}
}
