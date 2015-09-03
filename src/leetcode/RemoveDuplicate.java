package leetcode;

public class RemoveDuplicate {
	public int removeDuplicates1(int[] nums) {
        if(nums.length == 0)	return 0;
        
        int length = 0;
		int v = 0, m = 0, c = 0;
		v = nums[0];
		while(m < nums.length){
			if(nums[m] == v)	m++;
			else{
				c++;
				nums[c] = nums[m];
				v = nums[m];
			}
		}
		length = c + 1;

        return length;
    }
	
	public int removeDuplicates(int[] nums) {
		if(nums.length <= 2)	return nums.length;
        int length = 0;
        int times = 1;  
		int v = 0, m = 0, c = 0;
		v = nums[0];
		while(m < nums.length){
			if(nums[m] == v){							
				if(times == 2){
					c++;
					nums[c] = v;
				}
				times++;
				m++;
			}
			else{
				c++;
				nums[c] = nums[m];
				v = nums[m];
				times = 1;
			}
		}
		
		length = c + 1;

        return length;
    }	
	public static void main(String[] args) {
		RemoveDuplicate r = new RemoveDuplicate();
		int[] nums = {1,1};
		r.removeDuplicates(nums);
	}
	
}	
