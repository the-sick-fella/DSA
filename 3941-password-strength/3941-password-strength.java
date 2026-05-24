class Solution {
    public int passwordStrength(String p) {
        Set<Character> set = new HashSet<>();
        Set<Character> charSet = new HashSet<>();
        charSet.add('!');
        charSet.add('@');
        charSet.add('#');
        charSet.add('$');
        
        int ans = 0;
        for(char c : p.toCharArray()){
            if(set.contains(c)) continue;

            if(charSet.contains(c)) ans += 5;
            else if(c - 'a' >= 0 && c - 'a' <= 25){
                ans += 1;
            }
            else if(c >= 'A' && c <= 'Z'){
                ans += 2;
            }
            else if(c >= '0' && c <= '9') ans += 3;

            set.add(c);

        }

        return ans;
    }
}