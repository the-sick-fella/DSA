class Solution {
    public int maximumLengthSubstring(String s) {
        int ans = 0, i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(j < s.length()){
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while(map.get(c) > 2){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }

            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}