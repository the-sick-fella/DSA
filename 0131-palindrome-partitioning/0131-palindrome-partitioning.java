class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        p(s, 0, list, new ArrayList<>());
        return list;
    }

    void p(String s, int idx, List<List<String>> list, List<String> curr){
        if(idx == s.length()){
            list.add(new ArrayList<>(curr));
            return;
        }


        for(int i = 1; i<=s.length(); i++){
            if(idx+i > s.length()) return;
            String sub = s.substring(idx, idx+i);

            if(palindrome(sub)){
                curr.add(sub);

                p(s, idx + i, list, curr);

                curr.remove(curr.size() -1);
            }
        }
    }

    boolean palindrome (String s){
        for(int i = 0; i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length() -1 -i)) return false;
        }

        return true;
    }
}