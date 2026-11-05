class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for(int num : arr1){
            int j = 0;
            while(j<arr2.length){
                if(Math.abs(num - arr2[j]) <= d) break;
                j++;
            }
            if(j == arr2.length) ans++;
        }
        return ans;
    }
}