class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long X = (long) num1 - (long) k * num2;

            if (X <= 0) continue;

            int bits = Long.bitCount(X);

            if (bits <= k && k <= X) {
                return k;
            }
        }
        return -1;
    }
}
