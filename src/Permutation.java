import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Permutation {
	ArrayList<String> list = new ArrayList<String>();
	HashMap<String, String> map = new HashMap<String, String>();
	
	 public ArrayList<String> Perm(String str) {
		 if(str == null || str.trim().length() == 0 || str.trim().length() > 9){
			 return list;
		 }
		 
		
	    ArrayList<String> strs = new ArrayList<String>();
	    ArrayList<String> result = new ArrayList<String>();
	    for(int i = 0; i < str.length();i++){
	    	char ch = str.charAt(i);
	    	if((ch >= 'a' && ch <= 'z') ||( ch >= 'A' && ch <= 'Z')){
	    		strs.add(str.charAt(i) + "");
	    	}
	    	else{
	    		return list;
	    	}
	    	
	    }
	    String string="";
	    Sort(result, strs);
	    for(Entry<String, String> node: map.entrySet()){
	    	list.add(node.getKey());
	    }
	    
	    Sort();
	    return list;
	 }
	 
	 public void Sort(){
			int i = 0,j = 0;
			for(i = 0; i < list.size() - 1;i++){
				String min = list.get(i);
				int minIndex = i;
				for(j = i + 1;j < list.size();j++){
					if(min.compareTo(list.get(j)) > 0){
						min = list.get(j);
						minIndex = j;
					}
				}
				
				String temp = "";
				
				temp = list.get(minIndex);
				list.set(minIndex,list.get(i));
				list.set(i, temp);
			}
		}
	 
	 
	 public void Sort(ArrayList<String> left,ArrayList<String> right){
		if(right.size() == 0){
//			for(String string : left){
//				System.out.print(string);
//			}
//			System.out.println();
			String flag = "";
			for(String string : left){
				flag += string;
			}
			//list.add(flag);
//			System.out.println(flag);
			map.put(flag, "");
		}

		else{
			for(int i = 0; i < right.size();i++){
				String str = right.get(0);
				right.remove(0);
				left.add(str);
				
				Sort(left, right);
				
				String lastString = left.get(left.size() - 1);
				right.add(lastString);
				left.remove(left.size() - 1);
			}
		}
	 }
	 
	 public static void main(String[] args) {
		 Permutation permutation = new Permutation();
		 ArrayList<String> list = new ArrayList<String>();
		 list = permutation.Perm("aab");
		 for(String s: list){
			 System.out.println(s);
		 }
	}
}
