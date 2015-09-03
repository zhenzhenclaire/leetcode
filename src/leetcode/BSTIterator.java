package leetcode;

import java.util.ArrayList;

import leetcode.S95.TreeNode;

public class BSTIterator {
	ArrayList<Integer> orderedList = new ArrayList<Integer>();
	int index,length;
	
    public void MiddleOrder(TreeNode root){
    	if(root != null){
    		MiddleOrder(root.left);
    		orderedList.add(root.val);
    		MiddleOrder(root.right);
    	}
    }
	
	public BSTIterator(TreeNode root) {
		MiddleOrder(root);
		index = 0;
		length = orderedList.size();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(index < length){
        	index++;
        	return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        return orderedList.get(index - 1);
    }
    
    public static void main(String[] args) {
		
	}
}
