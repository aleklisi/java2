
//liczby wampirze
public class Cw10Str142 {
	static void check(int i, int j){
		int result = i * j;
		int counter = 0;
		if ( result < 1000 || result % 100 == 0) return;
		
		String liczba = Integer.toString(result);
		String slowo = Integer.toString(i) + Integer.toString(j);
		
		char licz[] = liczba.toCharArray();
		char slow[] = slowo.toCharArray();
		
		et1:
			 for(int st1 = 0; st1 < 4 ; st1++){    
				 for(int st2 = 0; st2 < 4; st2++){
		            if(slow[st1] == licz[st2]){
		            	licz[st2] = Character.MAX_VALUE;
		                counter ++;
		                continue et1;
		            }
				 }
			 }
		if(counter == 4){
		    System.out.println(result + " = " + i+ " * " + j);    
		}
	}
	
	public static void main(String[] args){
		for (int i = 10; i < 100; i++){
			for (int j = 10; j < 100; j++){
				if (j > i){
					break;
				}
				check(i,j);
			}
		}
	}
}
