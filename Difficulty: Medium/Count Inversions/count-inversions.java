class Solution {
    static int inversionCount(int arr[]) {
        // Code Here
        return ms(arr, 0, arr.length-1);
    }

    static int ms(int [] arr, int low, int high){
        if(low >= high) return 0;

        int mid = (low + high)/2;

        int l = ms(arr, low, mid);
        int r = ms(arr, mid+1, high);
        return l + r + merge(arr, low, mid, high);
    }

    static int merge(int [] arr, int low, int mid, int high){
        int count = 0;
     int[] temp = new int[high-low+1];
     int idx = 0;
     int i = low;
     int j = mid+1;

     while(i<=mid && j<=high){
         if(arr[i] > arr[j]){
             count += mid-i+1;

             temp[idx] = arr[j++];
         }
         else{
             temp[idx] = arr[i++];
         }

         idx++;
     }

     while(i<=mid){
         temp[idx] = arr[i++];
         idx++;
     }

     while(j<=high){
         temp[idx] = arr[j++];
         idx++;
     }

     for(int num:temp){
         arr[low++] = num;
     }

     return count;
    }
}