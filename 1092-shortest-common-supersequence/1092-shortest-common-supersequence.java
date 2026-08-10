class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        List<Integer> rl = new ArrayList<>();
        List<Integer> cl = new ArrayList<>();
        int r = 0, c = 0;
        while (r < m && c < n) {
            if (s1.charAt(r) == s2.charAt(c)) {
                rl.add(r);
                cl.add(c);
                r++;
                c++;
            } else if (dp[r + 1][c] > dp[r][c + 1])
                r++;
            else
                c++;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, idx1 = 0, idx2 = 0;
        if (!rl.isEmpty() && !cl.isEmpty()) {
            while (i < m && j < n) {
                if (idx1 >= rl.size()) break;
                r = rl.get(idx1++);
                c = cl.get(idx2++);
                while (i < r)
                    sb.append(s1.charAt(i++));
                while (j < c)
                    sb.append(s2.charAt(j++));
                sb.append(s1.charAt(i++));
                j++;
            }
        }

        while (i < m)
            sb.append(s1.charAt(i++));
        while (j < n)
            sb.append(s2.charAt(j++));
        return sb.toString();
    }
}