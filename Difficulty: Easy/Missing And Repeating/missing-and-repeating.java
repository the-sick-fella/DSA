class Solution {
    ArrayList<Integer> findTwoElement(int nums[]) {
        // code here
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        long sum = 0;
        long sqSum = 0;
        for(int num : nums){
            sum += num;
            sqSum += (long)num*num;
        }
        
        long exSum = (long)n*(n+1)/2;
        long exSqSum = (long)n*(n+1)*(2*n + 1) / 6;
        
        long nume = (sum - exSum) + ((sqSum - exSqSum)/(sum - exSum));
        
        int repeatingNo = (int)(nume / 2);
        
        int missingNo = (int)(exSum+ repeatingNo - sum);
        
        list.add(repeatingNo);
        list.add(missingNo);
        
        return list;
    }
}
