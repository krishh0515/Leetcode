# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1, l2):

        stack1 = []
        stack2 = []

        # push digits of l1
        while l1:
            stack1.append(l1.val)
            l1 = l1.next

        # push digits of l2
        while l2:
            stack2.append(l2.val)
            l2 = l2.next

        carry = 0
        head = None

        while stack1 or stack2 or carry:

            val = carry

            if stack1:
                val += stack1.pop()

            if stack2:
                val += stack2.pop()

            carry = val // 10
            node = ListNode(val % 10)

            node.next = head
            head = node

        return head