package baidu;

public class MaxSum {
	int array[];
	
	public MaxSum(int[] array) {
		super();
		this.array = array;
	}	
	
	public int sum(){
		return f(array.length - 1);
	}
	
	public int f(int n){
		if(n == 0)	return array[0];
		if(n < 0)	return 0;
		return Math.max(f(n - 2) + array[n], f(n - 1));
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,-2,4,6,-3,5};
		MaxSum ms = new MaxSum(array);
		System.out.println(ms.sum());
	}
}
