public class fibonacci {
	static int nElementFib(int n){
		if (n == 1 || n == 2)
			return 1;
		return nElementFib(n-1) + nElementFib(n-2);
	}
	static void wypiszNelemntowCioguFib(int n){
		for (int i = 1; i <=n; i++){
			System.out.println(fibonacci.nElementFib(i));	
		}
	}
	public static void main(String []args){
		fibonacci.wypiszNelemntowCioguFib(5);
	}
}
