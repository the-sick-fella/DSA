class Solution {
    public long maxAlternatingSum(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums)
            heap.offer(Math.abs(num));
        long sum = 0;
        for (int i = 0; i <= (nums.length-1) / 2; i++) {
            int num = heap.poll();
            sum += num * num;
        }

        while (!heap.isEmpty()) {
            int num = heap.poll();
            sum -= num * num;
        }
        return sum;
    }
}