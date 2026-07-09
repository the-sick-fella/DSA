class Solution {
    public long sumAndMultiply(int n) {
        String s = String.valueOf(n);
        long sum = 0;
        long x = 0;
        for (char c : s.toCharArray()) {
            if(c != '0') x = x * 10 + c - '0';
            sum += c - '0';              
        }
        return x * sum;
    }
}