package leetcode;

import java.sql.Array;

public class S63 {
	int[][] array;
	
	 
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
   	 
   	 int m = obstacleGrid.length;
   	 int n = obstacleGrid[0].length;
   	 
   	 array = new int[m][n];
			 
		 for(int i = 0;i < m;i++){
			 for(int j = 0;j < n;j++){
				 if(obstacleGrid[i][j] == 1){
					 array[i][j] = 0;
				 }
				 else if(i == 0 && j == 0){
					 array[i][j] = 1;
				 }
				 else{
					 array[i][j] = d(i - 1,j) + d(i, j - 1);
				 }
			 }
		 }
		 return array[m - 1][n - 1];
   	
    }
	
	public int d(int i, int j){
		if(i >= 0 && j >= 0){
			return array[i][j];
		}
		else{
			return 0;
		}
	}
    
    public static void main(String[] args) {
		S63 s = new S63();
		int[][] array = {{0,0}};
		System.out.println(s.uniquePathsWithObstacles(array));
	}
}
