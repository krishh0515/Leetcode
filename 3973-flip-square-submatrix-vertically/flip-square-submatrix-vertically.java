class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int r, int c, int k) {

        int top = r;
        int bottom = r + k - 1;

        while (top < bottom) {

            for (int j = c; j < c + k; j++) {

                int temp = grid[top][j];
                grid[top][j] = grid[bottom][j];
                grid[bottom][j] = temp;
            }

            top++;
            bottom--;
        }

        return grid;
    }
}