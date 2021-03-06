package leetcode;

import java.util.List;

/**
 * Created by Claire on 9/3/2015.
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
public class S86 {
    public ListNode partition(ListNode head, int x) {

        if(head == null || head.next == null)    return head;

        ListNode smaller = new ListNode(-1);
        ListNode p = smaller;
        ListNode bigger = new ListNode(-1);
        ListNode q = bigger;

        while(head != null){
            ListNode node = new ListNode(head.val);
            if(node.val < x){
                p.next = node;
                p = p.next;
            }
            else{
                q.next = node;
                q = q.next;
            }
            head = head.next;
        }

        p = smaller;
        bigger = bigger.next;

        while(p.next != null){
            p = p.next;
        }
        p.next = bigger;
        ListNode finalList = smaller;

        return  finalList.next;
    }

    public ListNode partition1(ListNode head, int x) {
        if(head == null || head.next == null)    return head;

        ListNode p = head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        int time = 0;
        while(p.next != null){
            p = p.next;
            time++;
        }
        ListNode tail = p;
        tail.next = null;

        p = head;
        ListNode q = newHead;
        ListNode pTail = tail;

        while(time-- >= 0){
            if(p.val >= x && p != pTail){
                q.next = p.next;
                p.next = pTail.next;
                pTail.next = p;
                pTail = pTail.next;
                p = q.next;
            }
            else{
                p = p.next;
                q = q.next;
            }
        }

        return newHead.next;
    }

    public static void main(String[] args){
        S86 s = new S86();

        int[] num = {1,2,3};
        ListNode head = new ListNode(num[0]);
        ListNode p = head;
        for(int i = 1;i < num.length;i++){
            ListNode node = new ListNode(num[i]);
            p.next = node;
            p = node;
        }

        ListNode result = s.partition1(head,3);
        while(result != null){
            System.out.print(result.val);
            result = result.next;
        }
    }
}
