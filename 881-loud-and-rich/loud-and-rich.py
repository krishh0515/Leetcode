class Solution:
    def loudAndRich(self, richer: List[List[int]], quiet: List[int]) -> List[int]:
        n = len(quiet)

        # richer_than[x] = list of people who are richer than x
        richer_than = defaultdict(list)
        for a, b in richer:
            richer_than[b].append(a)   # a is richer than b

        answer = [-1] * n

        def dfs(x):
            if answer[x] != -1:
                return answer[x]        # already computed

            answer[x] = x              # start: x is the quietest candidate
            for richer_person in richer_than[x]:
                candidate = dfs(richer_person)
                if quiet[candidate] < quiet[answer[x]]:
                    answer[x] = candidate

            return answer[x]

        for person in range(n):
            dfs(person)

        return answer