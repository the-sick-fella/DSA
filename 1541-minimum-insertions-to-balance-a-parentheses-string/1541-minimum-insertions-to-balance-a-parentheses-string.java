class Solution {
    public int minInsertions(String s) {
        int count = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                count++;
            else {
                if (count == 0) {
                    ans++;
                    i++;
                    if(i == s.length()) return 1 + ans;
                    if (s.charAt(i) == '(') {
                        ans++;
                        i--;
                    }
                } else {
                    i++;
                    if(i == s.length()) return count * 2 + ans - 1;
                    if (s.charAt(i) == '(') {
                        ans++;
                        i--;
                    }
                    count--;
                }
            }
        }
        return count * 2 + ans;
    }
}