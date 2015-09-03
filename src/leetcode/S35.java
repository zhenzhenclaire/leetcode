package leetcode;

public class S35 {
	public int searchInsert(int[] nums, int target) {
		int len = nums.length;
		if(target < nums[0])	return 0;
		else if(target > nums[len - 1])	return len;
		else return find(nums, target, 0, len - 1);
    }
	
	public int find(int[] nums, int target, int start, int end){
		
		if(start > end) return start;
			
			int middle = (start + end) / 2;
			if(nums[middle] == target)	return middle;
			
			if(target >= nums[middle]){ 
				return find(nums, target, middle+1, end);
			}
			else{
				return find(nums, target, start, middle-1);
			}
	}
	
	public static void main(String[] args) {
		S35 s = new S35();
		int[] nums = {3,5,7,9,10};
		
		System.out.println(s.searchInsert(nums, 8));
	}
}
