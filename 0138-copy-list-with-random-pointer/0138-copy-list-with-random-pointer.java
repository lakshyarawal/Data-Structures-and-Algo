/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

public class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<Node, Node>();
        return copyRandomList(head, map);
    }
    private Node copyRandomList(Node head, Map<Node, Node> map) {
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        newHead.next = copyRandomList(head.next, map);
        newHead.random = copyRandomList(head.random, map);
        
        return newHead;
        
    }
}