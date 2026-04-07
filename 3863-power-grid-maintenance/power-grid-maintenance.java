import java.util.*;

class Solution {

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                parent[pb] = pa;
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        DSU dsu = new DSU(c);

        // Step 1: Build components
        for (int[] e : connections) {
            dsu.union(e[0], e[1]);
        }

        // Step 2: Map component → TreeSet
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();

        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            map.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        List<Integer> answer = new ArrayList<>();

        // Step 3: Process queries
        for (int[] q : queries) {

            int type = q[0];
            int x = q[1];
            int root = dsu.find(x);

            if (type == 1) {

                TreeSet<Integer> set = map.get(root);

                if (set.contains(x)) {
                    answer.add(x);
                } else if (!set.isEmpty()) {
                    answer.add(set.first());
                } else {
                    answer.add(-1);
                }

            } else { // type 2 → offline
                map.get(root).remove(x);
            }
        }

        // convert to array
        int[] res = new int[answer.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = answer.get(i);
        }

        return res;
    }
}