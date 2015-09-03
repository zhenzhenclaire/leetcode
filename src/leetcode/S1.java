package leetcode;

import java.util.Hashtable;

public class S1 {
	public int[] twoSum1(int[] nums, int target) {      
		int[] result = new int[2];
		int len = nums.length;
		int first = 0, remain = 0;
		for(int i = 0;i < len;i++){
			first = i;
			remain = target - nums[i];
			for(int j = i + 1; j < len;j++){
				if(nums[j] == remain){
					result[0] = first + 1;
					result[1] = j + 1;
					break;
				}
			}
		}
		return result;
	}
	
	public int[] twoSum2(int[] nums, int target){
		int[] result = new int[2];
		Hashtable<Integer, Integer> HT = new Hashtable<Integer, Integer>();
		for(int i = 0;i < nums.length;i++){
			if(HT.get(target - nums[i]) != null){
				result[1] = i + 1;
				result[0] = HT.get(target - nums[i]) + 1; 
			}
			else{
				HT.put(nums[i],i);
			}
		}
		return result;
	}
	
	public int[] twoSum(int[] nums, int target){
		int[] result = new int[2];
		int len = nums.length;
		int begin = 0;
		int end = len - 1;
		while(begin <= end){
			int temp = nums[begin] + nums[end]; 
			if(temp > target)	end--;
			else if(temp == target){result[0] = 1 + begin; result[1] = 1 + end;break;}
			else	begin++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		S1 s1= new S1();
		int[] result = s1.twoSum(new int[]{2,7,11,15}, 9);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}
