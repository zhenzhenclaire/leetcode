package newCode;

import java.util.ArrayList;

public class S6 {
	public class ListNode{
		int val;
		ListNode next = null;
		public ListNode(int val) {
			// TODO Auto-generated constructor stub
			this.val = val;
		}	
	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(listNode != null){
        	list.add(listNode.val);
        	listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = list.size() - 1;i >= 0;i--){
        	result.add(list.get(i));
        }
        return result;
    }

}
