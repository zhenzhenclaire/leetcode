
public class BuildTree {

	public TreeNode build(String str1,String str2){
		TreeNode root,left,right;
		
		if(str1.length() == 0)	return null;
		System.out.println(str1 + "--------" + str2);
		int rootVal = str1.charAt(0) - '0';
		root = new TreeNode(rootVal);
		
		int index = str2.indexOf(rootVal + '0');
		String left2 = str2.substring(0,index);
		String right2 = str2.substring(index + 1);
		int leftLen = left2.length();
		int rightLen = right2.length();
		if(leftLen == 0)	left = null;
		else{
			String left1 = str1.substring(1, 1 + leftLen);
			left = build(left1, left2);
		}
		
		if(rightLen == 0)	right = null;
		else{
		String right1 = str1.substring(1 + leftLen);
		right = build(right1, right2);
		}
		
		root.left = left;
		root.right = right;
		return root;
	}
	
	public void printTree(TreeNode root){
		if(root != null){
			
			System.out.print(root.val);
			printTree(root.left);
			printTree(root.right);
		}
	}
	
	public static void main(String[] args) {
		BuildTree bTree = new BuildTree();
		TreeNode root = bTree.build("21743658", "12345678");
		bTree.printTree(root);
		String s = "1234";
		//System.out.println(s.substring(4));
	}
}
