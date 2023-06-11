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
    public ListNode addNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return head.next;
    }
    
    public ListNode reverseList(ListNode l1){
        ListNode curr = l1;
        ListNode prev = null;
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        
        return prev;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverseList(l1);
        ListNode r2 = reverseList(l2);
        
        int totalSum = 0, carry = 0;
        ListNode ans = new ListNode();
        while (r1 != null || r2 != null) {
            if (r1 != null) totalSum += r1.val;
            if (r2 != null) totalSum += r2.val;
            
            ans.val = totalSum % 10;
            carry = totalSum / 10;
            ListNode head = new ListNode(carry);
            head.next = ans;
            ans = head;
            totalSum = carry;

            r1 = r1 != null ? r1.next : null;
            r2 = r2 != null ? r2.next : null;
        }

        return carry == 0 ? ans.next: ans;
        // ListNode finalNode = addNumbers(headFirst, headSecond);
        // return reverseList(finalNode);
    }
}