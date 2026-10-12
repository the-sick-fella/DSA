class Solution {
    public boolean threeFibonacciSum(int n) {
        int one = 0, two = 1, three = 1;
        while(one + two + three < n){
            int temp = two + three;
            one = two;
            two = three;
            three = temp;
        }
        return (one + two + three) == n;
    }
}