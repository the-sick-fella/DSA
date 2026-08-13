class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        return color(v, edges, m, 0, new HashMap<>());
    }
    
    static boolean color(int v, int[][]edges, int m, int vertex, HashMap<Integer, Integer> map){
        if(vertex > v) return true;
        
        for(int i = 1; i<=m; i++){
            if(valid(edges, vertex, i, map)){
                map.put(vertex, i);
                
                boolean pos = color(v, edges, m, vertex+1, map);
                
                if(pos) return true;
                
                map.remove(vertex);
            }
        }
        
        return false;
    }
    
    static boolean valid(int [][] edges, int vertex, int color, HashMap<Integer, Integer> map){
        for(int row [] : edges){
            if(row[0] == vertex || row [1] == vertex){
                if(row[0] == vertex){
                    if(map.get(row[1]) != null && map.get(row[1]) == color)return false;
                }
                
                if(row[1] == vertex){
                    if(map.get(row[0]) != null && map.get(row[0]) == color) return false;
                }
            }
        }
        
        return true;
    }
}