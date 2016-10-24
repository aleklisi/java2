//liczby wampirze
public class Cw10Str142 {
	static void wypiszLiczbyWampirze(){
		for(int i = 10; i < 99; i++){
		    for(int j = 10; j < 99; j++){
		        int result = i*j;
		        String resultStr = Integer.toString(result);
		        if(resultStr.length() == 4 && !resultStr.substring(2, 4).equals("00")){
		            System.out.println(result + " = " + i + " * " + j);
		        }
		    }
		}
	}
	public static void main(String[] args){
		wypiszLiczbyWampirze();
	}
}
