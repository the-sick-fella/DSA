class Solution {
    public int maximumLengthSubstring(String s) {
        int ans = 0, i = 0, j = 0;
        int [] f = new int[26];
        while(j < s.length()){
            char c = s.charAt(j);
            f[c - 'a']++;

            while(f[c- 'a'] > 2){
                f[s.charAt(i) - 'a']--;
                i++;
            }

            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}