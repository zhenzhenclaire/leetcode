
public class JumpFloorII {
    public int Jump2(int target) {
    	int current = 0;
    	f(0, target);
    	return result;
    }
    
    int result = 0;
    
    public void f(int current, int n){
    	for(int i = 1;i <= n;i++){
    		int sum = current + i;
    		if(sum > n) return;
    		else if (sum == n){
    			result++;
    			return;
    		}
    		else{
    			f(sum, n);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	JumpFloorII j = new JumpFloorII();
//    	j.Jump2(1);
//    	System.out.println(j.result);
    	int cur = 0;
    	Current current = new Current();
    	j.test(cur);
    	j.test(current);
    	System.out.println(cur);
    	System.out.println(current.n);
	}
    
    public void test(int cur){
    	cur = cur+100;
    }
    public void test(Current cur){
    	cur.n += 100;
    }
}


class Current{
	int n;
}
