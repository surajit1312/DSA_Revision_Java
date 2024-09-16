class Solution {
    /**
     * Optimal Approach II
     * 
     * TC: O(2N + 26) ~ O(N)
     * SC: O(26) ~ O(1)
     * 
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26]; // SC: O(26) ~ O(1)
        for (int i = 0; i < s.length(); i++) { // TC: O(N)
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) { // TC: O(N)
            chars[t.charAt(i) - 'a']--;
        }
        boolean isAnagram = true;
        for (int i = 0; i < chars.length; i++) { // TC: O(26)
            if (chars[i] != 0) {
                isAnagram = false;
                break;
            }
        }
        return isAnagram;
    }

    /**
     * Optimal Approach I
     * 
     * TC: O(2N) ~ O(N)
     * SC: O(N)
     * 
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramOptimal(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>(); // SC: O(N)
        for (int i = 0; i < s.length(); i++) { // TC: O(N)
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) { // TC: O(N)
            char ch = t.charAt(i);
            if (!hm.containsKey(ch)) {
                return false;
            } else {
                int freq = hm.get(ch);
                if (freq > 1) {
                    hm.put(ch, freq - 1);
                } else {
                    hm.remove(ch);
                }
            }
        }
        return hm.isEmpty();
    }

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
    public boolean isAnagramBruteForce(String s, String t) {
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        Arrays.sort(sch);
        Arrays.sort(tch);
        return new String(sch).equals(new String(tch));
    }
}
