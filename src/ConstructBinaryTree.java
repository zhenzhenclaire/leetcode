
public class ConstructBinaryTree {

	  public class TreeNode {
		  int val;
		  TreeNode left;
		  TreeNode right;
		  TreeNode(int x) { val = x; }
	  }
	  
	  public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		  if(pre.length == 1 || in.length == 1)
			  return new TreeNode(pre[0]);
		  if(pre.length == 0 || in.length == 0)
			  return null;
//		  System.out.println("---------------pre:");
//		  for(int a : pre){
//			  System.out.print(a);
//		  }
//		 System.out.println();
//		  System.out.println("--------------------in:");
//		  for(int a : in){
//			  System.out.print(a);
//		  }
//		  System.out.println();
		  TreeNode rootNode = new TreeNode(pre[0]);
		  
		  int preIndex = 0;
		  while(preIndex < in.length && in[preIndex] != pre[0]){
			  preIndex++;
		  }
		  //System.out.println(preIndex);
		  
		  int[] preLeft = new int[0];
		  int[] preRight = new int[0];
		  if(preIndex >0 ){
			  preLeft = new int[preIndex];
			  System.arraycopy(pre, 1, preLeft, 0, preLeft.length);
		  }
		  if(pre.length - preIndex - 1 >0 ){
			  preRight = new int[pre.length - preIndex - 1];
			  System.arraycopy(pre, preLeft.length + 1, preRight, 0, preRight.length);
		  }
		  
		  int[] inLeft = new int[0];
		  int[] inRight = new int[0];
		  if(preIndex >0 ){
			  inLeft = new int[preIndex];
			  System.arraycopy(in, 0, inLeft, 0, inLeft.length);
		  }
		  if(pre.length - preIndex - 1 >0 ){
			  inRight = new int[pre.length - preIndex - 1];
			  System.arraycopy(in, inLeft.length + 1, inRight, 0, inRight.length);
		  }
		  
		  rootNode.left = reConstructBinaryTree(preLeft, inLeft);
		  rootNode.right = reConstructBinaryTree(preRight, inRight);
		  
		  return rootNode;
	  }
	  
	  public String next(TreeNode rootNode){
		  if(rootNode == null)	return "";
		  String left = next(rootNode.left);
		  String right = next(rootNode.right);
		  return left+right+rootNode.val;
	  }
	  
	  public String pre(TreeNode rootNode){
		  if(rootNode == null)	return "";
		  String left = next(rootNode.left);
		  String right = next(rootNode.right);
		  return left+rootNode.val + right;
	  }
	  public static void main(String[] args) {
		  ConstructBinaryTree tree = new ConstructBinaryTree();
		  TreeNode rootNode = tree.reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6});
		  System.out.println(tree.next(rootNode));
	}

}
