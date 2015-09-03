package newCode;

public class S4 {
	public boolean Find(int [][] array,int target) {
		int col = array[0].length;
		int row = array.length;
		
		int i = 0, j = col - 1;
		while(i < row && j >= 0){
			if(target == array[i][j])	return true;
			else if(target < array[i][j])	j--;
			else	i++;
		}
		return false;
    }
	
	public static void main(String[] args) {
		S4 s4 = new S4();
		int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		if(s4.Find(array, 23) == true)	System.out.println("yes");
		else {
			System.out.println("no");
		}
		
	}
}
