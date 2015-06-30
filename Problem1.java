import java.util.ArrayList;

public class Problem1 {

	public static int findAllMultiples(int firstMultiple, int secondMultiple, int limit) {
		int sum = 0;
		
		for(int i=firstMultiple; i<limit; i++) {
			if(i % firstMultiple == 0) {
				sum += i;
			}
			else if(i % secondMultiple == 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(findAllMultiples(3, 5, 1000));
	}
	
}
