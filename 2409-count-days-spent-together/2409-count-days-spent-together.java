class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] calendar = new int[12];
        calendar[0] = 31;
        calendar[1] = 28;
        calendar[2] = 31;
        calendar[3] = 30;
        calendar[4] = 31;
        calendar[5] = 30;
        calendar[6] = 31;
        calendar[7] = 31;
        calendar[8] = 30;
        calendar[9] = 31;
        calendar[10] = 30;
        calendar[11] = 31;

        int arriveBobMonth = Integer.valueOf(arriveBob.substring(0, 2));
        int arriveBobDate = Integer.valueOf(arriveBob.substring(3, 5));
        for (int i = 0; i < arriveBobMonth - 1; i++)
            arriveBobDate += calendar[i];

        int leaveBobMonth = Integer.valueOf(leaveBob.substring(0, 2));
        int leaveBobDate = Integer.valueOf(leaveBob.substring(3, 5));
        for (int i = 0; i < leaveBobMonth - 1; i++)
            leaveBobDate += calendar[i];

        int arriveAliceMonth = Integer.valueOf(arriveAlice.substring(0, 2));
        int arriveAliceDate = Integer.valueOf(arriveAlice.substring(3, 5));
        for (int i = 0; i < arriveAliceMonth - 1; i++)
            arriveAliceDate += calendar[i];

        int leaveAliceMonth = Integer.valueOf(leaveAlice.substring(0, 2));
        int leaveAliceDate = Integer.valueOf(leaveAlice.substring(3, 5));
        for (int i = 0; i < leaveAliceMonth - 1; i++)
            leaveAliceDate += calendar[i];

        if (arriveBobDate > leaveAliceDate || leaveBobDate < arriveAliceDate)
            return 0;

        if (leaveBobDate < leaveAliceDate)
            return leaveBobDate - Math.max(arriveAliceDate, arriveBobDate) + 1;
        return leaveAliceDate - Math.max(arriveAliceDate, arriveBobDate) + 1;

    }
}