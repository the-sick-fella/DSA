class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] nums, int freeStart, int freeEnd) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums, (a,b) -> a[0] - b[0]);
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0][0]);
        temp.add(nums[0][1]);
        list.add(temp);
        for(int i = 1; i<n; i++){
            temp = list.get(list.size()-1);
                int first = temp.get(0);
                int sec = temp.get(1);
                temp = new ArrayList<>();
            if(sec >= nums[i][0]-1){
                sec = Math.max(sec, nums[i][1]);
                temp.add(first);
                temp.add(sec);
                list.remove(list.size()-1);
            } else{
                temp.add(nums[i][0]);
                temp.add(nums[i][1]);
            }
            list.add(List.copyOf(temp));
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> curr : list){
            int first = curr.get(0);
            int sec = curr.get(1);
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