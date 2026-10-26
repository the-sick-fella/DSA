class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        int i = 0, j = 0, n = s.length(), ans = 0;
        while (j < n) {
            char c = s.charAt(j);

            if (lastSeen[c] != -1)
                i = Math.max(i, lastSeen[c] + 1);

            lastSeen[c] = j;
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}