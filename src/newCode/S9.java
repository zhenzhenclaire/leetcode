package newCode;

public class S9 {
    public int minNumberInRotateArray(int [] array) {
    	if(array.length == 0)	return 0;
        int start = 0, end = array.length - 1, mid = start;
        while(array[start] >= array[end]){
        	mid = (start + end) / 2;
        	if(array[start] ==  array[mid] && array[mid] == array[end]){
        		int min = array[start];
        		for(int i = start;i <= end;i++){
        			if(array[i] < min)	min = array[i];
        		}
        		return min;
        	}
        	if(end - start == 1)	{mid = end;break;}
        	if(array[start] <= array[mid])	start = mid;
        	else{
//        		if(array[mid] <= array[end])
        			end = mid;
        	}
        }
        return array[mid];
      
    }
    
    public static void main(String[] args) {
		int[] array = {4,5,1,2,3};
		S9  s = new S9();
		System.out.println(s.minNumberInRotateArray(array));
	}
}
