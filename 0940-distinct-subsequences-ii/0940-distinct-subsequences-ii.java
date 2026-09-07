class Solution {
    public int distinctSubseqII(String s) {
        int total = 0, curr = 0;
        int f[] = new int[26];
        char last = '.';
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            curr = total + 1 - f[c - 'a'];
            if (curr < 0) curr += mod;
            total = (total + curr) % mod;
            f[c - 'a'] = (f[c - 'a'] + curr) % mod;
        }
        return total;
    }
}