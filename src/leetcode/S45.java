package leetcode;

public class S45 {
	public int jump(int[] nums){
		int last = 0;
		int curr = 0;
		int times = 0;
		
		for(int i = 0;i < nums.length;i++){
			if(i > curr)	return -1;
			if(i > last){
				last = curr;
				times++;
			}
			curr = Math.max(curr, i + nums[i]);
		}
		return times;
	}
	
	public static void main(String[] args) {
		S45 s = new S45();
		int[] nums = {16,7,2,0,1};
		System.out.println(s.jump(nums));
	}
}
