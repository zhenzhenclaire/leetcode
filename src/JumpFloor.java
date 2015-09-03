
public class JumpFloor {
	
	public int Jump(int target) {
		int result = 0;
		result = f(target);
		return result;
    }
	
	public int f(int n){
		if(n == 1)return 1;
		else{
			if(n == 2)return 2;
			else{
				return  f(n -1) + f(n -2);
			}  
		}
	}
	
	
	public static void main(String[] args) {
		JumpFloor jFloor = new JumpFloor();
		System.out.println(jFloor.Jump(5));
	}
}
