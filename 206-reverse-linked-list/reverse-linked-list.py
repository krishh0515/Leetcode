class ListNode:
    def __init__(self, val=0):
        self.val = val
        self.next = None


class Solution:
    def reverseList(self, head):
        prev = None
        curr = head

        while curr:
            next_node = curr.next   # store next
            curr.next = prev        # reverse link
            prev = curr             # move prev
            curr = next_node        # move curr

        return prev