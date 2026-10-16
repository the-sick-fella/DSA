class Helper{
    int sum;
    int x;
    int y;
    public Helper(int sum, int x, int y){
        this.sum = sum;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;
        
        ArrayList<Integer> ans = new ArrayList<>();
        Set<String> vis = new HashSet<>(); 
        PriorityQueue<Helper> heap = new PriorityQueue<>(
            (p,q) -> Integer.compare(q.sum, p.sum)
        );
        
        int x = n-1, y = n-1;
        int sum = a[x] + b[y];
        Helper obj = new Helper(sum, x, y);
        heap.offer(obj);
        String vertex = x + "," + y;
        vis.add(vertex);
        
        while(ans.size() < k && !heap.isEmpty()){
            obj = heap.poll();
            ans.add(obj.sum);
            x = obj.x;
            y = obj.y - 1;
            
            vertex = x + "," + y;
            if(x>=0 && y>=0 && !vis.contains(vertex)){
                vis.add(vertex);
                sum = a[x] + b[y];
                heap.offer(new Helper(sum, x, y));
            }
            
            x--;
            y++;
            vertex = x + "," + y;
            if(x>=0 && y>=0 && !vis.contains(vertex)){
                vis.add(vertex);
                sum = a[x] + b[y];
                heap.offer(new Helper(sum, x, y));
            }
        }
        
        return ans;
    }
}