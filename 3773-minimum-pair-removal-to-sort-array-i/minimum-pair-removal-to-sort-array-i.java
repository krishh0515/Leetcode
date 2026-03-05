class Solution {

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int operations = 0;

        while (!isSorted(nums, n)) {

            int minSum = Integer.MAX_VALUE;
            int idx = 0;

            for (int i = 0; i < n - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }

            nums[idx] = nums[idx] + nums[idx + 1];

            for (int i = idx + 1; i < n - 1; i++) {
                nums[i] = nums[i + 1];
            }

            n--;
            operations++;
        }

        return operations;
    }

    private boolean isSorted(int[] nums, int n) {
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) return false;
        }
        return true;
    }
}
