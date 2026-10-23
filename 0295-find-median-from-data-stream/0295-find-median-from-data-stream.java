class MedianFinder {
    PriorityQueue<Integer> minHeap, maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (!maxHeap.isEmpty() && num < maxHeap.peek())
            maxHeap.offer(num);
        else
            minHeap.offer(num);
        if (minHeap.size() == maxHeap.size() + 2)
            maxHeap.offer(minHeap.poll());
        if (maxHeap.size() == minHeap.size() + 2)
            minHeap.offer(maxHeap.poll());
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size())
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        if (minHeap.size() > maxHeap.size())
            return minHeap.peek();
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */