class Solution {
	public void nearlySorted(int[] arr, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int idx = 0;
		for (int i = 0; i<arr.length; i++) {
			heap.offer(arr[i]);
			if (heap.size()>k+1) {
				arr[idx++] = heap.poll();
			}
		}

		while (!heap.isEmpty()) {
			arr[idx++] = heap.poll();
		}
	}
}