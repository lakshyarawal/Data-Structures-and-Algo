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

    private ListNode divideAndConquer(ListNode[] lists, int lo, int hi) {
      if (lo > hi) { // invalid
        return null;
      }
      if (lo == hi) { // size = 1
        return lists[lo];
      }
      int mid = lo + (hi - lo) / 2; // left-leaning
      ListNode left = divideAndConquer(lists, lo, mid);
      ListNode right = divideAndConquer(lists, mid + 1, hi);
      return merge(left, right);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
        return null;
      }
      return divideAndConquer(lists, 0, lists.length - 1);
    }
    
    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
}




