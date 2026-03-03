class Solution:
    def mergeKLists(self, lists):
        if not lists:
            return None

        return self.divideAndConquer(lists, 0, len(lists) - 1)

    def divideAndConquer(self, lists, left, right):
        if left == right:
            return lists[left]

        mid = (left + right) // 2

        l1 = self.divideAndConquer(lists, left, mid)
        l2 = self.divideAndConquer(lists, mid + 1, right)

        return self.mergeTwoLists(l1, l2)

    def mergeTwoLists(self, l1, l2):
        dummy = ListNode(0)
        tail = dummy

        while l1 and l2:
            if l1.val < l2.val:
                tail.next = l1
                l1 = l1.next
            else:
                tail.next = l2
                l2 = l2.next

            tail = tail.next

        tail.next = l1 if l1 else l2

        return dummy.next