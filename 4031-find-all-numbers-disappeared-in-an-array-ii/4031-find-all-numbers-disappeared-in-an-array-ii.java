class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> list = new ArrayList<>();
        int [] freq = new int[upper + 1];
        for(int num : nums) {
            if(num < lower || num > upper) continue;
            freq[num]++;
        }
        
        while(lower <= upper){
            List<Integer> temp = new ArrayList<>();
            if(freq[lower] != 0){
                lower++;
                continue;
            }

            temp.add(lower);
            while(lower <= upper && freq[lower] == 0) lower++;
            temp.add(lower-1);
            list.add(temp);
            lower++;
        }
        return list;
    }
}