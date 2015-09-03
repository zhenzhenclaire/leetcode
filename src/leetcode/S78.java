package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S78 {
	 List<List<Integer>> list = new ArrayList<List<Integer>>();
	 
	 public List<List<Integer>> subsets(int[] nums) {	 
		 ArrayList<Integer> l = new ArrayList<Integer>();
		 Arrays.sort(nums);
		 list.add(new ArrayList<Integer>());
		 for(int i = 0;i < nums.length;i++){
			 ArrayList<Integer> tempList = new ArrayList<Integer>();
			 tempList.add(nums[i]);
			 list.add(tempList);
		 }
		 add(1,list.size() - 1,nums);
		 return list;
	 }
	 
	 public void add(int start,int end,int[] nums){
		 
		 while(list.get(list.size() - 1).size() < nums.length){
			 int count = 0;
			 for(int i = start; i <= end;i++){
				ArrayList<Integer> lastList = (ArrayList<Integer>) list.get(i);
				
				int	lastVal = lastList.get(lastList.size() - 1);
				for(int j = 0;j < nums.length;j++){
					if(nums[j] > lastVal){
						ArrayList<Integer> newList = new ArrayList<Integer>(lastList);
						newList.add(nums[j]);
						list.add(newList);
						count++;
					}
				}
				
			}
			start = end + 1;
			end += count;
				
		 }
	 }
	 
	 
	 public static void main(String[] args) {
		int[] nums = {1,2,3};
		S78 s = new S78();
		 List<List<Integer>> list = s.subsets(nums);
		 for(List<Integer> l : list){
			 for(Integer i : l){
				 System.out.print(i);
			 }
			 System.out.println();
		 }
	}
}
