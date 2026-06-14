class Solution {
    public long maxRatings(int[][] units) {
        long ans = 0;
        if(units[0].length == 1){
            for(int r[]:units) ans+=r[0];
            return ans;
        }
        long minSec = Integer.MAX_VALUE;
        long minFirst = Integer.MAX_VALUE;

        for(int r[] : units){
            Arrays.sort(r);
            ans += r[1];
            minFirst = Math.min(minFirst, r[0]);
            minSec = Math.min(minSec, r[1]);
        }

        return ans + minFirst - minSec;
    }
}