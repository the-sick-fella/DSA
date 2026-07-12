class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);

        int rank = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            if (!map.containsKey(temp[i])){
                map.put(temp[i], rank);
                rank++;
            }
        }

        for(int i = 0; i<arr.length; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}