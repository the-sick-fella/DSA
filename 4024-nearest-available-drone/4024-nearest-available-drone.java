class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int ans = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<drones.length; i++){
            int r[] = drones[i];
            int d = Math.abs(target[0] - r[0]) + Math.abs(target[1] - r[1]);
            if(d <= r[2] && d < min){
                min = d;
                ans = i;
            }
        }
        return ans;
    }
}