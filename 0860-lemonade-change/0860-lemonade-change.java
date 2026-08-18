class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        map.put(20, 0);

        for(int bill : bills){
            System.out.println(map);
            if(bill != 5){
                if(!check(map, bill - 5)) return false;
            }
            map.put(bill, map.get(bill) + 1);
        }
        return true;
    }

    boolean check(Map<Integer, Integer> map, int bill){
        while(bill >= 20 && map.get(20) > 0){
            bill-=20;
            map.put(20, map.get(20) - 1);
        }
        while(bill >= 10 && map.get(10) > 0){
            bill-=10;
            map.put(10, map.get(10) - 1);
        }
        while(bill >= 5 && map.get(5) > 0){
            bill-=5;
            map.put(5, map.get(5) - 1);
        }
        if(bill != 0) return false;
        return true;
    }
}