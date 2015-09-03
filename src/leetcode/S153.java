package leetcode;

public class S153 {
	public int findMin1(int[] nums) {
		//return find(nums, 0, nums.length - 1);
		int len = nums.length - 1;
		int min = nums[0];
		
		for(int i = 0; i <  nums.length;i++){	
			if(nums[i] < min){
				min = nums[i];
			}
		}
		return min;
    }
	
	public int findMin(int[] nums){
		return find(nums, 0, nums.length - 1);
	}
	
	public int find(int[] nums, int begin, int end){
		int key = (begin + end) / 2;
		if(nums[begin] <= nums[end])	return nums[begin];
		
		if(nums[key] < nums[begin]){
			return find(nums, begin, key);
			}
		else{
			return find(nums, key + 1, end);
		}
	}
	
	
	
	public static void main(String[] args) {
		S153 s = new S153();
		int[] nums = {2,1};
		System.out.println(s.findMin(nums));
	}
}
