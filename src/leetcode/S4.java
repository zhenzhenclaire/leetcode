package leetcode;

/**
 * Created by Claire on 9/7/2015.
 */
public class S4 {
    public boolean isPalindrome(int i ,int j,char[] a){
        if(i == j)  return true;
        if(i + 1 == j)  return a[i + 1] == a[j];
        return isPalindrome(i + 1,j - 1,a) && (a[i] == a[j]);
    }

    public String longestPalindrome(String s) {
        int maxLeft = 0;
        int maxRight = 0;
        char[] chs = s.toCharArray();
        boolean flag = false;
        for (int i = 0; i < chs.length; i++) {
            for (int j = chs.length - 1; j >= i; j--) {
                if (isPalindrome(i, j, chs)) {
                    if(j - i > maxRight - maxLeft){maxLeft = i;maxRight = j;}
                    flag = true;
                }
            }
        }
        if(flag)    return s.substring(maxLeft,maxRight + 1);
        else    return "";
    }



    public static void main(String[] args){
        S4 s = new S4();
        System.out.print(s.longestPalindrome(""));
    }
}
