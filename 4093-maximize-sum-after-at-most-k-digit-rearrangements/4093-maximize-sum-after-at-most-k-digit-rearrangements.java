class Pair {
    int val;
    int rev;
    int diff;

    public Pair(int val, int rev, int diff) {
        this.val = val;
        this.rev = rev;
        this.diff = diff;
    }
}

class Solution {
    public long maximizeSum(int[] nums, int k) {
        PriorityQueue<Pair> main = new PriorityQueue<>(
                (a, b) -> b.diff - a.diff);

        for (int i = nums.length - 1; i >= 0; i--) {
            int curr = nums[i];

            PriorityQueue<Integer> heap = new PriorityQueue<>(
                    Collections.reverseOrder());
            while (nums[i] > 0) {
                heap.offer(nums[i] % 10);
                nums[i] /= 10;
            }

            int num = 0;
            while (!heap.isEmpty())
                num = num * 10 + heap.poll();

            int diff = num - curr;
            main.offer(new Pair(curr, num, diff));  
        }

        // for(Pair p : main) System.out.println(p.val + " " + p.rev);

        long ans = 0;
        while (!main.isEmpty()) {
            Pair p = main.poll();
            if (k > 0 && p.diff > 0) {
                ans += p.rev;
                k--;
            } else
                ans += p.val;
        }

        return ans;
    }
}