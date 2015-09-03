
public class ReverseS {
	public String ReverseSentence(String str) {
		if(str.trim().equals(""))
			return str;
        String[] strs = str.split(" ");
        String newString = new String("");
        for(int i = strs.length - 1; i > 0;i--){
        	newString += strs[i] + " ";
        }
        newString += strs[0];
        return newString;
    }
	
	public static void main(String[] args) {
		ReverseS reverseS = new ReverseS();
		System.out.println(reverseS.ReverseSentence(" "));
	}
}
