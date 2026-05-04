class Solution {
    public String getPermutation(int n, int k) {
        int x = 1;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            x *= i;
            list.add(i);
        }

        x/=n;
        StringBuilder sb = new StringBuilder();
        return p(n, k-1, list, x, sb);
    }

    String p(int n, int k, List<Integer> list, int x, StringBuilder sb){
        if(list.size() == 1){
            sb.append(list.get(0));
            return sb.toString();
        }

        int range = k/x;
        sb.append(list.get(range));
        list.remove(range);
        
        int pos = k%x;
        return p(n-1, pos, list, x/(n-1), sb);
    }
}