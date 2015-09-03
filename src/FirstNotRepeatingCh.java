import java.util.LinkedHashMap;
import java.util.Map.Entry;


public class FirstNotRepeatingCh {
    public int FirstNotRepeatingChar(String str) {
    	int len = str.length();
    	int index = 0;
    	if(len >= 1 && len <= 10000){
    		LinkedHashMap<Character, Integer> charmap = new LinkedHashMap<Character,Integer>();
    		for(int i = 0; i < len;i++){
    			Character key = str.charAt(i);
    			if(charmap.get(key) != null){
    				charmap.put(key, charmap.get(key) + 1);
    			}
    			else{
    				charmap.put(key, 1);
    			}
    		}
    		
    		char result = '0';			
    		
    		for(Entry<Character, Integer> node: charmap.entrySet())
    		{
    			if(node.getValue() == 1){
    				result = node.getKey();
    				break;
    			}	
    		}
    		
    		index = str.indexOf(result);
    		return index;
    	}
    	else if(len == 0){
    		return -1;
		}
    	else{
    		return 0;
    	}
    }
    
    public static void main(String[] args) {
    	FirstNotRepeatingCh firCh = new FirstNotRepeatingCh();
    	System.out.println(firCh.FirstNotRepeatingChar("abcdac"));
	}
}	
