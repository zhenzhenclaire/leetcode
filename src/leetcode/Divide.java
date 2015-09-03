package leetcode;

public class Divide {
	public int divide1(int dividend, int divisor) {
        int flag = 0; //1-,0+
        int result = 0;
        int temp = 0;
        
        if(dividend != 0){
        	if(dividend < 0){
        		flag = 1;
        		dividend = -dividend;
        	}
            while(temp < divisor){
	        	temp += dividend;
	        	if(temp <= divisor){
	        		result++;
	        	}
	        }
			return (flag == 0) ? result : -result ;
        }
        else{
        	return Integer.MAX_VALUE;
        }
    }
	
	public int divide2(int dividend, int divisor) {
		
		int td = dividend;
        dividend = divisor;
        divisor = td;
        
        int sum = 0;
        boolean flag = (dividend < 0) ^ (divisor < 0); //1-,0+
        
        if(divisor == 0) return 0;
        
		if(dividend != 0){
        	if(dividend < 0){
        		dividend = -dividend;
        	}
        	if(divisor < 0){
        		divisor = -divisor;
        	}
        	
        	if(dividend < 0 ){
        		if(dividend + divisor < 0 ){
        			return 0;
        		}
        	}
        	
        	if(divisor < 0 && dividend >0){
        		int result = NN(dividend,divisor);
        		if(result < 0) return Integer.MAX_VALUE;
        		return (flag) ? result : -result ; 
        	}
        	
        	if(divisor < 0 && dividend <0){
        		int i = 0;
        		for(i = 0;divisor < 0;i++){
        			divisor -= dividend;
        		}
        		return (flag) ? i : -i ; 
        	}
        	
        	
        	int result = 0;
            int temp = divisor;
            int[][] times = new int[2][33]; 
            
        	
        	times[0][0] = 1;
            times[1][0] = dividend;
            
        	int i = 0;
            while(temp > 0){
            	if(times[1][i] < 0){
            		break;
            	}
            	temp -= times[1][i];
    			result += times[0][i];
    			times[1][i+1] = times[1][i] + times[1][i];
    			times[0][i+1] = times[0][i] + times[0][i];
    			i++;
    			
            }
            
            i--;
            temp += times[1][i];
            result -= times[0][i];
            
            
            while(temp > 0  && i >= 0){
            	if(temp - times[1][i] < 0){
            		i--;
            	}
            	else{
            		temp -= times[1][i];
            		result += times[0][i];
            	}
            }
            if(!flag && result < 0) return Integer.MAX_VALUE;
			return (flag) ? -result : result ;
        }
        else{
        	return Integer.MAX_VALUE;
        }
    }
	
    public int divide(int dividend, int divisor) {
		
		long  up = (long)dividend;
		long  down = (long)divisor;
		
    	
        boolean flag = (up < 0) ^ (down < 0); //1-,0+
        up = Math.abs(up);
        down = Math.abs(down);
        
        if(down == 0 || up == 0) return 0;
        	
        	long result = 0;
            long temp = up;
            long[][] times = new long[2][33]; 
        	
        	times[0][0] = 1;
            times[1][0] = down;
            
        	int i = 0;
            while(temp > 0){
            	
            	temp -= times[1][i];
    			result += times[0][i];
    			times[1][i+1] = times[1][i] + times[1][i];
    			times[0][i+1] = times[0][i] + times[0][i];
    			i++;
    			
            }
            
            i--;
            temp += times[1][i];
            result -= times[0][i];
            
            while(temp > 0  && i >= 0){
            	if(temp - times[1][i] < 0){
            		i--;
            	}
            	else{
            		temp -= times[1][i];
            		result += times[0][i];
            	}
            }
            
            long r = flag ? -result : result;
            
            if(r > Integer.MAX_VALUE || r < Integer.MIN_VALUE){
            	return Integer.MAX_VALUE;
            }
            
			return (flag) ? -((int)result) : (int)result;
        }
        


	public int NN(int dividend ,int divisor){
		
		int result = 0;
        int temp = divisor;
        int[][] times = new int[2][33]; 
        
    	
    	times[0][0] = 1;
        times[1][0] = dividend;
        
    	int i = 0;
        while(temp < 0){
        	if(times[1][i] < 0){
        		break;
        	}
        	temp += times[1][i];
			result += times[0][i];
			times[1][i+1] = times[1][i] + times[1][i];
			times[0][i+1] = times[0][i] + times[0][i];
			i++;
			
        }
        
        i--;
        temp -= times[1][i];
        result -= times[0][i];
        
        
        while(temp < 0  && i >= 0){
        	if(temp + times[1][i] > 0){
        		i--;
        	}
        	else{
        		temp += times[1][i];
        		result += times[0][i];
        	}
        }
        
		return result ;
		
	}
	
	public static void main(String[] args) {
		Divide d = new Divide();
		System.out.println(d.divide(-2147483648, 1));
	}

}	
