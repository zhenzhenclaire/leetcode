package leetcode;

/**
 * Created by Claire on 9/5/2015.
 */
public class S2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)  return l2;
        if(l2 == null)  return l1;
        if(l1 == null && l2 == null)    return null;
        ListNode p = l1;
        ListNode q = l2;

        ListNode addList = new ListNode(-1);
        ListNode a = addList;

        int extra = 0;
        int bitVal = 0;
        int num = 0;
        while(p != null || q != null){
            if(p == null){
                num = q.val;
            }
            else if (q == null){
                num = p.val;
            }
            else{
                num = p.val + q.val;
            }

            bitVal = extra + num;
            extra = 0;
            if(bitVal >= 10){
                extra = 1;
                bitVal -= 10;
            }


            ListNode node = new ListNode(bitVal);

            a.next = node;
            if(p != null)   p = p.next;
            if(q != null) q = q.next;
            a = a.next;
        }
        if(extra != 0){
            ListNode node = new ListNode(1);
            a.next = node;
        }
        return  addList.next;
    }

    public ListNode makeList(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for(int i = 1;i < nums.length;i++){
            ListNode node = new ListNode(nums[i]);
            p.next = node;
            p = node;
        }
        return head;
    }

    public void printList(ListNode list){
        while(list != null){
            System.out.print(list.val);
            list = list.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        S2 s = new S2();

        int[] num1 = {1};
        int[] num2 = {9,9};

        ListNode l1 = s.makeList(num1);
        System.out.print("L1:");
        s.printList(l1);

        ListNode l2 = s.makeList(num2);
        System.out.print("L2:");
        s.printList(l2);

        ListNode l = s.addTwoNumbers(l1, l2);
        System.out.print("L:");
        s.printList(l);


    }
}
