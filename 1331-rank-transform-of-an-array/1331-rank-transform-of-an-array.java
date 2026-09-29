class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : arr)
            pq.offer(x);

        Map<Integer, Integer> map = new HashMap<>();
        int r = 1;
        while (!pq.isEmpty()) {
            int x = pq.poll();
            if (!map.containsKey(x))
                map.put(x, r++);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}