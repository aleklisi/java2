import java.math.*;
/**
 * @author Aleksander Lisicecki
 * @version 1.1 i ostatnia :p
 *
 */
/**
 * klasa-kalkulator jakby slownie "przeciaza operacje silni mnizeni i sumowania dla dowolnie duzyc int"
 */
class Funkcyje{
	/**
	 * 
	 * @param arg parametr int z niego licze silnie
	 * @return zwarac arg!
	 */
	 BigInteger silnia (String arg){
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
	/**
	 * 
	 * @param arg1 1 skladnik mnozenia
	 * @param arg2 2 skladnik mnozenia
	 * @return iloczyn arg1*arg2 dla dowolnie duzych liczb
	 */
	 BigInteger iloczyn (String arg1 ,String arg2){
		BigInteger argument1 = new BigInteger(arg1);
		BigInteger argument2 = new BigInteger(arg2);
		return argument1.multiply(argument2);
	}
	/**
	 * 
	 * @param arg1 1 skladnik sumy
	 * @param arg2 skladnik sumy
	 * @return sume arg1+arg2
	 */
	 BigInteger suma (String arg1 ,String arg2){
		BigInteger argument1 = new BigInteger(arg1);
		BigInteger argument2 = new BigInteger(arg2);
		return argument1.add(argument2);
	}
}
public class kalkulator {
	public static void main(String []args){
		Funkcyje f = new Funkcyje();
		if (args.length  < 2){
			throw new RuntimeException("za malo argumentow :P");
		}
		if (args[0].equals("silnia")){
			System.out.println(f.silnia(args[1]));
		}
		if (args[0].equals("iloczyn")){
			System.out.println(f.iloczyn(args[1],args[2]));
		}
		if (args[0].equals("suma")){
			System.out.println(f.suma(args[1],args[2]));
		}
	}	
}
