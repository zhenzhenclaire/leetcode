import java.util.ArrayList;

public class PrintZhi {
	// Print(TreeNode pRoot) {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){

		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
		 if(pRoot == null)	return resultList;
		ArrayList<TreeNode> Nodelist = new ArrayList<TreeNode>();
		ArrayList<Integer> valueList = new ArrayList<Integer>();
		ArrayList<Integer> firstValue = new ArrayList<Integer>();
		firstValue.add(pRoot.val);
		resultList.add(firstValue);
		Nodelist.add(pRoot);
		
		int total = 1;
		int times = 1;
		while(Nodelist.size() != 0){ 
			if(total == 0){
				total = Nodelist.size();
				ArrayList<Integer> layer = new ArrayList<Integer>();
				layer = layer(times, Nodelist);
				resultList.add(layer);
				times++;
			}
			TreeNode firstNode = Nodelist.get(0);
			TreeNode left = firstNode.left;
			TreeNode right = firstNode.right;
			if(left != null)	Nodelist.add(left);
			if(right != null)	Nodelist.add(right);
			valueList.add(firstNode.val);
			Nodelist.remove(0);
			total--;
		}
		
		return resultList;
	}
	
	public ArrayList<Integer> layer(int times, ArrayList<TreeNode> nodeList){
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(times % 2 != 0){
			for(int i = nodeList.size() - 1;i >= 0;i--){
				list.add(nodeList.get(i).val);
			}
			return list;
		}
		else{
			for(int i = 0;i < nodeList.size();i++){
				list.add(nodeList.get(i).val);
			}
			return list;
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
		PrintZhi printZhi = new PrintZhi();
		int[] tree = new int[]{1,3,4,6,9,8,11};
		TreeNode root = printZhi.makeTree(0, tree);
		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
		resultList = printZhi.Print(root);
		
		for(ArrayList<Integer> list:resultList){
			for(Integer i:list){
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
}
