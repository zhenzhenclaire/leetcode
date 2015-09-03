import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;


public class Subtree {
	
	public class TreeNode {
	  int val;
	  TreeNode left;
	  TreeNode right;
	  TreeNode(int x) { val = x; }
}
    public boolean HasSubtree1(TreeNode root1,TreeNode root2) {
    	TreeNode rootNode = findRoot(root1, root2);
    	if(rootNode == null){
    		return false;
    	}
    	else{
    		return isSame(rootNode, root2);
    	}
    }
    
    public boolean HasSubtree3(TreeNode root1,TreeNode root2) {
    	
    	
    	if(root1 == null || root2 == null){
    		return false;
    	}
    	else{
    		boolean temp = isSame(root1, root2);
    		if(!temp){
    			return (isSame(root1.left, root2) || isSame(root1.right, root2));
    		}
    		return temp;
    	}
    }
    
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    	String order1 = middleIndex(root1);
    	String order2 = middleIndex(root2);
    	System.out.println(order1);
    	System.out.println(order2);
    	if(order1.indexOf(order2) != -1){
    		return true;
    	}
    	else{
    		return false;
    	}
    
    }
    
    public String middleIndex(TreeNode node){
    	if(node == null){
    		return "";
    	}
    	String middleString = node.val + "";
    	String left = middleIndex(node.left);
    	String right = middleIndex(node.right);
    	return left + middleString + right;
    }
 
    
    public boolean isNull(TreeNode node){
    	if(node == null)
    		return true;
    	else{
    		return false;
    	}
    }
    
    public boolean isSame(TreeNode rootNode, TreeNode root2){
    	if(isNull(root2)){
    		return true;
    	}
    	if (isNull(rootNode) ^ isNull(root2)){
    		return false;
    	}
    	
    	if(rootNode.val != root2.val){
    		return false;
    	}
    	else{
    		boolean left = isSame(rootNode.left, root2.left);
    		boolean right = isSame(rootNode.right, root2.right);
    		
    		if(left == false || right == false){
    			return false;
    		}
    		else{
    			return true;
    		}
    	}
    }
    
    public TreeNode findRoot(TreeNode root1, TreeNode root2){
    	TreeNode root = root1;
    	
    	if(root.val == root2.val){
    		return root;
    	}
    	else{
    		
    		TreeNode left = findRoot(root.left, root2);
    		if(left != null){
    			return left;
    		}
    		
    		TreeNode right = findRoot(root.right, root2);
    		if(right != null){
    			return right;
    		}	
    	}
    	return null;
    }
    
    public TreeNode makeTree(int root, int[] tree){
		TreeNode rootNode = new TreeNode(tree[root]);
		int left = 2 * root + 1;
		int right = 2 * root + 2;
		if(left >= tree.length){
			rootNode.left = null;
		}else{
			rootNode.left = makeTree(left, tree);
		}
		if(right >= tree.length){
			rootNode.right = null;
		}else{
		
			rootNode.right = makeTree(right, tree);
		}
		return rootNode;
	}
    
    public static void main(String[] args) {
    	int[] tr1 = new int[]{8,8,7,9,2,0,0,0,0,4,7};
    	int[] tr2 = new int[]{8,9,2};
    	Subtree tree = new Subtree();
    	TreeNode root1 = tree.makeTree(0, tr1);
    	TreeNode root2 = tree.makeTree(0, tr2);
    	if(tree.HasSubtree(root1,root2) == true){
    		System.out.println("yes");
    	}
    	else{
    		System.out.println("no");
    	}
    	
	}
}
