class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] <= intervals[i][1])
                    count++;
            }
        }
        return count;
    }
}