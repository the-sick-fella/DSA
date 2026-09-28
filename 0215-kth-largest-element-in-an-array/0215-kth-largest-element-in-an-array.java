class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> heap = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            heapifyUp(heap);
            if (heap.size() > k) {
                heap.set(0, heap.get(heap.size() - 1));
                heap.remove(heap.size() - 1);
                heapifyDown(heap);
            }
        }
        return heap.get(0);
    }

    void heapifyUp(List<Integer> heap) {
        int idx = heap.size() - 1;
        while (idx > 0) {
            int pi = (idx - 1) / 2;
            if (heap.get(pi) <= heap.get(idx))
                return;
            swap(heap, idx, pi);
            idx = pi;
        }
    }

    void heapifyDown(List<Integer> heap) {
        int idx = 0, n = heap.size();

        while (true) {
            int smallest = idx;
            int li = 2 * idx + 1, ri = 2 * idx + 2;
            if (ri < n && heap.get(smallest) > heap.get(ri))
                smallest = ri;
            if (li < n && heap.get(smallest) > heap.get(li))
                smallest = li;

            if (idx == smallest)
                return;
            swap(heap, idx, smallest);
            idx = smallest;
        }
    }

    void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}