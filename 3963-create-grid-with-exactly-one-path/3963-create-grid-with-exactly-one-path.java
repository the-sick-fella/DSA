class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        for (int i = 0; i < m - 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    sb.append('.');
                else
                    sb.append('#');
            }
            ans[i] = sb.toString();
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sb.append('.');
        }
        ans[m - 1] = sb.toString();

        return ans;
    }
}