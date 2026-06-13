class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(String s : words){
            int weightMod = 0;

            for(char c : s.toCharArray()){
                weightMod+= weights[c - 'a'];
            }

            weightMod %= 26;

            sb.append((char)('z' - weightMod));
        }

        return sb.toString();
    }
}