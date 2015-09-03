package leetcode;

public class S122 {
	public int maxProfit(int[] prices) {
		int maxPro = 0;
		for (int i = 1;i < prices.length;i++){
			if(prices[i] > prices[i - 1]){
				maxPro += prices[i] - prices[i - 1];
			}
		}
		
		return maxPro;
	}
	
	public static void main(String[] args) {
		S122 s = new S122();
		int[] prices = {2,1,2,0,1};
		System.out.println(s.maxProfit(prices));
	}
}
