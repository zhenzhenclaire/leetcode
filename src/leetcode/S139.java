package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class S139 {
	public boolean wordBreak1(String s, Set<String> wordDict) {
		String leftString = s;
		Iterator<String> iter = wordDict.iterator();
		while(iter.hasNext()){
			String word = iter.next();
			int in = leftString.indexOf(word);
			if(in != -1){
				int len = leftString.length();
				leftString = leftString.substring(0,in) + leftString.substring(word.length(),len);
				System.out.println(leftString);
				if(leftString.equals(""))	return true;
			}
		}
		return false;
    }
	
	public boolean wordBreak2(String s, Set<String> wordDict) {
		char[] ch = s.toCharArray();
		
		return find(0, s, wordDict);
	}
	
	public boolean find(int index, String string , Set<String> wordDict){
		if(index == string.length()) return true;
		if(index > string.length()) return false;
//		ArrayList<String> strList = new ArrayList<String>();
		
		Iterator<String> iter = wordDict.iterator();
		
		while(iter.hasNext()){
			String word = iter.next();
			int l = index + word.length() > string.length() ? string.length() : index + word.length();
			if(word.charAt(0) == string.charAt(index) && word.equals(string.substring(index, l))){
				if(find(word.length()+index,string,wordDict) == true)
					return true;
			}
		}
//		if(strList.size() == 0)	return false;
//		for(String s:strList){
//			if(find(s.length()+index,string,wordDict) == true)
//				return true;
//		}
		return false;
	}
	
	public boolean wordBreak3(String s, Set<String> wordDict) {
		boolean[] arrays = new boolean[s.length() + 1];
		arrays[0] = true;
		for(int i = 1;i <= s.length();i++){			
			for(int j = 0;j < i;j++){
				if(arrays[j] && wordDict.contains(s.subSequence(j, i))){
					arrays[i] = true;
					break;
				}
			}
		}
		return arrays[s.length()];
	}
	
	public boolean wordBreak(String s, Set<String> wordDict) {
		return find(s, wordDict);
	}
	
	public boolean find(String string , Set<String> wordDict){
		
		if("".equals(string)){
		
			return true;
		}
		
		Iterator<String> iter = wordDict.iterator();
		
		while(iter.hasNext()){
			String word = iter.next();
			if(string.indexOf(word) == 0){
				if(find(string.substring(word.length()),wordDict) == true)	return true;
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		S139 s = new S139();
		Set<String> set = new HashSet<String>();
		set.add("a");
		
		boolean result = s.wordBreak("a", set);
		if(result == true){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}
	}
}
