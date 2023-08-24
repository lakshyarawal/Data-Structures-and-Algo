/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        if(head.next == null && n == 1) return null;
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        System.out.println("LEN: "+ len);
        if(n == len) return head.next;
        len -=n;
        len-=1;
        ListNode temp = head;
        while(len > 0){
            len--;
            temp = temp.next;
        }
        if(temp.next != null){
             temp.next = temp.next.next;
        }else{
            temp.next = null;
        }
       
        return head;
    }
}