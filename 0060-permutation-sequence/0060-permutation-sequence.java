class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int fac = 1;
        for (int i = 1; i < n; i++) {
            list.add(i);
            fac *= i;
        }
        list.add(n);
        
        k--;
        n--;

        while (!list.isEmpty()) {
            int range = k / fac;
            sb.append(list.get(range));
            list.remove(range);

            if(n==0) break;
            
            k = k % fac;
            fac /= n;
            n--;
        }

        return sb.toString();
    }
}