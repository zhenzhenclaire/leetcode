package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;


public class S95 {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

	 public List<TreeNode> generateTrees(int n) {
		 return createTree(1, n);
	 }
	 
	 public List<TreeNode> createTree(int start, int end){
		 List<TreeNode> resultList = new ArrayList<TreeNode>();
		 
		 if(start > end){
			 resultList.add(null);
			 return resultList;
		 }
		 
		 for(int k = start;k <= end;k++){
			 List<TreeNode> left = createTree(start, k - 1); 	//left tree
			 List<TreeNode> right = createTree(k + 1, end);	//right tree

			 for(int i = 0;i < left.size();i++){
				 for(int j = 0;j < right.size();j++){
					 TreeNode root = new TreeNode(k);
					 root.left = left.get(i);
					 root.right = right.get(j);
					 resultList.add(root);
				 }
			 }
		 }
		 
		 return resultList;
	 }
}
