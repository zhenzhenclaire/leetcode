package leetcode;

public class S200 {
	int row = 0;
	int col = 0;
	
	public void findIsland(char[][] grid, int x, int y){
		if(x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == '0')	return;
		else{
			grid[x][y] = '0'; 
			findIsland(grid, x + 1, y);
			findIsland(grid, x - 1, y);
			findIsland(grid, x, y + 1);
			findIsland(grid, x, y - 1);
		}
	}
	
	public int numIslands(char[][] grid) {
		row = grid.length;
		col = grid[0].length;
		int count = 0;
		
		for(int x = 0;x < row;x++){
			for(int y = 0;y < col;y++){
				if(grid[x][y] == '0')	continue;
				else{
					findIsland(grid, x, y);
					count++;
				}
			}
		}
		
		return count;
    }
	
	
	public static void main(String[] args) {
//		char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		char[][] grid = {{'1','0'}};
		S200 s = new S200();
		System.out.println(s.numIslands(grid));
	}
}
