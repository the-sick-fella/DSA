class Solution {
    public boolean isMaxHeap(int[] arr) {
        int n = arr.length;
        for(int i = 0; i<=(n-2)/2; i++){
            int li = 2*i+1;
            int ri = 2*i+2;
            if(arr[i] < arr[li] || (ri< n && arr[i] < arr[ri])) return false;
        }
        return true;
    }
}