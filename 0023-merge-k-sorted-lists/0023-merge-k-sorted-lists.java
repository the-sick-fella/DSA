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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        for(ListNode node : lists){
            if(node != null) heap.offer(node);
        }

        // for(ListNode node: heap) System.out.println(node.val);

        while(!heap.isEmpty()){
            ListNode curr = heap.poll();
            temp.next = curr;
            temp = curr;
            if(curr.next != null) heap.offer(curr.next);
        }

        return ans.next;
    }
}