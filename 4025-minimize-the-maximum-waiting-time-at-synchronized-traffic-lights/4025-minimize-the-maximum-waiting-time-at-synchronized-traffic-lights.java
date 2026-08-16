class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int cap = 0;
        for(int light : lights) cap = Math.max(cap, light);

        int wait = 0;
        for(int t : arrivalTime){
            int r = t % period;
            if(r < cap) continue;
            wait = Math.max(wait, period-r);
        }
        return wait;
    }
}