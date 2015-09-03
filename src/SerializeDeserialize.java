import java.sql.Array;
import java.util.ArrayList;


public class SerializeDeserialize {
	Integer index = 1;
	public String Serialize(TreeNode root) {
		String str = "";
		String middle = "";
		if(root == null){
			middle = "#,";
			return middle;
			//return null;
		}
		else{
			middle = root.val + ",";
		}
		String left = Serialize(root.left) + "";
		String right = Serialize(root.right) + "";
		return middle+left+right; 
	}
	
	public TreeNode Deserialize(String str) {
	    String[] strings = str.split(",");
	    if(strings.length == 0)	return null;
	    if(strings[0].equals("#")){
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
	    d(root, strings);
	    return root;
	}
	
	public void d(TreeNode root, String[] strings ){
		if(index >= strings.length)return;
		String str =  strings[index];
		if(str.equals("#")){
			index++;
		}
		else{
			TreeNode left = new TreeNode(Integer.parseInt(strings[index]));
			if(left != null){
				root.left = left;
			}
			index++;
			d(root.left, strings);
		}
		
		if(strings[index].equals("#")){
			index++;
		}else{
			TreeNode right = new TreeNode(Integer.parseInt(strings[index]));
			if(right != null){
				root.right = right;
			}
			index++;
			d(root.right, strings);
		}
		
	}
	
	 public TreeNode makeTree(int root, int[] tree){
		 	if(tree.length == 0) return null;
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
		SerializeDeserialize serializeDeserialize = new SerializeDeserialize();
		int[] tree = new int[]{8,6,10,5,7,9,11};
		TreeNode root = serializeDeserialize.makeTree(0, tree);
		
		String result = serializeDeserialize.Serialize(root);
		TreeNode deserializeRootNode = serializeDeserialize.Deserialize(result);
		//String deResult = serializeDeserialize.Serialize(deserializeRootNode);
		//System.out.println(deResult);
		
		FromTopToBottom fBottom = new FromTopToBottom();
		ArrayList<Integer> list = fBottom.PrintFromTopToBottom(deserializeRootNode);
		for(int i : list){
			System.out.print(i);
		}
	}
}
