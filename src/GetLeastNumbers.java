import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;



public class GetLeastNumbers {
	  public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
		  ArrayList<Integer> resultArrayList = new ArrayList<Integer>();
		  if(input.length < k || k <= 0)	return resultArrayList;
		  //big -> small
		  PriorityQueue<Integer> queue = new PriorityQueue<Integer>(11,
			        new Comparator<Integer>() {
			          public int compare(Integer s1, Integer s2) {
			            return s2 - s1;
			          }
			        });	    
		  
		  for(int j = 0;j < k;j++){
			  queue.add(input[j]);
		  }
		  
		  for(int i = k;i < input.length;i++){
			  int current = input[i];
			  
			  if(current > queue.peek())	continue;
			  else{
				  queue.remove();
				  queue.add(current);
			  }
		  }
		  
		  int[] temp = new int[k];
		  
		  for(int m = 0; m < k;m++){
			  temp[m] = queue.poll();
		  }
		  
		  for(int m = k - 1; m >= 0;m--){
			  resultArrayList.add(temp[m]);
		  }
		  
		  return resultArrayList;
	  }
	  
	  
	  public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
		  ArrayList<Integer> resultArrayList = new ArrayList<Integer>();
		  if(input.length < k || k <= 0)	return resultArrayList;
		  
		  int[] result= new int[k];
		  
		  for(int i = 0;i < k;i++){
			  result[i] = input[i];
		  }

		  result = Sort(result);
		  
		  
		  for(int j = k;j < input.length;j++){
			  int num = input[j];
			  if(num > result[k - 1]) continue;
			  else{
				  int index = 0;
				  index = BinarySearch(result, num);
				  for(int p = result.length - 1; p >= index&&p>0;p--){
					  result[p] = result[p - 1];
				  }
				  result[index] = num;
			  }
		  }
		  
		  for(int i = 0;i < k;i++)
			  resultArrayList.add(result[i]);
		  
		  return resultArrayList;
	  }
	  
	  public int BinarySearch(int[] result, int num){
		  int low = 0;
		  int high = result.length - 1;
		  while(low <= high){
			  int middle = (low + high) / 2;
			  if(num > result[middle]){
				  low = middle + 1;
			  }
			  else{
				  high = middle - 1;
			  }
		  }
		  return low;
	  }
	  
	  
	  public int[] Sort(int[] array){
			int i = 0,j = 0;
			for(i = 0; i < array.length - 1;i++){
				int min = array[i];
				int minIndex = i;
				for(j = i + 1;j < array.length;j++){
					if(min > array[j]){
						min = array[j];
						minIndex = j;
					}
				}
				
				int temp = 0;
				
				temp = array[minIndex];
				array[minIndex] = array[i];
				array[i] = temp;
			}
			return array;
		}
	  public static void main(String[] args) {
		int [] input = {4,5,1,6,2,7,3,8};
		GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
		ArrayList<Integer> result = getLeastNumbers.GetLeastNumbers_Solution2(input, 1);
		
		for(Integer i: result){
			System.out.println(i);
		}
		
	}
}
