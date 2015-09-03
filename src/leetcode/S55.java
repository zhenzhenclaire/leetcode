package leetcode;

public class S55 {
	public boolean canJump1(int[] nums) {
		int len = nums.length;
		boolean can[] = new boolean[len];
		
		can[0] = true;
		for(int i = 0;i < len;i++){
			if(can[i] == true){
				for(int j = 0;j <= nums[i] && (i + j < len);j++){
					can[j + i] = true;
				}
			}
		}
		
		return can[len - 1];
    }
	
	public boolean canJump(int[] nums){
		int len = nums.length;
		if(len == 0 || len == 1)	return true;
		int maxStep = nums[0];
		
		for(int i = 1;i < len;i++){
			if(maxStep == 0)	return false;
			maxStep--;
			if(maxStep < nums[i])	maxStep = nums[i];
			if(maxStep + i >= len - 1)	return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		S55 s = new S55();
		int[] nums = {2,3,1,0,0};
		if(s.canJump(nums)){
			System.out.println("true");
		}
		else{
			System.out.println("false");
		}
	}
}
