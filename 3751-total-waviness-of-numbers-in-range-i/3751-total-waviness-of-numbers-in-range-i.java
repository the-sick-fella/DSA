class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;
        for(; num1 <= num2; num1++){
            if(num1 < 100) continue;

            String s = String.valueOf(num1);
            for(int i = 1; i<s.length()-1; i++){
                if((s.charAt(i) > s.charAt(i-1) && s.charAt(i) > s.charAt(i+1)) || (s.charAt(i) < s.charAt(i-1) && s.charAt(i) < s.charAt(i+1))) count++;
            }
        }
        return count;
    }
}