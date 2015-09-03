package leetcode;

public class S53 {
	 public int maxSubArray(int[] nums) {
		 int max = nums[0];
		 int result = max;
		 for(int i = 1;i < nums.length;i++){
			 max = (max > 0) ? (max + nums[i]) : nums[i];
			 if(max > result)	result = max;
		 }
		 return result;
	 }
	 
	 public static void main(String[] args) {
		S53 s = new S53();
		int[] nums = new int[]{4};
		System.out.println(s.maxSubArray(nums));
	}
}
