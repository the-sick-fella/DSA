class Solution {
    public int[] sortArray(int[] nums) {
        ms(nums, 0, nums.length - 1);
        return nums;
    }

    void ms(int[] nums, int low, int high) {
        if (low == high)
            return;

        int mid = (low + high) / 2;

        ms(nums, low, mid);
        ms(nums, mid + 1, high);

        merge(nums, low, mid, high);
    }

    void merge(int[] nums, int low, int mid, int high) {
        int arr[] = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int idx = 0;

        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                arr[idx] = nums[i];
                i++;
            }

            else {
                arr[idx] = nums[j];
                j++;
            }
            idx++;
        }

        while (i <= mid) {
            arr[idx] = nums[i];
            i++;
            idx++;
        }

        while (j <= high) {
            arr[idx] = nums[j];
            j++;
            idx++;
        }

        for (int num : arr) {
            nums[low] = num;
            low++;
        }
    }
}