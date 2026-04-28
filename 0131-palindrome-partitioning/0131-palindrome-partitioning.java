class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        p(0, list, s, new ArrayList<>());

        return list;
    }

    void p(int idx, List<List<String>> list, String s, List<String> temp) {
        if (idx >= s.length()) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; idx + i < s.length(); i++) {
            if (!valid(s, idx, idx + i))
                continue;

            temp.add(s.substring(idx, idx + i + 1));
            p(idx + i + 1, list, s, temp);
            temp.remove(temp.size() - 1);
        }
    }

    boolean valid(String s, int si, int ei) {
        while (si < ei) {
            if (s.charAt(si) != s.charAt(ei))
                return false;
            si++;
            ei--;
        }

        return true;
    }
}