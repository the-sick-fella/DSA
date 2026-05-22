class Solution {
    public int search(int[] nums, int target) {

       int pi = peakIndex(nums);

        int index = binarySearch(nums, target, 0, pi);
        if (index == -1) {
            index = binarySearch(nums, target, pi + 1, nums.length - 1);
        }

        return index;
    }

    public static int binarySearch(int[] arr, int target, int si, int ei) {
        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (target > arr[mid]) {
                si = mid + 1;
            } else if (target < arr[mid]) {
                ei = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static int peakIndex(int[] arr) {
        int ans = arr.length / 2;
        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (mid != 0 && arr[mid - 1] > arr[mid]) {
                return mid - 1;
            } if (mid != arr.length - 1 && arr[mid] > arr[mid + 1]) {
                return mid;
            } if (arr[mid] < arr[si]) {
                ei = mid - 2;
            } else {
                si = mid + 1;
            }

        }

        return ans;
    }

}