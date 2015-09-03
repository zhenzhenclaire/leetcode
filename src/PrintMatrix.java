import java.util.ArrayList;

import javax.swing.text.html.MinimalHTMLWriter;


public class PrintMatrix {
	static int m = 1;
	  public ArrayList<Integer> printMatrix1(int [][] matrix) {
	       ArrayList<Integer> result = new ArrayList<Integer>();
	       
	       int dd = matrix.length;
	       int dimension = dd - 1;
	       
	       for(int i = 0;i < dd/2;i++){
	    	   for(int a = i; a < dimension - i;a++){
	    		   result.add(matrix[i][a]) ;
	    	   }
	    	   for(int b = i; b < dimension -i;b++){
	    		   result.add(matrix[b][dimension - i]);
	    	   }
	    	   for(int c = dimension - i; c >= i + 1;c--){
	    		   result.add(matrix[dimension - i][c]);
	    	   }
	    	   for(int d = dimension - i; d >= i + 1; d--){
	    		   result.add(matrix[d][i]);
	    	   }
	       }
	       if(dd % 2 != 0){
	    	   result.add(matrix[(dimension + 1)/2][(dimension + 1)/2]);
	       }
	       return result;
	    }
	  
	  public ArrayList<Integer> printMatrix2(int [][] matrix) {
		  ArrayList<Integer> result = new ArrayList<Integer>();
		  int row = matrix.length;
		  int col = matrix[0].length;
		  int ri = 0,rj = row-1,ci = 0,cj = col-1;
		  boolean flag = true;
		  while(flag ){
			  flag = false;
			  if(ri == rj && ci == cj){
				  result.add(matrix[ri][ci]);
				  break;
			  }
			  if(ri == rj ){
				  for(int i = ci;i <= cj;i++){
					  flag = true;
					  result.add(matrix[ri][i]);
				  }
				  break;
			  }
			  if(ci == cj){
				  for(int i = ri;i <= rj;i++){
					  flag = true;
					  result.add(matrix[i][ci]);
				  }
				  break;
			  }
			  for(int i = ci;i < cj;i++){
				  flag = true;
				  result.add(matrix[ri][i]);
			  }
			  for(int i = ri;ci<=cj && i < rj; i++){
				  flag = true;
				  result.add(matrix[i][cj]);
			  }
			  ri++;
			  for(int i = cj;i > ci; i--){
				  flag = true;
				  result.add(matrix[rj][i]);
			  }
			  cj--;
			  for(int i = rj;ci<=cj && i > ri;i--){
				  flag = true;
				  result.add(matrix[i][ci]);
			  }
			  rj--;
			  ci++;
		  }
		  return result;
		  
	  }
	  
	  public ArrayList<Integer> printMatrix3(int [][] matrix) {
		  ArrayList<Integer> result = new ArrayList<Integer>();
		  int row = matrix.length;
		  int col = matrix[0].length;
		  int temp = Math.min(row, col);
		 
		  int round = 0;
		  if(temp % 2 == 0){
			  round = temp / 2;
		  }
		  else{
			  round = (temp + 1) / 2;
		  }
		  int r = round;
		 
		  row -= 1; col -= 1;
		  for(round = 0 ;round < r; round++){
			  for(int a = round; a <= col - round;a++){
				
				  result.add(matrix[round][a]);
			  }
			  
			  if(round + 1 <= row - round){
				  for(int b = round + 1; b <= row - round; b++){
					  result.add(matrix[b][col - round]);
				  }
				  
				  if(col - round - 1 >= round){
					  for(int c = col - 1 - round; c >= round; c--){
						  result.add(matrix[row - round][c]);
					  }
					  
					  if(row - 1- round >= round + 1){
						  for(int d = row - 1- round; d >= round + 1;d--){
							  result.add(matrix[d][round]);
						  }
					  }
				  }
			  }

		  }
		  
		  return result;
	  }
	  public static void main(String[] args) {
		  PrintMatrix p = new PrintMatrix();
//		  int [][]matrix = new int[m][m]; 
//		  int a = 1;
//		  for(int i = 0;i < m;i++){
//			  for(int j = 0;j < m;j ++){
//				  matrix[i][j] = a++; 
//			  }
//		  }
		  int[][] matrix = {{1,2},{3,4}};
		  ArrayList<Integer> result = new ArrayList<Integer>();
		  result = p.printMatrix2(matrix);
		  for(int w : result){
			  System.out.print(w);
		  }
	}
}
