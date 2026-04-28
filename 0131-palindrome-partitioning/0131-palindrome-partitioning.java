class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        for(int parts = 1; parts<=s.length(); parts++){
            p(0, parts, list, s, new ArrayList<>());
        }
        return list;
    }

    void p(int idx, int parts, List<List<String>> list, String s, List<String> temp){
        if(parts == 1){
            if(!valid(s, idx, s.length()-1)) return;

            temp.add(s.substring(idx, s.length()));
            list.add(new ArrayList<>(temp));
            temp.remove(temp.size() -1);
            return;
        }

        for(int len = 1; idx+len < s.length(); len++){
            if(!valid(s, idx, idx+len-1)) continue;

            temp.add(s.substring(idx, idx+len));
            p(idx+len, parts-1, list, s, temp);
            temp.remove(temp.size() - 1);
        }
    }

    boolean valid(String s, int si, int ei){
        while(si<ei){
            if(s.charAt(si) != s.charAt(ei)) return false;
            si++;
            ei--;
        }

        return true;
    }
}