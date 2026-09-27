class Solution {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    // Divide the array and count reverse pairs
    private int mergeSort(int[] nums, int low, int high) {

        // One element -> no pair
        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;

        // Count reverse pairs inside left half
        int count = mergeSort(nums, low, mid);

        // Count reverse pairs inside right half
        count += mergeSort(nums, mid + 1, high);

        // Count reverse pairs between left and right halves
        count += countPairs(nums, low, mid, high);

        // Merge both sorted halves
        merge(nums, low, mid, high);

        return count;
    }

    // Count pairs where:
    // i is in left half
    // j is in right half
    // nums[i] > 2 * nums[j]
    private int countPairs(int[] nums, int low, int mid, int high) {

        int j = mid + 1;
        int count = 0;

        // Traverse the left half
        for (int i = low; i <= mid; i++) {

            /*
             * Move j while the reverse pair condition is true.
             *
             * Use long because 2 * nums[j]
             * can overflow an int.
             */
            while (j <= high &&
                   (long) nums[i] > 2L * nums[j]) {

                j++;
            }

            /*
             * All elements from mid+1 to j-1
             * form reverse pairs with nums[i].
             */
            count += j - (mid + 1);
        }

        return count;
    }

    // Normal merge of two sorted halves
    private void merge(int[] nums, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        // Compare elements from both halves
        while (i <= mid && j <= high) {

            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }

            k++;
        }

        // Remaining elements from left half
        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }

        // Remaining elements from right half
        while (j <= high) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        // Copy sorted elements back to nums
        for (int x = 0; x < temp.length; x++) {
            nums[low + x] = temp[x];
        }
    }
}