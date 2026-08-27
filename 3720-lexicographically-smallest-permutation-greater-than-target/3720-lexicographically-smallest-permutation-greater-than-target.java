class Solution {
    public String lexGreaterPermutation(String s, String t) {
        int[] f = new int[26];
        for (char c : s.toCharArray())
            f[c - 'a']++;

        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int ti = t.charAt(i) - 'a';
            if (f[ti] > 0) {
                f[ti]--;

                if (greaterPossible(t, i + 1, f)) {
                    // System.out.println("Greater possible for " + i);
                    sb.append(t.charAt(i));
                    continue;
                }

                // System.out.println("Greater not possible for " + i);

                f[ti]++;
            }
            int gi = ti + 1;
            for (; gi < 26; gi++) {
                if (f[gi] > 0)
                    break;
            }

            if (gi == 26)
                return "";

            sb.append((char) ('a' + gi));
            f[gi]--;

            appendRemaining(sb, f);
            return sb.toString();

        }
        return "";
    }

    boolean greaterPossible(String t, int i, int[] f) {
        StringBuilder sb = new StringBuilder();
        for (int j = 25; j >= 0; j--) {
            while (f[j] > 0) {
                sb.append((char) ('a' + j));
                f[j]--;
            }
        }

        for (char c : sb.toString().toCharArray()) {
            f[c - 'a']++;
        }

        return sb.toString().compareTo(t.substring(i)) > 0;
    }

    void appendRemaining(StringBuilder sb, int[] f) {
        for (int i = 0; i < 26; i++) {
            while (f[i] > 0) {
                sb.append((char) ('a' + i));
                f[i]--;
            }
        }
    }
}