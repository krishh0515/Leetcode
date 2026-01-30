import java.util.*;

class Solution {
    public long minimumCost(
            String source, String target,
            String[] original, String[] changed, int[] cost) {

        int n = source.length();
        final long INF = (long) 1e18;

        // Collect all unique strings
        Set<String> set = new HashSet<>();
        for (String s : original) set.add(s);
        for (String s : changed) set.add(s);

        List<String> list = new ArrayList<>(set);
        int m = list.size();

        Map<String, Integer> id = new HashMap<>();
        for (int i = 0; i < m; i++) id.put(list.get(i), i);

        // Build graph
        long[][] dist = new long[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            dist[id.get(original[i])][id.get(changed[i])] =
                Math.min(dist[id.get(original[i])][id.get(changed[i])], cost[i]);
        }

        // Floyd–Warshall
        for (int k = 0; k < m; k++)
            for (int i = 0; i < m; i++)
                for (int j = 0; j < m; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        // DP
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {

            if (source.charAt(i) == target.charAt(i)) {
                dp[i] = dp[i + 1];
            }

            for (String from : list) {
                int len = from.length();
                if (i + len > n) continue;
                if (!source.startsWith(from, i)) continue;

                String to = target.substring(i, i + len);
                if (!id.containsKey(to)) continue;

                long d = dist[id.get(from)][id.get(to)];
                if (d < INF && dp[i + len] < INF) {
                    dp[i] = Math.min(dp[i], d + dp[i + len]);
                }
            }
        }

        return dp[0] >= INF ? -1 : dp[0];
    }
}
