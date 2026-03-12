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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode t1 = list1;
        ListNode t2 = list2;
        ListNode t3 = null;
        ListNode merge_head;

        if (list1.val < list2.val) {
            merge_head = list1;
            t3 = merge_head;
            t1 = t1.next;
        }
        else{
            merge_head = list2;
            t3 = merge_head;
            t2 = t2.next;
        }
        
        while(t1!=null && t2!=null){
            if(t1.val < t2.val) {
                t3.next = t1;
                t1 = t1.next;
            }
            else{
                t3.next = t2;
                t2 = t2.next;
            }
            t3 = t3.next;
        }
        
        t3.next = (t1==null) ? t2 : t1;

        return merge_head;
    }
}