class Solution {
	public boolean isKSortedArray(int[] arr, int k) {
		// code here
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int i = 0; i<arr.length; i++) {
			map.put(arr[i], i);
			heap.offer(arr[i]);
		}
		
		int idx = 0;
		while (!heap.isEmpty()) {
			int num = heap.poll();
			if (Math.abs(map.get(num) - idx++) > k)
				return false;
		}
		return true;
	}
}
