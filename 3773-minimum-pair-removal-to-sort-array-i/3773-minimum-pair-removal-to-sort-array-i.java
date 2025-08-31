class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int ans = 0;
        
        while (!isSorted(nums, n)) {
            int minIdx = 0, minSum = Integer.MAX_VALUE;
            
            for (int i = 0; i < n - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    minIdx = i;
                }
            }
            
            nums[minIdx] += nums[minIdx + 1];
            for (int i = minIdx + 1; i < n - 1; i++) {
                nums[i] = nums[i + 1];
            }
            n--;
            ans++;
        }
        
        return ans;
    }

    private boolean isSorted(int[] nums, int length) {
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > nums[i + 1]) return false;
        }
        return true;
    }
}