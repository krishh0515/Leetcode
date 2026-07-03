from collections import deque

class Solution:
    def openLock(self, deadends, target):

        dead = set(deadends)

        if "0000" in dead:
            return -1

        q = deque([("0000", 0)])
        visited = {"0000"}

        while q:

            state, steps = q.popleft()

            if state == target:
                return steps

            for i in range(4):

                digit = int(state[i])

                # Rotate forward
                up = (digit + 1) % 10
                next1 = state[:i] + str(up) + state[i + 1:]

                # Rotate backward
                down = (digit - 1) % 10
                next2 = state[:i] + str(down) + state[i + 1:]

                for nxt in (next1, next2):
                    if nxt not in dead and nxt not in visited:
                        visited.add(nxt)
                        q.append((nxt, steps + 1))

        return -1