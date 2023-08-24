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
    int determineLength(ListNode head){
        int counter = 1; 
        while (head.next != null){
            counter++;
            head = head.next;
        }
        return counter;
    }
   
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = determineLength(head);
        if(len -n == 0) return head.next;
        var walker = head;
        for (int i = 0; i < (len - n-1); i++){
            walker = walker.next;
        } 
        if (n == len || walker.next == null){walker.next = null;}
        else {walker.next = walker.next.next;}

        return head;
    
    }
}