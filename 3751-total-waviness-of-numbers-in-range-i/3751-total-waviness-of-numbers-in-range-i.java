class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;
        for(; num1 <= num2; num1++){
            int n = num1;
            int prev = n%10;
            n/=10;

            int curr = n%10;
            n/=10;

            while(n > 0){
                int next = n%10;
                n/=10;

                if((curr > prev && curr > next) || (curr < prev && curr < next)) count++;

                prev = curr;
                curr = next;
            }
        }
        return count;
    }
}