package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S89 {
   
	public List<Integer> grayCode(int n) {
        List<Integer> value = new ArrayList<Integer>();
        if(n == 0){
        	value.add(0);
        	return value;
        }
        value = code(n);
        return value;
    }
    
    public List<Integer> code(int n){
    	List<Integer> value = new ArrayList<Integer>();
    	if(n == 1){
    		value.add(0);
    		value.add(1);
    		return value;
    	}
    	List<Integer> last = code(n - 1);
    	
    	value.addAll(last);
    	for(int i = last.size() - 1 ;i >= 0; i--){
    		value.add((int)(Math.pow(2, n - 1)) + last.get(i));
    	}
    	
    	return value;
    }
    
    public static void main(String[] args) {
    	S89 s = new S89();
    	 List<Integer> value = s.grayCode(0);
    	 for(Integer in:value){
    		 System.out.println(in);
    	 }
    	 
	}
}
