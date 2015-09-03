package newCode;

import java.util.Stack;

public class S8 {
	  	Stack<Integer> stack1 = new Stack<Integer>();
	    Stack<Integer> stack2 = new Stack<Integer>();
	    
	    public void push(int node) {
	    	stack1.push(node);
	    }
	    
	    public int pop() {
	    	if(stack2.isEmpty()){
		    	while(!stack1.isEmpty()){
		    		int top = stack1.peek();
		    		stack1.pop();
		    		stack2.push(top);
		    	}
	    	}
	    	int top2 = stack2.peek();
	    	stack2.pop();
	    	return top2;
	    }
	    
	    public static void main(String[] args) {
			S8 s = new S8();
			s.push(1);
			s.push(2);
			s.push(3);
			System.out.print(s.pop());
			System.out.print(s.pop());
			s.push(4);
			System.out.print(s.pop());
			s.push(5);
			System.out.print(s.pop());
			System.out.print(s.pop());
		}
	
}
