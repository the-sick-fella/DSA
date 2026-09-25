class Solution {
	public void buildHeap(int[] arr) {
		// code here
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for (int num : arr)
			q.offer(num);
		for (int i = 0; i<arr.length; i++) {
			arr[i] = q.poll();
		}
	}
}
