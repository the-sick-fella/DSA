class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int si = 0;
        int ei = 0;
        int n = s.length();
        int temp[] = new int[3];

        temp[s.charAt(ei) - 'a']++;
        while (ei < n) {
            if (temp[0] > 0 && (temp[1] > 0 && temp[2] > 0)) {
                count += (n - 1) - ei + 1;
                temp[s.charAt(si) - 'a']--;
                si++;
            } else {
                ei++;
                if (ei >= n)
                    return count;
                temp[s.charAt(ei) - 'a']++;
            }
        }
        return count;
    }
}