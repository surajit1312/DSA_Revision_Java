class Solution {
    /**
     * TC: O(N)
     * SC: O(N)
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        // count of 0 is set to 1 so that if nums[0] == k then we can set count = 1
        hm.put(0, 1); // <sum, count>
        int sum = 0;
        for (int i = 0; i < nums.length; i++) { // TC: O(N)
            sum += nums[i];
            int diff = sum - k;
            if (hm.containsKey(diff)) {
                count += hm.get(diff);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
