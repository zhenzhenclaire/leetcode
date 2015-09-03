
public class PrintMinNum {
	
	
    public String PrintMinNumber(int [] numbers) {
    	String resultString = "";
    	int total = numbers.length;
    	
    	String[] numStrings = new String[total];
    	
    	for(int i = 0;i < total;i++){
    		numStrings[i] = numbers[i] + ""; 
    	}
    	
    	char ch = '9';
    	int maxLength = 0;
    	
    	for(String str:numStrings){
    		char c = str.charAt(0);
    		int len = str.length();
    		if(c < ch)	ch = c;
    		if(len > maxLength)	maxLength = len;
    	}
    	
    	for(int i = 0 ;i < numStrings.length;i++){
    		int len = numStrings[i].length(); 
    		if(len < maxLength){
    			for(int j = 0; j < maxLength - len;j++){
    				numStrings[i] += ch;
    			}
    		}
    	}
    	int[] result = Sort(numStrings);
    	for(int i =0 ;i < numbers.length;i++){
    		resultString+=numbers[result[i]];
    	}
    	return resultString;
    }
    
    public int[] Sort(String[] list){
    	
//    	for(String sts: list){
//    		System.out.println(sts);
//    	}
    	
    	int[] result = new int[list.length];
		int i = 0,j = 0;
		for(i = 0; i < list.length;i++){
			String min = list[i];
			int minIndex = i;
			for(j = 0;j < list.length;j++){
				if(min.compareTo(list[j]) > 0){
					min = list[j];
					minIndex = j;
				}
			}
			
			
			list[minIndex] = "9";

			result[i] = minIndex;
		}
		return result;
	}
 
    
    public static void main(String[] args) {
    	PrintMinNum p = new PrintMinNum();
    	int numbers[] = {321,32,3};
    	System.out.println(p.PrintMinNumber(numbers));
    	
	}
}
