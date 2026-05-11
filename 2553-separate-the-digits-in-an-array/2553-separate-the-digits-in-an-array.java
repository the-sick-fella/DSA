class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = nums.length - 1; i>=0; i--){
            int n = nums[i];
            while(n > 0){
                int rem = n%10;
                list.add(0, rem);
                n/=10;
            }
        }

        int ans[] = new int [list.size()];
        for(int i = 0; i<list.size(); i++) ans[i] = list.get(i);
        return ans;
    }
}