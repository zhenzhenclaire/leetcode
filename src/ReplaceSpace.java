
public class ReplaceSpace {
	 public String replace1(StringBuffer str) {
		 String input = str.toString();
		 String result = "";
	    	for(int i = 0;i < input.length();i++){
	    		if(input.charAt(i) == ' '){
	    			result += "%20";
	    		}
	    		else{
	    			result += input.charAt(i);
	    		}
	        }
	        return result;
	    }
	 
	 public String replace(StringBuffer str) {
	    	String result = str.toString().replaceAll(" ", "%20");
	        return result;
	    }
	 
	 public static void main(String[] args) {
		 ReplaceSpace replaceSpace = new ReplaceSpace();
		 System.out.println(replaceSpace.replace1(new StringBuffer("helloworld   ")));
		 
	}
}
