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
        ListNode smallerHead = new ListNode(0), greaterHead = new ListNode(0);  
        ListNode smallerLast = smallerHead, greaterLast = greaterHead;    
        while (head != null){
            if (head.val < x) {
                smallerLast.next = head;
                smallerLast = smallerLast.next;
            }else {
                greaterLast.next = head;
                greaterLast = greaterLast.next;
            }
            head = head.next;
        }
        greaterLast.next = null;          
        smallerLast.next = greaterHead.next; //Skipping dummy head of greater and linking
        return smallerHead.next; //Skipping dummy head of smaller and returning next
        
    }
}