/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        while(node != null){
            
            if(node.next == null){
                prev.next = null;
                break;
            }
            
            node.val = node.next.val;
            prev = node;
            node = node.next;
            
        }
    }
}