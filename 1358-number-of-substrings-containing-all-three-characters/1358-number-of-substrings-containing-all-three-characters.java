class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int si = 0;
        int n = s.length();
        int temp[] = new int[3];
        for(int ei = 0; ei <= n; ei++) {
            if (temp[0] > 0 && temp[1] > 0 && temp[2] > 0){
                count += n - ei + 1;
                temp[s.charAt(si) - 'a']--;
                si++;
                ei--;
            } else {
                if (ei >= n) return count;
                temp[s.charAt(ei) - 'a']++;
            }
        }
        return count;
    }
}