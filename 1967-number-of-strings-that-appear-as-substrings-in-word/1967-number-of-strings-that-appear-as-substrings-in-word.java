class Solution {
    public int numOfStrings(String[] patterns, String word) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i<word.length(); i++){
            for(int j = i+1; j<=word.length(); j++){
                list.add(word.substring(i, j));
            }
        }

        int count = 0;
        for(String s : patterns){
            if(list.contains(s)) count++;
        }
        return count;
    }
}