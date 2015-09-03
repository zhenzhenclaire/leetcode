package search;

public class Binary {
	public int searchValue(int[] a, int target){
		int result = 0;
		int low = 0;
		int high = a.length - 1;
		int middle = 0;
		
		while(low <= high){
			middle = (low + high) / 2;
			if(target == a[middle]){
				return target;
			}
			else if(a[middle] < target){
				low = middle + 1;
			}
			else{
				high = middle - 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = {1,4,5,7,8,25,73};
		Binary binary = new Binary();
		
		System.out.println(binary.searchValue(a, 25));
	}
}
