class Solution {
    public ListNode insertionSortList(ListNode head) {
        // Dummy node for the sorted list
        ListNode dummy = new ListNode(0);
        
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next; // store next node
            
            // Find where to insert current node in sorted list
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }
            
            // Insert current between prev and prev.next
            current.next = prev.next;
            prev.next = current;
            
            // Move to next node
            current = next;
        }
        
        return dummy.next;
    }
}
