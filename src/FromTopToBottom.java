import java.util.ArrayList;

public class FromTopToBottom {
	
	  
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
	
	
}
