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
    public ListNode reverseList(ListNode head) {
        ListNode temp=null;
        ListNode val=head;
        while(val != null){
            ListNode next=val.next;
            val.next=temp;
            temp=val;
            val=next;

        }
        return temp;
        

        
    }
}