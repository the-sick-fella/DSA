class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for (char c : tasks)
            freq[c - 'A']++;

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (a, b) -> {
                    return Integer.compare(b, a);
                });

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                heap.offer(freq[i]);
        }

        Queue<int[]> q = new LinkedList<>();
        int curr = 1;
        while (!heap.isEmpty() || !q.isEmpty()) {
            if (!heap.isEmpty()) {
                int f = heap.poll() - 1;
                if (f > 0) {
                    q.offer(new int[] {f, curr + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == curr)
                heap.offer(q.poll()[0]);
            curr++;
        }
        return curr - 1;
    }
}