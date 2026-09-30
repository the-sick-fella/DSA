class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int [] ans = new int[seq.length()];
        int [] depth = new int[2];
        for(int i = 0; i<seq.length(); i++){
            char c = seq.charAt(i);
            if(c == '('){
                if(depth[0] <= depth[1]){
                    depth[0]++;
                    ans[i] = 0;
                } else{
                    depth[1]++;
                    ans[i] = 1;
                }
            } else{
                if(depth[0] < depth[1]){
                    depth[1]--;
                    ans[i] = 1;
                } else{
                    depth[0]--;
                    ans[i] = 0;
                }
            }
        }
        return ans;
    }
}