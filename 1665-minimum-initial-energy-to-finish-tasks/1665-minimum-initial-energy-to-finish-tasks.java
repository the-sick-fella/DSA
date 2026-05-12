class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a,b) -> b[1] - b[0] - (a[1] - a[0]));

        int curr = tasks[0][1];
        int ans = curr;

        for(int task[] : tasks){
            int req = task[1];
            int used = task[0];

            if(req > curr){
                ans += (req - curr);
                curr += (req - curr);
            }

            curr -= used;
        }

        return ans;
    }
}