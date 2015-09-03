import java.util.ArrayList;

public class Path {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
	       ArrayList<Integer> path = new ArrayList<Integer>();
	       find(root, target, path);
	       return result;
	}
	
	public void find(TreeNode root, int left, ArrayList<Integer> current){
		  ArrayList<Integer> path = new ArrayList<Integer>();
		  
		
		
			if(root == null || root.val > left){
				return;
			}
			else{
				left -= root.val;
				current.add(root.val);
				path.addAll(current);
				if(left == 0 && root.left == null && root.right == null){
					result.add(path);
					return;
				}
				
				find(root.left, left, path);
				
				path.clear();
				path.addAll(current);
				find(root.right, left, path);
			}
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
		Path path = new Path();
		int[] tree = new int[]{1,3,4,6,9,8,11};
		TreeNode root = path.makeTree(0, tree);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result = path.FindPath(root,13);
		System.out.println(result.size());
		for(ArrayList<Integer> list:result){
			for(Integer i : list){
				System.out.print(i);
			}
			System.out.println("----");
		}
	}
}
