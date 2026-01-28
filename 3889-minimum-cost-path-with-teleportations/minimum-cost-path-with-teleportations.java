import java.util.*;

class Solution {

    static class State {
        int r, c, t, cost;
        State(int r, int c, int t, int cost) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int INF = Integer.MAX_VALUE / 2;

        // dist[r][c][t]
        int[][][] dist = new int[m][n][k + 1];
        for (int[][] a : dist)
            for (int[] b : a)
                Arrays.fill(b, INF);

        // value -> list of cells
        TreeMap<Integer, List<int[]>> byValue = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                byValue.computeIfAbsent(grid[i][j], z -> new ArrayList<>())
                       .add(new int[]{i, j});
            }
        }

        // For each teleport count, track which values already expanded
        int[] lastExpandedValue = new int[k + 1];
        Arrays.fill(lastExpandedValue, -1);

        PriorityQueue<State> pq =
            new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        dist[0][0][0] = 0;
        pq.offer(new State(0, 0, 0, 0));

        int[] dr = {0, 1};
        int[] dc = {1, 0};

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.cost != dist[cur.r][cur.c][cur.t]) continue;

            if (cur.r == m - 1 && cur.c == n - 1)
                return cur.cost;

            // Normal moves
            for (int d = 0; d < 2; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr < m && nc < n) {
                    int ncst = cur.cost + grid[nr][nc];
                    if (ncst < dist[nr][nc][cur.t]) {
                        dist[nr][nc][cur.t] = ncst;
                        pq.offer(new State(nr, nc, cur.t, ncst));
                    }
                }
            }

            // Teleport
            if (cur.t < k) {
                int limit = grid[cur.r][cur.c];
                if (limit > lastExpandedValue[cur.t]) {
                    for (var entry : byValue.subMap(
                            lastExpandedValue[cur.t] + 1, true,
                            limit, true).entrySet()) {

                        for (int[] cell : entry.getValue()) {
                            int i = cell[0], j = cell[1];
                            if (cur.cost < dist[i][j][cur.t + 1]) {
                                dist[i][j][cur.t + 1] = cur.cost;
                                pq.offer(new State(i, j, cur.t + 1, cur.cost));
                            }
                        }
                    }
                    lastExpandedValue[cur.t] = limit;
                }
            }
        }
        return -1;
    }
}
