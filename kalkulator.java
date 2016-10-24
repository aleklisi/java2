import java.math.*;
/*
 * @autor Aleksander Lisicecki
 * @version 1.1 i ostatnia :p
 *
 */
/*
 * klasa-kalkulator jakby slownie "przeciaza operacje silni mnizeni i sumowania dla dowolnie duzyc int"
 */
class Funkcyje{
	static BigInteger silnia (String arg){
		Integer argument = new Integer(arg);
		if (argument < 0){
			throw new RuntimeException(" nie mize");
		}
		BigInteger wynik = new BigInteger("1");
		for (int i = 2; i <= argument; i++){	
			wynik = wynik.multiply(new BigInteger("" + i));
		}	
		return wynik;
	}
	static BigInteger iloczyn (String arg1 ,String arg2){
		BigInteger argument1 = new BigInteger(arg1);
		BigInteger argument2 = new BigInteger(arg2);
		return argument1.multiply(argument2);
	}
	static BigInteger suma (String arg1 ,String arg2){
		BigInteger argument1 = new BigInteger(arg1);
		BigInteger argument2 = new BigInteger(arg2);
		return argument1.add(argument2);
	}
}
public class kalkulator {
	public static void main(String []args){
		if (args.length  < 2){
			throw new RuntimeException("za malo argumentow :P");
		}
		if (args[0].equals("silnia")){
			System.out.println(Funkcyje.silnia(args[1]));
		}
		if (args[0].equals("iloczyn")){
			System.out.println(Funkcyje.iloczyn(args[1],args[2]));
		}
		if (args[0].equals("suma")){
			System.out.println(Funkcyje.suma(args[1],args[2]));
		}
	}	
}
