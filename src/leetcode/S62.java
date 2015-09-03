package leetcode;

public class S62 {
	 public int uniquePaths1(int m, int n) {
		 int a = 1, b = 1;
		 int min = Math.min(m, n);
		 for(int i = 1;i <= (min - 1);i++){
			 a *= i;
			 b *= (m + n - 1 - i);
			 if(b%a == 0){
				 b /= a;
				 a = 1;
			 }
		 }
		 
		 return b/a;
		 
	 }
	 
	 public int uniquePaths(int m, int n) {
		 if(m == 0 || n == 0)	return 0;
		 int[][] array = new int[m][n];
		 array[0][0] = 1;
		 
		 for(int i = 1;i < m;i++){
			 array[i][0] = 1;
		 }
		 for(int i = 1;i < n;i++){
			 array[0][i] = 1;
		 }
		 for(int i = 1;i < m;i++){
			 for(int j = 1;j < n;j++){
				 array[i][j] = array[i - 1][j] + array[i][j - 1];
			 }
		 }
		 return array[m - 1][n - 1];
	 }
	 
	 public static void main(String[] args) {
		S62 s = new S62();
		System.out.println(s.uniquePaths(100,100));
	}
}
