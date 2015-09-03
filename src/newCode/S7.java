package newCode;

public class S7 {
	public class TreeNode{
		int val;
		TreeNode left = null;
		TreeNode right = null;
		public TreeNode(int val){
			this.val = val;
		}
	}
	
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		return re(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
	
	public TreeNode re(int[] pre,int preStart,int preEnd, int[] in, int inStart,int inEnd){
		
		int rootVal = pre[preStart];
		TreeNode root = new TreeNode(rootVal);
		
		int rootIndex = 0;
		for(int i = 0;i < in.length;i++){
			if(in[i] == rootVal)	{rootIndex = i;break;}
		}
		int numOfLeft = rootIndex - inStart;
		int numOfRight = preEnd - preStart - numOfLeft;
		TreeNode left = null;
		TreeNode right = null;
		
		if(numOfLeft != 0)		left = re(pre, preStart + 1, preStart + numOfLeft, in, inStart ,inStart + numOfLeft - 1);
		if(numOfRight != 0)		right = re(pre, preStart + numOfLeft + 1, preStart + numOfLeft + numOfRight, in, rootIndex + 1, rootIndex + numOfRight);
		root.left = left;
		root.right = right;
		return root;
	}
	
	public void preTraverse(TreeNode root){
		if(root != null){
			System.out.print(root.val);
			preTraverse(root.left);
			preTraverse(root.right);
		}
	}
	
	public static void main(String[] args) {
		S7 s7= new S7();
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		TreeNode root = s7.reConstructBinaryTree(pre, in);
		s7.preTraverse(root);
	}
}
