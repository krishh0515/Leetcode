class Solution(object):
    def solveSudoku(self, board):

        rows = [0] * 9
        cols = [0] * 9
        boxes = [0] * 9
        empty = []

        # Initialize bitmasks
        for r in range(9):
            for c in range(9):
                if board[r][c] == ".":
                    empty.append((r, c))
                else:
                    num = int(board[r][c])
                    mask = 1 << num
                    rows[r] |= mask
                    cols[c] |= mask
                    boxes[(r // 3) * 3 + (c // 3)] |= mask

        def backtrack(index):

            if index == len(empty):
                return True

            r, c = empty[index]
            box_id = (r // 3) * 3 + (c // 3)

            for num in range(1, 10):
                mask = 1 << num

                if (rows[r] & mask) == 0 and \
                   (cols[c] & mask) == 0 and \
                   (boxes[box_id] & mask) == 0:

                    board[r][c] = str(num)
                    rows[r] |= mask
                    cols[c] |= mask
                    boxes[box_id] |= mask

                    if backtrack(index + 1):
                        return True

                    # undo
                    board[r][c] = "."
                    rows[r] ^= mask
                    cols[c] ^= mask
                    boxes[box_id] ^= mask

            return False

        backtrack(0)