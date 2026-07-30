import heapq

class Solution:
    def getOrder(self, tasks):
        tasks = [(e, p, i) for i, (e, p) in enumerate(tasks)]
        tasks.sort()
        heap = []
        time = 0
        i = 0
        ans = []

        while i < len(tasks) or heap:
            if not heap and time < tasks[i][0]:
                time = tasks[i][0]

            while i < len(tasks) and tasks[i][0] <= time:
                heapq.heappush(heap, (tasks[i][1], tasks[i][2]))
                i += 1

            process, idx = heapq.heappop(heap)
            time += process
            ans.append(idx)

        return ans