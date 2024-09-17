class Solution {
    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            int diff = target - nums[i];
            if (hm.containsKey(diff)) {
                return new int[] { hm.get(diff), i };
            } else {
                hm.put(nums[i], i);
            }
        }
        return new int[] { -1, -1 };
    }

    /**
     * Brute-Force Approach
     * 
     * TC: O(N^2)
     * SC: O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}
