class Solution {
    public int totalNumbers(int[] digits) {
        int freq [] = new int[10];
        for(int digit : digits) freq[digit]++;
        int ans = 0;

        for(int f = 1; f<10; f++){
            if(freq[f] == 0) continue;
            freq[f]--;

            for(int s = 0; s<10; s++){
                if(freq[s] == 0) continue;
                freq[s]--;

                for(int t = 0; t<9; t+=2){
                    if(freq[t] != 0) ans++;
                }

                freq[s]++;
            }
            freq[f]++;
        }
        return ans;
    }
}