class Solution {
    public int longestSubarray(int[] nums, int k) {
        Map<Integer, Set<Integer>> fm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = getFactorSet(nums[i]);
            fm.put(i, set);
        }

        int i = 0, j = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (j < nums.length) {
            Set<Integer> set = fm.get(j);
            for (int f : set) {
                map.put(f, map.getOrDefault(f, 0) + 1);
            }
            while (map.size() > k) {
                Set<Integer> temp = fm.get(i);
                for (int f : temp) {
                    map.put(f, map.get(f) - 1);
                    if(map.get(f) == 0) map.remove(f);
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }

    Set<Integer> getFactorSet(int n) {
        int val = n;
        Set<Integer> set = new HashSet<>();
        for(int i = 2; i*i<=n; i++){
            // if(n<i) break;
            if(n%i == 0){
                set.add(i);
                
                while(n%i == 0) n/=i;
            }
        }

        if(n>1) set.add(n);
        return set;
    }
}