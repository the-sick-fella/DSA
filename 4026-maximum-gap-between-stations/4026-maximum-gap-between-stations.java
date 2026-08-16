class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        int e[] = new int[n];
        int l[] = new int[n];
        for (int i = 0; i < n; i++) {
            char c = skill.charAt(i);
            int j = 0;
            if (i > 0)
                j = e[i - 1] + 1;
            while (j < station.length()) {
                char s = station.charAt(j);
                if (c == s) {
                    e[i] = j;
                    break;
                }
                j++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            char c = skill.charAt(i);
            int j = station.length() - 1;
            if (i < n - 1)
                j = l[i+1] - 1;
            while (j >= 0) {
                char s = station.charAt(j);
                if (c == s) {
                    l[i] = j;
                    break;
                }
                j--;
            }
        }

        // for (int i = 0; i < n; i++) {
        //     System.out.println(e[i] + " -> " + l[i]);
        // }

        int ans = 0;

        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, l[i] - e[i - 1]);
        }

        return ans;
    }
}