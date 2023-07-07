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
    public ListNode recMerge(ListNode[] lists, int s, int e){
        if(s == e) return lists[s];
        if(s < e){
            int mid = (s+e)/2;
            System.out.println(mid);
            ListNode left = recMerge(lists, s, mid);
            ListNode right = recMerge(lists, mid+1, e);  
            return merge(left, right);
        }else{
            return null;
        } 
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        return recMerge(lists, 0, lists.length-1);
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




