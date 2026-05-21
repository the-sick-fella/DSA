class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();
        for(int val : arr1){
            String s = String.valueOf(val);

            for(int i = 1; i<=s.length(); i++){
                set.add(s.substring(0, i));
            }
        }

        int ans = 0;
        for(int val : arr2){
            String s = String.valueOf(val);

            for(int i = s.length(); i>0; i--){
                if(set.contains(s.substring(0, i))){
                    ans = Math.max(ans, i);
                    break;
                }
            }
        }

        return ans;
    }
}