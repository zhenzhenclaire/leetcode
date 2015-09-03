package search;

public class BinarySearch {
	 public int BS(int[] result, int num){
		  int low = 0;
		  int high = result.length - 1;
		  System.out.println("low=" + low + " high=" + high);
		  while(low <= high){
			  int middle = (low + high) / 2;
			  if(num > result[middle]){
				  low = middle + 1;
			  }
			  else{
				  high = middle - 1;
			  }
			  System.out.println("low=" + low + " middle=" + middle + " high=" + high);
		  }
		  return low;
	  }
	 
	 public static void main(String[] args) {
		int[]result = {1,2,4,6,8};
		BinarySearch binarySearch = new BinarySearch();
		System.out.println(binarySearch.BS(result, 3));
	}
}
