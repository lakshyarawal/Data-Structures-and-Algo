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
    public ListNode partition(ListNode head, int x) {
        
        ListNode temp1 = new ListNode(0);
        ListNode temp2 = new ListNode(0);
        ListNode l1 = temp1;
        ListNode l2 = temp2;
        
        while(head != null){
            if(head.val < x){
                l1.next = head;
                l1 = l1.next;
            }
            else{
                l2.next = head;
                l2 = l2.next;
            }
            head = head.next;
        }
            
        l2.next = null;
        if(temp1.next != null){
            l1.next = temp2.next;
        }
        return temp1.next == null ? temp2.next: temp1.next;
        
    }
}