class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        if(k == 1 && s.contains("1")) return "1";
        int si = 0;
        for(; si < s.length(); si++){
            if(s.charAt(si) == '1') break;
        }
        
        int ei = 0, count = 0;
        String ans = "";
        while(ei < s.length()){
            if(s.charAt(ei) == '1') count++;
            if(count == k){
                ans = findSmallerString(ans, s.substring(si, ei+1));
                si++;
                count--;

                while(si < ei && s.charAt(si) != '1') si++;
            }
            ei++;
        }
        return ans;
    }

    String findSmallerString(String s1, String s2){
        if(s1.length() == 0 || s2.length() < s1.length()) return s2;
        if(s2.length() > s1.length()) return s1;
        int comp = s1.compareTo(s2);
        return comp > 0 ? s2 : s1;
    }
}