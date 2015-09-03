package leetcode;

public class S121 {
	public int maxProfit(int[] prices) {
		int days = prices.length;
		if(days == 0)	return 0;
		int[] maxPro = new int[days];
		int[] min = new int[days];
		
		for(int i = 0;i < days;i++){
			if(i == 0){
				maxPro[0] = 0;
				min[0] = prices[0];
			}
			else if(i == 1){
				int r = prices[1] - prices[0]; 
				if(r < 0){
					maxPro[1] = 0;
				}
				else{
					maxPro[1] = r;
				}	
				min[1] = Math.min(prices[0], prices[1]);
			}
			else{
				min[i] = Math.min(min[i - 1], prices[i]); 
				maxPro[i] = Math.max(maxPro[i - 1], prices[i] - min[i]);
			}
		}
		
		return maxPro[days - 1];
    }
	
	public static void main(String[] args) {
		S121 s = new S121();
		int[] prices = {4,3,2,1};
		System.out.println(s.maxProfit(prices));
	}
	
}
