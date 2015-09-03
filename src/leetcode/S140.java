package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class S140 {
	
	public List<String> result = new ArrayList<String>();
	boolean[] arrays;
	
	public List<String> wordBreak(String s, Set<String> wordDict) {
		ArrayList<String> dic = new ArrayList<String>();
		Iterator<String> iter = wordDict.iterator();
		while(iter.hasNext()){
			String word = iter.next();
			if(s.indexOf(word) != -1){
				dic.add(word);
			}
		}
		
		arrays = new boolean[s.length() + 1];
		arrays[0] = true;
		for(int i = 1;i <= s.length();i++){			
			for(int j = 0;j < i;j++){
				if(arrays[j] && wordDict.contains(s.subSequence(j, i))){
					arrays[i] = true;
					break;
				}
			}
		}
		if(arrays[s.length()] == true)	find("","", s, dic);
		return result;
	}
	
	/**
	 * 分割句子
	 * @param match 当前已匹配的子串（带空格）
	 * @param str 当前已匹配的子串（不带空格）
	 * @param string 剩余需要匹配的子串
	 * @param dic 字典
	 */
	public void find(String match, String str, String string , ArrayList<String> dic){

		if("".equals(string)){
			result.add(match);
			return;
		}

		for(String word:dic){
			
			if(string.indexOf(word) == 0 && arrays[str.length()]){
				String temp = match;
				if("".equals(temp))
					temp = word; 
				else
					temp += " "+word;
				find(temp,str + word, string.substring(word.length()),dic);
			}
		}
	}
	
//	public List<String> wordBreak(String s, Set<String> wordDict) {
//		String[] arrays = new String[s.length() + 1];
//		List<String> result = new ArrayList<String>();
//		arrays[0] = "";
//		for(int i = 1;i <= s.length();i++){			
//			for(int j = 0;j < i;j++){
//				if(arrays[j] != null && wordDict.contains(s.substring(j, i))){
//					arrays[i] = s.substring(j,i);
//					
//					break;
//				}
//					
//				
//			}
//		}
//		return arrays[s.length()];
//	}
	
	public static void main(String[] args) {
		S140 test = new S140();
		Set<String> set = new HashSet<String>();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		List<String> result = test.wordBreak("catsanddog", set);
		
		for(String s: result){
			System.out.println(s);
		}
		
	}
	
}
