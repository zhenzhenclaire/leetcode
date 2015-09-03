package leetcode;

public class S64 {
	public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(n == 0 || m == 0)	return 0;
        
        int[][] f = new int[n][m];
        
        for(int i = 0;i < n;i++){
			for(int j = 0;j < m;j++){
				if(i == 0 && j >= 1){
					f[0][j] = f[0][j - 1] + grid[i][j];
				}
				else if(j == 0 && i >= 1){
					f[i][0] = f[i - 1][0] + grid[i][j];
				}
				else if(i == 0 && j == 0){
					f[0][0] = grid[0][0];
				}
				else  f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
			}
		}
        
		return f[n - 1][m - 1];
    }
	
	public static void main(String[] args) {
		int[][] grid = {{1,2},{1,1}};
		S64 s=new S64();
		System.out.println(s.minPathSum(grid));
	}
}
