class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            map.putIfAbsent(c, i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sb.indexOf(String.valueOf(c)) != -1)
                continue;
            while (sb.length() > 0 && c < sb.charAt(sb.length() - 1) && map.get(sb.charAt(sb.length() - 1)) > i) {
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(c);
        }
        return sb.toString();
    }
}