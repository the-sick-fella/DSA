class Solution {
	public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
		// code here
		TreeMap<Double, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
		for (int i = 0; i<wt.length; i++) {
			double ratio = (double)val[i] / wt[i];
			map.putIfAbsent(ratio, new ArrayList<>());
			map.get(ratio).add(i);
		}
		
		double ans = 0.0;
		for (double ratio : map.keySet()) {
			List<Integer> il = map.get(ratio);
			for (int idx : il) {
				int w = wt[idx];
				if (capacity >= w) {
					ans += (double) val[idx];
					capacity -= w;
				} else{
				    ans += (double) ratio * capacity;
				    return ans;
				}
			}
		}
		return ans;
	}
}
