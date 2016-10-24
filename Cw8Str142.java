import java.util.*;

public class Cw8Str142 {
	static void test(){
		Random rand = new Random(47);
		for (int i = 0; i < 10; i++){
			int c = rand.nextInt(26) + 'a';
			char sign = (char)c;
			switch(sign){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'y': {
				System.out.println(i + " : " + sign + " samogloska");
				//break;
			}
			case 'x': {
				System.out.println(i + " : " + sign + " nie wiem");
				//break;
			}
			default:  {
				System.out.println(i + " : " + sign + " spolgloska");
				//break;
			}

			}
		}
	}
	public static void main(String[] args){
		test();
	}
}
