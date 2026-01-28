import java.util.*;

class Solution {

    // Helper class to store pass and total
    static class ClassInfo {
        int pass, total;

        ClassInfo(int p, int t) {
            pass = p;
            total = t;
        }

        // Gain if we add one extra student
        double gain() {
            return (double)(pass + 1) / (total + 1) - (double)pass / total;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {

        // Max heap based on gain
        PriorityQueue<ClassInfo> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.gain(), a.gain())
        );

        // Initialize heap
        for (int[] c : classes) {
            pq.offer(new ClassInfo(c[0], c[1]));
        }

        // Assign extra students
        while (extraStudents-- > 0) {
            ClassInfo best = pq.poll();
            best.pass++;
            best.total++;
            pq.offer(best);
        }

        // Compute final average
        double sum = 0.0;
        while (!pq.isEmpty()) {
            ClassInfo c = pq.poll();
            sum += (double)c.pass / c.total;
        }

        return sum / classes.length;
    }
}
