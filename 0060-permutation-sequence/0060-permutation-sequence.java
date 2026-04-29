class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int fac = 1;
        for (int i = 1; i <= n; i++){
            list.add(i);
            fac *= i;
        }

        p(n, k-1, sb, list, fac/n);
        return sb.toString();
    }

    void p(int n, int k, StringBuilder sb, List<Integer> list, int fac) {
        if(n == 1) {
            sb.append(list.get(0));
            return;
        }

        int range = k/fac;
        sb.append(list.get(range));
        list.remove(range);

        int pos = k%fac;

        p(n-1, pos, sb, list, fac/(n-1));
    }
}