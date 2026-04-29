class Solution {
    public String getPermutation(int n, int k) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int div = 1;
        for(int i = 2; i<n; i++){
            div*=i;
        }

        int si, counter;
        if(k%div != 0){
            si = (k/div) + 1;
            counter = k%div;
        }
        else{
            si = k/div;
            counter = div;
        }

        boolean x = p(n, counter, true, si, sb, new ArrayList<>(), list);
        return list.get(list.size()-1);
    }

    boolean p(int n, int k, boolean first, int si, StringBuilder sb, List<Integer> visited, List<String> list){
        if(visited.size() == n){
            list.add(sb.toString());

            if(list.size() == k){
                return true;
            }
            return false;
        }

        int i;
        if(first) i = si;
        else i=1;
        
        for(; i<=n; i++){
            if(visited.contains(i)) continue;

            sb.append(i);
            visited.add(i);
            boolean found = p(n, k, false, si, sb, visited, list);
            if(found) return true;

            visited.remove(visited.size() -1);
            sb.deleteCharAt(sb.length() -1);
        }

        return false;
    }
}