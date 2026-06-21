class Solution {
    public int maxDistance(String moves) {
        Map<Character, Integer> map = new HashMap<>();
        int blank = 0;

        for(char c : moves.toCharArray()){
            switch(c){
                case '_': blank++;
                    break;
                case 'U': map.put('U', map.getOrDefault('U', 0) + 1 );
                    break;
                case 'D': map.put('D', map.getOrDefault('D', 0) + 1 );
                    break;
                case 'L': map.put('L', map.getOrDefault('L', 0) + 1 );
                    break;
                case 'R': map.put('R', map.getOrDefault('R', 0) + 1 );
                    break;
            }
        }


        int x = 0, y = 0;

        for(char c : map.keySet()){
            switch(c){
                case 'U': y+=map.get('U');
                    break;
                case 'D': y-=map.get('D');
                    break;
                case 'L': x-=map.get('L');
                    break;
                case 'R': x+=map.get('R');
                    break;
            }
        }

        return Math.abs(x) + Math.abs(y) + blank;
    }
}