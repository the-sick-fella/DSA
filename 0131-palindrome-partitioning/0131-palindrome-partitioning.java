class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        p(0, list, s, new ArrayList<>());
        return list;
    }

    void p(int idx, List<List<String>> list, String s, List<String> curr) {
        if (idx >= s.length()) {
            list.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (valid(s, idx, i)) {
                curr.add(s.substring(idx, i + 1));
                p(i + 1, list, s, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    boolean valid(String s, int si, int ei) {
        while (si < ei) {
            if (s.charAt(si) != s.charAt(ei)) return false;
            si++;
            ei--;
        }

        return true;
    }
}