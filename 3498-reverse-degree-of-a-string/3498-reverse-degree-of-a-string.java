class Solution {
    public int reverseDegree(String s) {
        int sum = 0, i = 1;
        for(char c : s.toCharArray()){
            sum += (26 - (c - 'a')) * i++;
        }
        return sum;
    }
}