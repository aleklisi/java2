
public class Cw9Str142 {
	static int fibonacci(int n){
		if((n == 1) || (n == 2)){
			return 1;
		}
		return fibonacci(n-2) + fibonacci(n-1);
	}
	
	public static void main (String[] args){
		if (args.length < 1){
			throw new RuntimeException("Nie podales argumentow");
		}
		int a = 0;
		try{
			a = Integer.parseInt(args[0]);
		}
		catch(NumberFormatException e){
			System.out.println("Niepoprawny format argumentu");
		}
		if (a < 1){
			throw new RuntimeException("Kiepska wartosc");
		}
		for (int i = 1 ; i < a; i++){
			System.out.println(i + ". " + fibonacci(i));
		}
	}
}
