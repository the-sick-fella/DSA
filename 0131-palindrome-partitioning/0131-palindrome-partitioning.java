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

            if(palindrome(s, idx, idx + i - 1)){
                curr.add(s.substring(idx, idx+i));

                p(s, idx + i, list, curr);

                curr.remove(curr.size() -1);
            }
        }
    }

    boolean palindrome (String s, int si, int ei){
        while(si<ei){
            if(s.charAt(si) != s.charAt(ei)) return false;
            si++;
            ei--;
        }

        return true;
    }
}