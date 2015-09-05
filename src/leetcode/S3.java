package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Claire on 9/5/2015.
 */
public class S3 {
    public int lengthOfLongestSubstring(String s){
        if("".equals(s) || s == null)   return 0;
        HashMap<Character,Integer> hm = new HashMap<>();

        char[] chs = s.toCharArray();
        int length = chs.length;
        int[] maxLengthLeft = new int[chs.length];
        int[] maxLengthRight = new int[chs.length];

        //initialize
        maxLengthLeft[0] = 1;


        hm.put(chs[0],1);

        int maxLeft = 1;
        int maxRight = 1;
        for(int i = 1;i < length;i++){
            char ch = chs[i];
            //not occurred
            if(hm.get(ch) == null){
                hm.put(ch,1);
                maxLengthLeft[i] = maxLengthLeft[i - 1] + 1;
                if(maxLengthLeft[i] > maxLeft) maxLeft = maxLengthLeft[i];
            }
            else{
                maxLengthLeft[i] = 1;
            }
        }

        hm = new HashMap<>();
        maxLengthRight[length - 1] = 1;
        hm.put(chs[length - 1], 1);
        for(int i = chs.length - 2;i >= 0;i--){
            char ch = chs[i];
            if(hm.get(ch) == null){
                hm.put(ch,1);
                maxLengthRight[i] = maxLengthRight[i + 1] + 1;
                if(maxLengthRight[i] > maxRight) maxRight = maxLengthRight[i];
            }
            else{
                maxLengthRight[i] = 1;
            }
        }

        return Math.max(maxLeft,maxRight);
    }

    public int lengthOfLongestSubstring2(String s) {
        if("".equals(s) || s == null)   return 0;

        HashMap<Character,Integer> hm = new HashMap<>();
        char[] chs = s.toCharArray();
        int start = 0,end = 0;

        int maxLen = 0;

        while(end < s.length()){
            char ch = chs[end];
            if(hm.get(ch) == null){
                hm.put(ch,end);
                end++;
            }
            else{
                int index = hm.get(ch);
                for(int j = start;j <= index; j++)  hm.remove(chs[j]);
                start = index + 1;

            }
            maxLen = Math.max(maxLen,end - start);
        }

        return maxLen;
    }

    public int lengthOfLongestSubstring1(String s) {
        if("".equals(s) || s == null)   return 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int[] nums = new int[s.length()];

        int flag = -1;
        char[] chs = s.toCharArray();
        nums[0] = 1;
        hm.put(chs[0],0);
        int max = nums[0];
        for(int i = 1;i < chs.length;i++){
            char ch = chs[i];
            if(hm.get(ch) == null){
                nums[i] = nums[i - 1] + 1;
            }
            else{

                int index = hm.get(ch);
                if(index < flag){
                    nums[i] = nums[i-1] + 1;
                }else {

                    nums[i] = nums[i-1] + 1 - nums[index] ;
                    flag = index;
                }
            }
            hm.put(ch,i);
            if(nums[i] > max )  max = nums[i];
        }
        return max;
    }

    public static void main(String[] args){
        S3 s = new S3();
        String str = "asjrgapa";
        System.out.print(s.lengthOfLongestSubstring2(str));
    }
}
