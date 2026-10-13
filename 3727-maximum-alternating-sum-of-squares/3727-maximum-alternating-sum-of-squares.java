class Solution {
    public long maxAlternatingSum(int[] nums) {
        int size = (nums.length+1)/2;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        long sum = 0;
        for (int num : nums){
            heap.offer(Math.abs(num));
            if(heap.size() > size){
                int val = heap.poll();
                sum -= val*val;
            }
        }
        for(int num: heap) sum+= num*num;
        return sum;
    }
}