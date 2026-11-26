class Solution {
    public boolean canAliceWin(int n) {
        int curr = 10;
        boolean win = false;
        while(n>0){
            if(n<curr)return win;
            n-=curr;
            curr--;
            win = !win;
        }
        return win;
    }
}