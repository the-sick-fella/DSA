class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        if(k == 1 && s.contains("1")) return "1";
        int si = 0;
        for(; si < s.length(); si++){
            if(s.charAt(si) == '1') break;
        }
        
        int ei = si, count = 0;
        String ans = "";
        while(ei < s.length()){
            if(s.charAt(ei) == '1') count++;
            if(count == k){
                if(foundSmaller(ans, s, si, ei)) ans = s.substring(si, ei+1);
                si++;
                count--;

                while(si < ei && s.charAt(si) != '1') si++;
            }
            ei++;
        }
        return ans;
    }

    boolean foundSmaller(String s1, String s, int si, int ei){
        if(s1.length() == 0 || ei-si+1 < s1.length()) return true;
        if(ei-si+1 > s1.length()) return false;
        int comp = s1.compareTo(s.substring(si, ei+1));
        return comp > 0 ? true : false;
    }
}