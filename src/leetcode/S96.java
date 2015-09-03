package leetcode;

public class S96 {
	public int numTrees(int n) {
		int[] arrays = new int[n + 1];
		
		arrays[0] = 1;
		arrays[1] = 1;
		arrays[2] = 2;
		
		for(int i = 3;i <= n;i++){
			
				for(int j = 0;j < i;j++){
					arrays[i] += arrays[j] * arrays[i - j - 1];
				}
			}
			
		return arrays[n];
    }
	
	public static void main(String[] args) {
		S96 s = new S96();
		System.out.println(s.numTrees(4));
	}
	
}
