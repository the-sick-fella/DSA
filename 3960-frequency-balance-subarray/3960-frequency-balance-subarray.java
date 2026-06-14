class Solution {
    public int getLength(int[] nums) {
        int ans = 0;

        for(int i = 0; i<nums.length; i++){
            Map<Integer, Integer> map = new HashMap<>();
            int maxF = 0;
            for(int j = i; j<nums.length; j++){
                int element = nums[j];
                int f = map.getOrDefault(element, 0)+1;
                maxF = Math.max(maxF, f);

                map.put(element, f);

                if(map.size() == 1){
                    ans = Math.max(ans, j-i+1);
                    continue;
                }

                if((maxF & 1) == 1) continue;
                
                boolean isOk = true;
                boolean hasHalf = false;

                for(int val : map.values()){
                    if(val == maxF/2) hasHalf = true;
                    else if(val != maxF){
                        isOk = false;
                        break;
                    }
                }

                if(isOk && hasHalf) ans = Math.max(ans, j-i+1);
            }
        }

        return ans;
    }
}