class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9)
            return "";
        StringBuilder ans = new StringBuilder();
        int rem = sum % 9;
        int div = sum / 9;
        while (div > 0) {
            ans.append('9');
            div--;
        }
        if (rem != 0) 
            ans.append(rem);
        
        while (num - ans.length() > 0) 
            ans.append(0);
        
        return ans.toString();
    }
}