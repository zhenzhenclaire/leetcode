
public class BinarySearch {
	   
	public boolean Find1(int [][] array,int target) {
		
		int lowi = 0, lowj = 0 , highi = 0, highj = 0 ,middlei, middlej;
		
		int row = array.length;
		int col = array[0].length;
		//System.out.println(row +""  +col);
		highi = col - 1;
		highj = row - 1;
		
		middlei = (lowi + highi) / 2;
		middlej = (lowj + highj) / 2;
		
		if(col == 0 && row == 1)	return false;
		while(lowj <= highj){
			
			if(array[middlej][middlei] == target){
				return true;
			}
			else{
				if(array[middlej][middlei] > target){
					highj = middlej - 1;
				}
				else{
					lowj = middlej + 1;
				}
				middlej = (lowj + highj) / 2;
				while(lowi <= highi){
					
					if(array[middlej][middlei] == target){
						return true;
					}
					else{
						if(array[middlej][middlei] > target){
							highi = middlei - 1;
						}
						else {
							lowi = middlei + 1;
						}
					}
					middlei = (lowi + highi) / 2;				
				}
			}
		}
		return false;
	}
	
	public boolean Find(int [][] array,int target) {
	
		int row = array.length;
		int col = array[0].length;
		
		int i = 0;
		int j = col - 1;
		
		while(i <= row - 1 && j >= 0 ){	
			if(array[i][j] == target){
				return true;
			}
			else{
				if(array[i][j] < target){
					i += 1;
				}
				else{
					for(int m = 0; m < i;m ++){
						if(array[m][j] == target){
							return true;
						}
					}
					j -= 1;
				}
			}
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		//int[][] array = {{1,2,3,4},{2,9,17,18},{3,19,21,28}};
		int [][] array = {
				{0,1,3,4,5,7,8,11,13,15,18,21,24,27,30,32,35,36,39,41,42,43,46,49,52,55,58,60,63,66,67,69,72,75,78,80,81,82,85,86},
				{1,4,6,8,11,12,15,17,18,20,23,24,27,30,33,34,38,39,42,44,47,48,51,52,55,57,59,62,64,67,70,72,75,77,81,83,84,87,90,91},
				{5,8,10,13,15,19,21,23,24,27,29,31,34,37,38,41,43,45,46,49,52,55,58,59,61,64,67,69,71,72,76,78,79,83,87,90,91,94,96,97},
				{6,11,14,16,18,22,24,27,29,32,33,35,36,40,42,44,47,50,51,52,54,58,60,62,64,67,70,73,76,79,82,84,87,88,91,94,97,99,101,102},
				{9,13,16,19,21,23,25,29,31,35,38,39,42,45,48,51,54,56,57,60,63,64,67,69,72,73,74,76,79,81,85,88,90,92,95,98,100,101,104,106},
				{10,16,19,22,24,26,29,31,34,36,40,41,45,46,50,54,56,59,60,63,66,69,70,72,75,77,79,81,83,85,88,91,93,96,98,99,102,105,107,109}};
		BinarySearch binarySearch = new BinarySearch();
		boolean result = binarySearch.Find(array, 2300);
		if(result){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}
	}
	   
	   
}
