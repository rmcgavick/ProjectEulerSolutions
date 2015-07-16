
public class Problem24 {

	static final long startTime = System.nanoTime();
	static final int[] digits = {0, 1, 2};
	
	
	private static int countPermutations(int[] digs) {
		int count = 0;
		
		while (count < 6) {
			
			for(int i=0; i<digs.length; i++) {
				System.out.println(digs[i]);
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Permutation count: " + countPermutations(digits));
		
		final long endTime = System.nanoTime();
		System.out.println("\nTook "+ ((endTime - startTime) / 1000000000.0) + " seconds");
	}

}
