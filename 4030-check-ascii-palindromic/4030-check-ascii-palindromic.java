class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (char ch : s.toCharArray()) {
            String bin = getBinary(ch);
            for (int i = 1; i <= 8 - bin.length(); i++) {
                sb.append(0);
            }
            for (char c : bin.toCharArray())
                sb.append(c);
        }

        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i))
                return false;
        }
        return true;
    }

    String getBinary(char asc) {
        StringBuilder ans = new StringBuilder();
        while (asc > 0) {
            int rem = asc % 2;
            ans.append(rem);
            asc /= 2;
        }
        return ans.reverse().toString();
    }
}