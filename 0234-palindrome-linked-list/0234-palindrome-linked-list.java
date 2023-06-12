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
    
    public ListNode reverseList(ListNode h){
        ListNode curr = h;
        ListNode prev = null;
        while(curr!= null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        
        if(head == null) return false;
        if(head.next == null) return true;
        
        while(pointer2.next != null && pointer2.next.next != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
        }
        
        ListNode temp = reverseList(pointer1.next);
        pointer1.next = null;
        
        while(head != null || temp != null){
            if(temp == null && head.next == null) return true;
            if(head == null && temp.next == null) return true;
            if(head == null ) return false;
            if(temp == null) return false;
            System.out.println("Temp: "+ temp.val + " Head: "+ head.val);
            if(temp.val != head.val){
                return false;
            }
            temp = temp.next;
            head = head.next;
        }
        
        return true;
    }
}