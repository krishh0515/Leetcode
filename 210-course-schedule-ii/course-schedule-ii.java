import java.util.*;

class Solution {

    List<List<Integer>> graph;
    int[] state;      // 0 = unvisited, 1 = visiting, 2 = visited
    int[] order;
    int index;
    boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        state = new int[numCourses];
        order = new int[numCourses];
        index = numCourses - 1;

        // DFS on each course
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                dfs(i);
                if (hasCycle) {
                    return new int[0];
                }
            }
        }

        return order;
    }

    private void dfs(int node) {
        if (hasCycle) return;

        state[node] = 1; // visiting

        for (int next : graph.get(node)) {
            if (state[next] == 0) {
                dfs(next);
            } else if (state[next] == 1) {
                hasCycle = true; // cycle detected
                return;
            }
        }

        state[node] = 2;          // visited
        order[index--] = node;    // topo order
    }
}
