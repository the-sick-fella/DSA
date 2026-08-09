class Solution {
    public long weightedSum(int[] parent, int[] nums) {
     int n = parent.length;

        List<Integer>[] children = new ArrayList[n];

        for(int i = 0; i<n; i++){
            children[i] = new ArrayList<>();
        }
        for(int i = 1; i<n;i++){
            children[parent[i]].add(i);
        }
        int[] depth = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        depth[0] = 1;
        queue.offer(0);

        int height = 1;
        while(!queue.isEmpty()){
            int node =  queue.poll();
            for(int child : children[node]){
                depth[child] = depth[node]+1;
                height = Math.max(height, depth[child]);
                queue.offer(child);
            }
        }

        long ans = 0;
        for(int i = 0; i<n; i++){
            long weight = (long) nums[i] * (height - depth[i] + 1);
            ans += weight;
        }
        return ans;
    }
}