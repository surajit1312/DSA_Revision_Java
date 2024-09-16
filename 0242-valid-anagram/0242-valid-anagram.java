class Solution {
    /**
     * Brute-Force Approach
     * 
     * TC: O(2N) + O(2Nlog(2N)) ~ O(Nlog(N))
     * SC: O(2N) ~ O(N)
     * 
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        Arrays.sort(sch);
        Arrays.sort(tch);
        return new String(sch).equals(new String(tch));
    }
}
