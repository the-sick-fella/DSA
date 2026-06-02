class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            int one = landStartTime[i] + landDuration[i];
            // System.out.println("sum: " + sum);
            for (int j = 0; j < waterStartTime.length; j++) {
                int two;
                if (waterStartTime[j] > one)
                    two = waterStartTime[j] + waterDuration[j];
                else
                    two = one + waterDuration[j];
                ans = Math.min(ans, two);
            }
            // System.out.println(ans);
        }

        for (int i = 0; i < waterStartTime.length; i++) {
            int one = waterStartTime[i] + waterDuration[i];
            for (int j = 0; j < landStartTime.length; j++) {
                int two;
                if (landStartTime[j] > one)
                    two = landStartTime[j] + landDuration[j];
                else
                    two = one + landDuration[j];
                ans = Math.min(ans, two);
            }
        }

        return ans;
    }
}