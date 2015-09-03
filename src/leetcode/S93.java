package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S93 {
	 
	List<String> result = new ArrayList<String>();
	
	public List<String> restoreIpAddresses(String s) {
		int len = s.length();
		if(len <= 0 || len > 12)	return result;
		split("", s, 4);
		return result;
	}
	
	public void split(String cur, String left, int num){
		if(num == 0 && left.length() != 0 )	return;
		if(num != 0 && left.equals( ""))	return;
		
		if(num == 0 && left.equals("")){
			result.add(cur);
			return;
		}
		
		String sub = "";
		if(left.length() > 0){
			sub = left.substring(0, 1);
			if(Integer.parseInt(sub) > 255)	return;
			else{
				String addString = cur + "." + sub;
				if(num == 4){
					addString = cur + sub;
				}
				split(addString, left.substring(1), num - 1);
			}
		}
		
		if(left.length() > 1){
			sub = left.substring(0, 2);
			if(Integer.parseInt(sub) > 255 || Integer.parseInt(sub) < 10)	return;
			else{
				String addString = cur + "." + sub;
				if(num == 4){
					addString = cur + sub;
				}
				split(addString, left.substring(2), num - 1);
			}
		}
		 
		if(left.length() > 2){
			sub = left.substring(0, 3);
			if(Integer.parseInt(sub) > 255 || Integer.parseInt(sub) < 100)	return;
			else{
				String addString = cur + "." + sub;
				if(num == 4){
					addString = cur + sub;
				}
				split(addString, left.substring(3), num - 1);
			}
		}
	}
	 
	 public static void main(String[] args) {
		S93 s = new S93();
		List<String> result = s.restoreIpAddresses("010010");
		for(String str:result){
			System.out.println(str);
		}
	}
}
