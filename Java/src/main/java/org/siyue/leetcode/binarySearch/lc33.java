package org.siyue.leetcode.binarySearch;

public class lc33 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = solution.search(nums, target);
        System.out.println(result);
        
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        int result2 = solution.search(nums2, target2);
        System.out.println(result2);
        
        int[] nums3 = {1};
        int target3 = 0;
        int result3 = solution.search(nums3, target3);
        System.out.println(result3);
    }

    static class Solution {
        public int search(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;

            int leftVal = nums[l];
            int rightVal = nums[r];

            if (nums.length <= 2) {
                //  Go throught
                for (int i = l; i <= r; i++) {
                    if (nums[i] == target) {
                        return i;
                    }
                }
                return -1;
            }

            while (r - l >= 0) {
                int mid = (l + r) / 2;
                int midVal = nums[mid];
                leftVal = nums[l];
                rightVal = nums[r];

                if (midVal == target) {
                    return mid;
                }

                // shrink
                if (leftVal > midVal) {
                    // rotation point at left of mid
                    if  (target > midVal && target <= nums[r]) {
                        // shrink right
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    // rotation point at right of mid
                    if (target < midVal && target >= nums[l]) {
                        // shrink left
                        r = mid - 1;
                    } else  {
                        l = mid + 1;
                    }
                }
            }

            return -1;
        }
    }
}
