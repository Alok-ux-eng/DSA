class Solution {
    public ListNode removeElements(ListNode head, int val) {

        // Remove matching nodes from the beginning
        while (head != null && head.val == val) {
            head = head.next;
        }

        // temp starts from head
        ListNode temp = head;

        while (temp != null && temp.next != null) {

            if (temp.next.val == val) {
                // Delete temp.next
                temp.next = temp.next.next;
            } 
            else {
                // Move temp forward
                temp = temp.next;
            }
        }

        return head;
    }
}