
public class RectCover {
	 public int Cover(int target) {
		 int i = (int)(target/2);
		 int sum = 0;
		 return Sum(sum, target, i);
	 }
	 
	 public int Sum(int sum,int n,int i){
		 if(i < 0) return sum;
//		 sum += A(n-i)/(A(n-2*i)*A(i));
		 int temp = A(n-i,n-2*i,i);
		 sum += temp;
//		 System.out.println(n-i+":"+(n-2*i)+":"+i+":"+temp);
		 return Sum(sum, n, i-1);
	 }
	 public int A(int a,int b,int c){
		 int result = 0;
		 int tempa = 1;
		 for(;a>0 || b > 0|| c > 0;a--){
			 if(a > 0)
				 tempa *= a;
			 if(b>0 &&tempa % b ==0){
				 tempa = tempa/b;
				 b--;
			 }
			 if(c>0&&tempa % c ==0){
				 tempa = tempa/c;
				 c--;
			 }
		 }
		 result = tempa;
		 return result;
	 }
	 public int A(int m){
		 if(m == 0) return 1;
		 int result = 1;
		 for(int i =1;i<= m;i++){
			 result *= i;
		 }
		 return result;
	 }
	
	public static void main(String[] args) {
		RectCover rectCover = new RectCover();
		System.out.println(rectCover.Cover(29));
		
	}
}
