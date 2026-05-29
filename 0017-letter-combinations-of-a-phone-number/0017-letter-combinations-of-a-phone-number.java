class Solution {
    public List<String> letterCombinations(String digits) {
        char[][] mat = new char[8][4];
        char c = 'a';
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < 3; j++) mat[i][j] = c++;
            
            if (i == 5 || i == 7) mat[i][3] = c++;
        }

        List<String> list = new ArrayList<>();

        f(mat, digits, 0, list, new StringBuilder());
        return list;
    }

    void f(char[][] mat, String s, int idx, List<String> list, StringBuilder sb) {
        if (idx >= s.length()) {
            list.add(sb.toString());
            return;
        }

        char c = s.charAt(idx);
        int r = c - '2';

        sb.append(mat[r][0]);
        f(mat, s, idx + 1, list, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(mat[r][1]);
        f(mat, s, idx + 1, list, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(mat[r][2]);
        f(mat, s, idx + 1, list, sb);
        sb.deleteCharAt(sb.length() - 1);

        if (r == 5 || r == 7) {
            sb.append(mat[r][3]);
            f(mat, s, idx + 1, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}