class Solution {
    public int numberOfSpecialChars(String word) {
        int [] l = new int [26];
        int [] u = new int[26];
        for(char c : word.toCharArray()){
            if(c>='a' && c<='z') l[c - 'a']++;
            if(c>='A' && c<='Z') u[c - 'A']++;
        }
        int count = 0;
        for(int i = 0; i<26; i++) {
            if(l[i]>=1 && u[i]>=1) count++;
        }
        return count;
    }
}