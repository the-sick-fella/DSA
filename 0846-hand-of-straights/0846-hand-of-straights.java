class Solution {
    public boolean isNStraightHand(int[] hand, int k) {
        if (k == 1)
            return true;

        if (hand.length % k != 0)
            return false;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int val : hand)
            heap.offer(val);

        while (!heap.isEmpty()) {
            if (!findNextK(heap, heap.poll(), k - 1))
                return false;
        }
        return true;
    }

    boolean findNextK(PriorityQueue<Integer> heap, int val, int count) {
        Queue<Integer> q = new LinkedList<>();
        while (count > 0) {
            while (!heap.isEmpty() && heap.peek() == val)
                q.offer(heap.poll());
            if (!heap.isEmpty() && heap.poll() == val + 1) {
                val++;
                count--;
            } else 
                return false;
        }

        while (!q.isEmpty())
            heap.offer(q.poll());
        return true;
    }
}