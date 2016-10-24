
public class Cw6Str134 {
	static int test(int testval, int target, int begin, int end){
		if ((testval > begin) && (testval <= end)){
			System.out.println("tesval miesci sie w przedziale");
			if (testval > target){
				return 1;
			}
			if (testval < target){
				return -1;
			}
			return 0;
		}
		System.out.println("tesval nie miesci sie w przedziale");
		return 999;
	}
	
	public static void main(String[] args){
		System.out.println(test(3, 2, -1, 5));
	}
}
