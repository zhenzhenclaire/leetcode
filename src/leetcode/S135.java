
package leetcode;

public class S135 {
	public int candy(int[] ratings) {
		int[] candies = new int[ratings.length];
		
		for(int i = ratings.length - 1;i > 0;i--){
			if(ratings[i] < ratings[i - 1])	
				if(candies[i - 1] < candies[i] + 1){
					candies[i - 1] = candies[i] + 1;
				}
		}
		
		for(int i = 0;i < ratings.length - 1;i++){
			if(ratings[i] < ratings[i + 1])	
				if(candies[i + 1] < candies[i] + 1){
					candies[i + 1] = candies[i] + 1;
				}
		}
		
		int sum = candies.length;
		for(int i = 0;i < candies.length;i++){
			sum += candies[i];
		}
		
		return sum;
    }
	
	public static void main(String[] args) {
		S135 s = new S135();
		int[] ratings = {1,3,4,3,2,1};
		System.out.println(s.candy(ratings));
	}
}
