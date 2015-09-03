import java.util.HashMap;


public class MoreThanHalf {
	public int MoreThanHalfNum_Solution(int [] array) {
        int num = 0;
		int len = array.length;
		if(len == 1){
			return array[0];
		}
		int half = len/2;
		

        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        
        
        for(int i = 0;i < len; i++){
        	int key = array[i];
        	if(result.get(key) == null){
        		result.put(key, 1);
        	}
        	else if(result.get(key) + 1 > half){
        		return key;
        	}
        	else {
        		result.put(key, result.get(key) + 1);
			}
        }
        return 0;
    }
	
	public static void main(String[] args) {
		MoreThanHalf more = new MoreThanHalf();
		int[] array = {1};
		int result = more.MoreThanHalfNum_Solution(array);
		System.out.println(result);
	}
}
