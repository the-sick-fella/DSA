class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] nums, int freeStart, int freeEnd) {
        Arrays.sort(nums, (a,b) -> a[0] - b[0]);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        int first = nums[0][0];
        int sec = nums[0][1];
        list.add(List.of(first, sec));
        for(int i = 1; i<n; i++){
            List<Integer>temp = list.get(list.size()-1);
            first = temp.get(0);
            sec = temp.get(1);
            if(sec >= nums[i][0]-1){
                sec = Math.max(sec, nums[i][1]);
                list.remove(list.size()-1);
                list.add(List.of(first, sec));
            } else{
                list.add(List.of(nums[i][0], nums[i][1]));
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> curr : list){
            first = curr.get(0);
            sec = curr.get(1);
            if(first > freeEnd || sec < freeStart){
                ans.add(curr);
                continue;
            }
            
            if(first < freeStart){
                ans.add(List.of(first, freeStart-1));
            }

            if(sec > freeEnd){
                ans.add(List.of(freeEnd+1, sec));
            }
        }
        return ans;
    }
}