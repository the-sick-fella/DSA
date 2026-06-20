class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;
        int diff [] = new int [n+1];

        for(int i = 0; i<n; i++){
            if(lights[i] > 0){
                int l = Math.max(0, i-lights[i]);
                int r = Math.min(n-1, i+lights[i]);

                diff[l]++;
                diff[r+1]--;
                l++;   
            }
        }

        int temp [] = new int [n];
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += diff[i];
            temp[i] = sum;
        }

        int ans = 0;
        for(int i = 0; i<n; i++){
            if(temp[i] == 0){
                ans++;
                i+=2;
            }
        }

        return ans;
    }
}