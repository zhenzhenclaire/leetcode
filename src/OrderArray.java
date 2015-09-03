import java.util.ArrayList;


public class OrderArray {
    public void reOrderArray(int [] array) {
    	ArrayList<Integer> odd = new ArrayList<Integer>();
    	ArrayList<Integer> oven = new ArrayList<Integer>();
    	int len = array.length;
    	
    	if(len == 0)	return;
    	
    	for(int i = 0;i < len;i++){
    		if(array[i] % 2 == 0){
    			oven.add(array[i]);
    		}
    		else{
    			odd.add(array[i]);
    		}
    	}
    	
    	for(int i = 0 ;i < odd.size();i++){
    		array[i] = odd.get(i);
    	}
    	
    	for(int i = 0 ;i < oven.size();i++){
    		array[i + odd.size()] = oven.get(i);	
    	}
    }
    
    
 
    public static void main(String[] args) {
    	OrderArray order = new OrderArray();
    	
    	int[] array = {};
    	order.reOrderArray(array);
	}
}
