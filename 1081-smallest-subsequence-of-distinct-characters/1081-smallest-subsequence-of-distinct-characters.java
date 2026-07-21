class Solution {
    public String smallestSubsequence(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            map.putIfAbsent(s.charAt(i), i);
        }

        Stack<Character> stack = new Stack<>();
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freq[c - 'a'] > 0)
                continue;

            while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > i) {
                freq[stack.pop() - 'a']--;
            }
            stack.push(c);
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}