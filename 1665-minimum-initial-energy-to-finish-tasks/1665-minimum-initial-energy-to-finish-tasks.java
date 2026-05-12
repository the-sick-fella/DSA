class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a,b) -> b[1] - b[0] - (a[1] - a[0]));

        for(int row[] : tasks){
            for(int col : row)
            System.out.print(col + " ");
            System.out.println();
        }

        int curr = tasks[0][1];
        int ans = curr;

        for(int i = 0; i<tasks.length; i++){
            int req = tasks[i][1];
            int used = tasks[i][0];

            if(req > curr){
                ans += (req - curr);
                curr += (req - curr);
            }

            curr -= used;
        }

        return ans;
    }
}