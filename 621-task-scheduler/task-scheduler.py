from collections import Counter

class Solution:
    def leastInterval(self, tasks, n):

        freq = Counter(tasks)
        max_freq = max(freq.values())

        count_max = list(freq.values()).count(max_freq)

        intervals = (max_freq - 1) * (n + 1) + count_max

        return max(len(tasks), intervals)