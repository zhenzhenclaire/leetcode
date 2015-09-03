import java.util.HashMap;
import java.util.Vector;


public class Continuous {
	
	public boolean IsContinuous( Vector<Integer> numbers ) {
		int max = 0;
		int min = Integer.MAX_VALUE;
		int num_zero = 0;
		boolean isSame = false;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int k : numbers){
			if(k == 0)	continue;
			if (map.get(k) != null) {
				isSame = true;
				break;
			}
			else {
				map.put(k, 1);
			}
		}
		System.out.println("isSame" + isSame);

		for(int i = 0;i<numbers.size();i++){
			int value = numbers.get(i);
			if(value == 0)	num_zero++;
			else{
				if(max <= value){
					max = value;
				}
				if(min >= value){
					min = value;
				}
			}
		}
		
		int difference = max - min;
		
		if(num_zero == 4)	return true;
		else{
			
			if(num_zero > 0){
				if(difference > 4)	return false;
				else{
					if(!isSame)	return true;
					else {
						return false;
					}
				}
						 
			}
			
			if(num_zero == 0){
				if(difference != 4)	return false;
				else{
					
						if(isSame)	return false;
						else{
							return true;
						}
						
					}
			
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<Integer>();
		vector.add(1);
		vector.add(3);
		vector.add(0);
		vector.add(5);
		vector.add(0);
		Continuous continuous = new Continuous();
		System.out.println(continuous.IsContinuous(vector));
	}
}
