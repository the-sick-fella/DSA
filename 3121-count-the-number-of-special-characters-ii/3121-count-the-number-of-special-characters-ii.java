class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z')
                map.put(c, i);
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                char lc = (char) (c - 'A' + 'a');
                if(!set.contains(c) && map.containsKey(lc) && map.get(lc) < i){
                    count++;
                }
                set.add(c);
            }
        }

        return count;
    }
}