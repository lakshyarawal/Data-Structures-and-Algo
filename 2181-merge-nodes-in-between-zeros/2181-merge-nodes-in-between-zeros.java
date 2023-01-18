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
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head.next;
        ListNode temp = head;
        int curr_sum = 0;
        
        while(curr != null){
            if(curr.val == 0){
                temp.val = curr_sum;
                curr_sum = 0;
                curr = curr.next;
                if(curr == null){
                    temp.next = null;
                    break;
                }
                temp = temp.next;
                
            }
            curr_sum += curr.val;
            curr = curr.next;
        }
        temp.next = null;
        
        return head;
    }
}