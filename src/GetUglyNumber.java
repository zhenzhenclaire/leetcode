import java.util.ArrayList;

import javax.swing.text.html.MinimalHTMLWriter;


public class GetUglyNumber {
	 public int GetUglyNumber_Solution(int index) {
		  int  index2 = 0, index3 = 0,index5 = 0;
		  int current = 1;
		  int[] uglyNums = new int[2000];
		  uglyNums[0] = 1;
		  
		  int newNum = 0;
		  if(index == 0)	return 0;
		  else if(index == 1)	return 1;
		  else{
			  while(current < index){
				  int a = uglyNums[index2] * 2;																		
				  int b = uglyNums[index3] * 3;
				  int c = uglyNums[index5] * 5;
				  
				  int minIndex =  Min(a,b,c);
				  uglyNums[current] = minIndex;
				  
			
				  
				 while(uglyNums[index2] * 2 <= uglyNums[current])	index2++;
				 while(uglyNums[index3] * 3 <= uglyNums[current])	index3++;
				 while(uglyNums[index5] * 5 <= uglyNums[current])	index5++;
				 current++;
			  }
		
		      return uglyNums[current - 1];
		  }
	  }
	 
	 public int Min(int a, int b,int c){
		 if(a < b){
			 if(a > c)	return c;
			 else{
				return a;
			 }
		 }
		 else{
			 if(b > c) return c;
			 else{
				 return b;
			 }
		 }
	 }
	 
	 public boolean isUglyNum(int index){
		 ArrayList<Integer> ugly = new ArrayList<Integer>();
		 for(int i = 2;i < index;i++){
			 if(index % i == 0){
				 ugly.add(i);
				 index = index / i;
			 }
		 }
		 int num = 0;
		 if(ugly.size() == 3 && ugly.get(0) == 2 && ugly.get(1) == 3 && ugly.get(2) == 5)
			 return true;
		 return false;
	 }
	 
	 public static void main(String[] args) {
		GetUglyNumber gNumber = new GetUglyNumber();
		System.out.println(gNumber.GetUglyNumber_Solution(2));
			
		
		
	}
	 
	 
}
