from collections import Counter
import heapq
class Solution:
    def topKFrequent(self, words,k):
        count=Counter(words)
        heap=[]
        for word ,freq in count.items():
            heapq.heappush(heap,(-freq,word))
        result=[]
        for _ in range(k):
            freq,word=heapq.heappop(heap)
            result.append(word)
        return result