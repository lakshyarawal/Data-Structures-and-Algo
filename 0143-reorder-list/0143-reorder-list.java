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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        Stack<ListNode> st = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow != null){
            st.push(slow);
            slow = slow.next;
        }
        ListNode curr = head;
        while(!st.isEmpty()){
            ListNode temp = curr.next;
            curr.next = st.pop();
            curr.next.next = temp;
            curr = curr.next.next;
        }
        curr.next = null;
    }
}