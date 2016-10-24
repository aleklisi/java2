import java.math.*;
public class Cw5Str131 {
	static String dziesDoBin(int arg){
		String tmp = "";
		String wynik = "";
		while(arg > 0){
			if (arg % 2 == 0){
				tmp += "0";
				arg = arg/2;
			}
			else
			{
				tmp += "1";
				arg = arg/2;
			}
		}
		for (int i = 1; i <= tmp.length(); i++){
			wynik += tmp.charAt(tmp.length() - i);
		}
		return wynik;
	}
	
	static String and (int arg1,int arg2){
		String argument1 = dziesDoBin(arg1);
		String argument2 = dziesDoBin(arg2);
		String wynik = "";
		for (int i = 0; i < argument1.length()-1 && i < argument2.length()-1; i++){
			if (argument1.charAt(i) == argument2.charAt(i)){
				wynik += "1";
			}
			else{
				wynik += "0";
			}
		}
		return wynik;
	}
	
	static String or (int arg1, int arg2){
		String argument1 = dziesDoBin(arg1);
		String argument2 = dziesDoBin(arg2);
		String wynik = "";
		for (int i = 1; i < argument1.length() - 1; i++){
			argument2 += "0";
		}		
		for (int i = 1; i < argument2.length() - 1; i++){
			argument1 += "0";
		}
			for (int i = 0; i < argument1.length()-1 && i < argument2.length()-1; i++){
				if ((argument1.charAt(i) == '1') || (argument2.charAt(i) == '1')){
					wynik += "1";
				}
				else{
					wynik += "0";
				}
			}
		return wynik;
	}
	
	static final int a = 6;
	static final int b = 155;
	public static void main (String[] args){
		System.out.println(dziesDoBin(8));
		System.out.println("A: " + dziesDoBin(a) + " B: " + dziesDoBin(b));
		System.out.println("a & b = " + and(a ,b));
		System.out.println("a & b = " + Integer.toBinaryString(a & b));
		System.out.println("a | b = " + or(a ,b));
		System.out.println("a | b = " + Integer.toBinaryString(a | b));
		System.out.println("a ^ b = " + Integer.toBinaryString(a ^ b));
		System.out.println(" ~a = " + Integer.toBinaryString(~a));
		System.out.println(" ~b = " + Integer.toBinaryString(~b));
	}
}

