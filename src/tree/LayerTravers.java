package tree;

import java.util.ArrayList;

public class LayerTravers {
	public class TreeNode{
		char ch;
		TreeNode leftNode;
		TreeNode rightNode;
		public TreeNode(char c){
			ch = c;
		}
	}
	
	int index = 0;
	
	public TreeNode makeTree(String str){
		
		char ch = str.charAt(index);
		if(ch != '#'){
			TreeNode root = new TreeNode(ch);
			index++;
			root.leftNode = makeTree(str);
			root.rightNode = makeTree(str);
			return root;
		}
		else {
			index++;
			return null;
		}
	}
	
	public void midTravers(TreeNode root){
		if(null == root){
			System.out.print("#");
			return;
		}
		midTravers(root.leftNode);
		System.out.print(root.ch);
		midTravers(root.rightNode);
	}
	
	public void layertravers(TreeNode root){
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if(root != null){
			list.add(root);
		}
		while(list.size() != 0){
			TreeNode node = list.get(0);
			System.out.print(node.ch);
			if(node.leftNode != null)	list.add(node.leftNode);
			if(node.rightNode != null)	list.add(node.rightNode);
			list.remove(0);
		}
	}
	
	public void DFS(TreeNode root){
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if(root != null){
			list.add(root);
		}
		while(list.size() != 0){
			TreeNode node = list.get(list.size() - 1);
			System.out.print(node.ch);
			list.remove(list.size() - 1);
			if(node.leftNode != null) list.add(node.leftNode);
			if(node.rightNode != null) list.add(node.rightNode);
		}
	}
	
	public void middleTravers(TreeNode root){
		TreeNode node = root;
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		while(list.size() != 0 || node != null){
			while(node != null){
				list.add(node);
				node = node.leftNode;
			}
			node = list.get(list.size() - 1);
			System.out.print(node.ch);
			list.remove(list.size() - 1);
			node = node.rightNode;
		}
	}
	
	public void afterTravers(TreeNode root){
		
		ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
		ArrayList<Boolean> list2 = new ArrayList<Boolean>();
		list1.add(root);
		list2.add(true);
		while(list1.size() != 0){
			TreeNode top = list1.get(list1.size() - 1);
			Boolean temp = list2.get(list2.size() - 1);
			list1.remove(list1.size() - 1);
			list2.remove(list2.size() - 1);
			
			if(!temp)	System.out.print(top.ch);
			else{
				list1.add(top);
				list2.add(false);
				
				if(top.rightNode!= null){
					list1.add(top.rightNode);
					list2.add(true);
				}
				if(top.leftNode!= null){
					list1.add(top.leftNode);
					list2.add(true);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		LayerTravers lTravers = new LayerTravers();
		String str = "124#5###3##";
		TreeNode root =lTravers.makeTree(str);
		//lTravers.midTravers(root);
//		lTravers.layertravers(root);
//		lTravers.DFS(root);
//		lTravers.middleTravers(root);
		lTravers.afterTravers(root);
	}
}
