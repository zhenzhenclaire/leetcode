package leetcode;

public class Exit {
	
	int[][] visited;
	public int times=0;
	
	 public boolean exist(char[][] board, String word) {
	     char[] wordChar = word.toCharArray(); 
	     visited = new int[board.length][board[0].length];
		 return find(0, wordChar, board, 0, 0);
	 }
	 
	 public boolean find1(int ch, char[] word , char[][] board, int i, int j){
//		 System.out.println("length:"+board[0].length+ ":"+ board.length);
		 
		 
		 if(j >= board[0].length || i >= board.length || i< 0 || j < 0) return false;
		 else if(ch >= word.length) {
//			 System.out.println("success");
			 return true;
		 }else if(visited[i][j] > 4){
			 return false;
		 }
		 else{
			 System.out.println(i+":"+j+":"+visited[i][j]);
			 visited[i][j]++;
//			 System.out.println(i+":"+j+":"+ch);
			 if(board[i][j] == word[ch]){
				 times = 0;
				 return find(ch + 1, word, board, i, j);
			 }
			 else{
				 times++;
				 boolean right = false;
				 boolean left = false;
				 boolean up = false;
				 boolean down = false;
				 if(times == 1){
					 right = find(ch, word, board, i + 1, j);
					 left = find(ch, word, board, i - 1, j);
					 up = find(ch, word, board, i, j + 1);
					 down = find(ch, word, board, i, j - 1);
				 }
				 if(!right && !left && !up && !down){
					 return find(0, word, board, i, j);
				 }
				 else{
					 return true;
				 }
			 }
		 }
	 }
	 
	 
	 public boolean find(int ch, char[] word , char[][] board, int i, int j){
//		 System.out.println("length:"+board[0].length+ ":"+ board.length);
		 
		 
		 if(j >= board[0].length || i >= board.length || i< 0 || j < 0) return false;
		 else if(ch >= word.length) {
//			 System.out.println("success");
			 return true;
		 }else if(ch ==0 && visited[i][j] != 0){
			 return false;
		 }
		 else{
//			 System.out.println(i+":"+j+":"+visited[i][j]);
			 if(ch == 0)
				 visited[i][j]++;
//			 System.out.println(i+":"+j+":"+ch);
			 if(board[i][j] == word[ch]){
				 boolean right = find(ch+1, word, board, i + 1, j);
				 boolean left = find(ch+1, word, board, i - 1, j);
				 boolean up = find(ch+1, word, board, i, j + 1);
				 boolean down = find(ch+1, word, board, i, j - 1);
				 
				 return right || left || up || down;
				 
			 }
			 else{
				 ch = 0;
				 boolean right = find(ch, word, board, i + 1, j);
				 boolean left = find(ch, word, board, i - 1, j);
				 boolean up = find(ch, word, board, i, j + 1);
				 boolean down = find(ch, word, board, i, j - 1);
				 return right || left || up || down;
			 }
		 }
	 }
	 
	 public static void main(String[] args) {
		 Exit exit = new Exit();
//		 char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		 
		 String[] boardbase = {"CAA","AAA","BCD"};
		 char[][] board = new char[boardbase.length][boardbase[0].length()];
		 
		 for(int i = 0;i<board.length;i++){
			 for(int j = 0;j< board[0].length;j++){
				 board[i][j] = boardbase[i].charAt(j);
			 }
		 }
		 
		 
		 String word = "AAB";
//		 boolean re = exit.exist(board, word);
		 boolean re = exit.cc(board, word);
		 if(re == true){
			 System.out.println("true");
		 }
		 else{
			 System.out.println("false");
		 }
	}
	 
	 
	 public boolean cc(char[][] board,String word){
		 
		 int row = board.length;
		 int col = board[0].length;
		 char[] wordChar = word.toCharArray(); 
		 
		 visited = new int[row][col];
		 
		 for(int i = 0;i<board.length;i++){
			 for(int j = 0;j< board[0].length;j++){		 
				 if(findchar(0, wordChar, board, i, j)){
					 return true;
				 }
			 }
		 }
		 return false;
	 }
	 
	 public boolean findchar(int ch, char[] word , char[][] board, int i, int j){
	 
		 if(ch == word.length) return true;
		 
		 else if(j >= board[0].length || i >= board.length || i< 0 || j < 0) {
			 return false;	 
		 }
		 
		 else if(visited[i][j] != 0){
			 
			 return false;
		 }
		 
		 else{
			
			 boolean right = false;
			 boolean left = false;
			 boolean up = false;
			 boolean down = false;
			 
			 if(board[i][j] == word[ch]){
				 visited[i][j] = 1;
				 right = findchar(ch+1, word, board, i + 1, j);
				 if(right) return right;
				 left = findchar(ch+1, word, board, i - 1, j);
				 if(left) return left;
				 up = findchar(ch+1, word, board, i, j + 1);
				 if(up) return up;
				 down = findchar(ch+1, word, board, i, j - 1);
				 if(!down) visited[i][j] = 0;
				 return down;			 
			 }
			 
			 else{
				 
				 return false;			 
			}
			 
		 }
	 }
	 
}
