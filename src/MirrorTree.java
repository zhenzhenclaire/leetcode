import java.util.ArrayList;


class TreeNode {
		  int val;
		  TreeNode left;
		  TreeNode right;
		  TreeNode(int x) { val = x; }
}

public class MirrorTree {
//	public class TreeNode {
//		  int val;
//		  TreeNode left;
//		  TreeNode right;
//		  TreeNode(int x) { val = x; }
//	}
	
	public void Mirror(TreeNode root) {
		//root = makeMirror(root);
		if(root == null)	return;
		TreeNode newNode = root.left;
		root.left = root.right;
		root.right = newNode;
		Mirror(root.left);
		Mirror(root.right);
    }
	
	public TreeNode makeMirror(TreeNode root){
		if(root == null)	return null;
		TreeNode newNode = new TreeNode(root.val);
		newNode.left = makeMirror(root.right);
		newNode.right = makeMirror(root.left);
		return newNode;	
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
	
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> resultArrayList = new ArrayList<Integer>();
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		if(root == null)	return resultArrayList;
		queue.add(root);
		while(queue.size() != 0){
			TreeNode firstNode = queue.get(0);
			if(firstNode.left != null){
				queue.add(firstNode.left);
			}
			if (firstNode.right != null) {
				queue.add(firstNode.right);
			}
			resultArrayList.add(firstNode.val);
			queue.remove(0);
		}
		return resultArrayList;
    }
	
	
	public static void main(String[] args) {
		int[] tree = new int[]{8,6,10,5,7,9,11};
		MirrorTree mirrorTree = new MirrorTree();
		TreeNode root = mirrorTree.makeTree(0, tree);
		
		ArrayList<Integer> resultArrayList = new ArrayList<Integer>();
		resultArrayList = mirrorTree.PrintFromTopToBottom(root);
		for(Integer i:resultArrayList){
			System.out.print(i);
		}
	}
	
}
