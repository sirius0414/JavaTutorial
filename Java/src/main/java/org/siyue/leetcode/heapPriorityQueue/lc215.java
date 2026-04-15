package org.siyue.leetcode.heapPriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

public class lc215 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = solution.findKthLargest(nums, k);
        System.out.println(result);
        
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        int result2 = solution.findKthLargest(nums2, k2);
        System.out.println(result2);
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            Sort sort;
            sort = new Sort();

            // sort.insertionSort(nums);         //超出时间限制
            // sort.binaryInsertionSort(nums);   //超出时间限制
            // sort.shellSort(nums);             //时间:47 ms 39.11%  | 空间:69.06 MB  28.96%
            // sort.bubbleSort(nums);            //超出时间限制
            // sort.quickSort(nums);             //超出时间限制
            // sort.simpleSelectionSort(nums);   //超出时间限制
            sort.heapSort(nums);              //时间:30 ms 56.12%  | 空间:69.07 MB  28.25%
            // sort.mergeSort(nums);             //时间:52 ms 33.38%  | 空间:78.29 MB  5.02%
            // sort.radixSort(nums);             //处理不了负数

            return nums[nums.length-k];
        }
    }

    public static class Sort {
        /**
         * 快速排序
         * 依次将每个元素插入到之前已经排好序的数组中
         * 时间复杂度：最好 O(n) 最坏 O(n^2) 平均 O(n^2)
         * 空间复杂度：O(1)
         * 稳定性：稳定
         *
         * @param nums
         */
        public void insertionSort(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int curVal = nums[i];
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] <= curVal) break;

                    nums[j + 1] = nums[j];
                    nums[j] = curVal;
                }
            }
        }

        /**
         * 折半插入排序
         * 使用折半查找的方式，查找当前数应当插入到之前排好序的数组的哪个下标上
         * 时间复杂度：最好 O(n) 最坏 O(n^2) 平均 O(n^2)
         * 空间复杂度：O(1)
         * 稳定性：稳定
         *
         * @param nums
         */
        public void binaryInsertionSort(int[] nums) {
            if (nums.length <= 1) return;
            for (int i = 1; i < nums.length; i++) {
                int curVal = nums[i];
                int insertIdx = binarySearch(nums, curVal, 0, i);

                for (int j = i; j > insertIdx; j--) {
                    nums[j] = nums[j - 1];
                }

                nums[insertIdx] = curVal;
            }
        }

        private int binarySearch(int[] nums, int target, int left, int right) {  //[left,right)
            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    return mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }

            return left;
        }


        /**
         * 希尔排序
         * 定义一个增量d（一般为数组长度的一半），将数组分为d组，在组内进行插入排序
         * 排好后将d减小一般，继续在组内排序，直到d=0
         * 时间复杂度：最好 O(n) 最坏 O(n^2) 平均 O(n^1.3)
         * 空间复杂度：O(1)
         * 稳定性：不稳定
         *
         * @param nums
         */
        public void shellSort(int[] nums) {
            int d = nums.length / 2;
            while (d > 0) {

                for (int i = 0; i < d; i++) {
                    int curIdx = i + d;
                    while (curIdx < nums.length) {
                        int insertIdx = curIdx - d;
                        int curVal = nums[curIdx];
                        while (insertIdx >= 0 && nums[insertIdx] > curVal) {
                            nums[insertIdx + d] = nums[insertIdx];
                            insertIdx -= d;
                        }
                        nums[insertIdx + d] = curVal;

                        curIdx += d;
                    }
                }
                d /= 2;
            }
        }

        /**
         * 冒泡排序：
         * 每一轮都从前往后依次比较相邻的两个，逆序就交换
         * 时间复杂度：最好 O(n) 最坏 O(n^2) 平均 O(n^2)
         * 空间复杂度：O(1)
         * 稳定性：稳定
         *
         * @param nums
         *
         */
        public void bubbleSort(int[] nums) {

            for (int i = nums.length; i > 0; i--) {
                boolean changed = false;    //用于判断之前是否交换过，没有说明已经排序好了，直接返回
                for (int j = 1; j < i; j++) {
                    if (nums[j] < nums[j - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = temp;
                        changed = true;
                    }
                }
                if (!changed) return;
            }
        }

        /**
         * 快速排序：
         * 任取一个元素作为枢轴。划分两部分，左＜枢轴，右＞枢轴。递归处理左右，直到空或者只剩一个
         * 时间复杂度：最好 O(nlogn) 最坏 O(n^2) 平均 O(nlogn)
         * 空间复杂度：最好 O(nlogn) 最坏 O(n) 平均 O(nlogn)
         * 稳定性：不稳定
         *
         * @param nums
         */
        public void quickSort(int[] nums) {
            doQuickSort(nums, 0, nums.length - 1);
        }

        private void doQuickSort(int[] nums, int first, int last) {
            if (first >= last) return;

            int pivot = nums[first];
            int left = first, right = last;

            boolean insertIntoLeft = true;
            while (left < right) {
                if (insertIntoLeft) {
                    if (nums[right] < pivot) {
                        nums[left] = nums[right];
                        left++;
                        insertIntoLeft = false;
                    } else right--;
                } else {
                    if (nums[left] > pivot) {
                        nums[right] = nums[left];
                        right--;
                        insertIntoLeft = true;
                    } else left++;
                }
            }

            nums[left] = pivot;

            doQuickSort(nums, first, left - 1);
            doQuickSort(nums, right + 1, last);

        }

        /**
         * 简单选择排序：
         * 每轮都在剩下的数里选择最小的换到前面
         * 时间复杂度：最好 O(n^2) 最坏 O(n^2) 平均 O(n^2)
         * 空间复杂度：O(1)
         * 稳定性：不稳定
         *
         * @param nums
         */
        public void simpleSelectionSort(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                int minValIdx = i;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] < nums[minValIdx]) minValIdx = j;
                }
                int temp = nums[minValIdx];
                nums[minValIdx] = nums[i];
                nums[i] = temp;
            }
        }

        /**
         * 堆排序：
         * 1.构建大根堆：从最后一个非叶节点开始依次向下调整
         * 2.排序：每轮堆顶换到最后，向下调整新的堆顶
         * 时间复杂度：最好 O(nlog2n) 最坏 O(nlog2n) 平均 O(nlog2n)
         * 空间复杂度：O(1)
         * 稳定性：不稳定
         *
         * @param nums
         */
        public void heapSort(int[] nums) {
            //构建大根堆
            for (int i = (nums.length) / 2 - 1; i >= 0; i--) {
                generateHeap(nums, i, nums.length);
            }

            //排序
            for (int i = nums.length - 1; i > 0; i--) {
                swap(nums, 0, i);
                generateHeap(nums, 0, i);
            }
        }

        private void generateHeap(int[] nums, int idx, int maxLength) {
            int leftChild = (idx + 1) * 2 - 1, rightChild = (idx + 1) * 2;

            if (leftChild >= maxLength) return;

            if (rightChild >= maxLength) {
                if (nums[leftChild] > nums[idx]) {
                    swap(nums, idx, leftChild);
                    generateHeap(nums, leftChild, maxLength);
                }
            } else {
                int greaterValIdx = nums[leftChild] > nums[rightChild] ? leftChild : rightChild;
                if (nums[greaterValIdx] > nums[idx]) {
                    swap(nums, idx, greaterValIdx);
                    generateHeap(nums, greaterValIdx, maxLength);
                }
            }
        }

        private void swap(int[] nums, int idx1, int idx2) {
            int temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
        }

        /**
         * 归并排序：
         * 利用归并操作进行排序
         * 归并操作：每次都选两个数组中最小的（比较各自剩下元素中的第一个）。其中一个放完后，另一个剩下的元素直接放在最后
         * 时间复杂度：最好 O(nlog2n) 最坏 O(nlog2n) 平均 O(nlog2n)
         * 空间复杂度：O(n)
         * 稳定性：稳定
         *
         * @param nums
         */
        public void mergeSort(int[] nums) {
            int[] sortedArr = doMergeSort(nums);

            for (int i = 0; i < sortedArr.length; i++) {
                nums[i] = sortedArr[i];
            }
        }

        public int[] doMergeSort(int[] nums) {
            if (nums.length <= 1) return nums;

            int[] res = new int[nums.length];
            int idx = 0;

            int[] leftArr = doMergeSort(Arrays.copyOfRange(nums, 0, nums.length / 2));
            int[] rightArr = doMergeSort(Arrays.copyOfRange(nums, nums.length / 2, nums.length));

            //进行归并操作
            int left = 0, right = 0;
            while (left < leftArr.length && right < rightArr.length) {
                if (leftArr[left] < rightArr[right]) {
                    res[idx] = leftArr[left];
                    left++;
                } else {
                    res[idx] = rightArr[right];
                    right++;
                }
                idx++;
            }

            while (left < leftArr.length) {
                res[idx] = leftArr[left];
                left++;
                idx++;
            }

            while (right < rightArr.length) {
                res[idx] = rightArr[right];
                right++;
                idx++;
            }

            return res;
        }

        /**
         * 基数排序
         * @param nums
         */
        public void radixSort(int[] nums) {
            int digit = 10;
            Node[] buckets = new Node[10];
            Node[] tails = new Node[10];
            Node result = new Node(nums[0]);
            Node cur = result;

            int max = 0;

            for (int i = 1; i < nums.length; i++) {
                max = Math.max(max,nums[i]);
                cur.next = new Node(nums[i]);
                cur = cur.next;
            }

            while (digit <= max*10) {

                //入桶
                for (int i = 0; i < nums.length; i++) {
                    int num = result.val;
                    result = result.next;
                    int place = num%digit*10/digit;

                    Node head = buckets[place];
                    if (head==null) {
                        head = new Node(num);
                        buckets[place] = head;
                        tails[place] = head;
                    }else {
                        tails[place].next = new Node(num);
                        tails[place] = tails[place].next;
                    }
                }

                //出桶
                int firstIdx = 0;
                while (buckets[firstIdx]==null) firstIdx++;
                result = buckets[firstIdx];
                Node preTail = tails[firstIdx];
                buckets[firstIdx] = null;
                tails[firstIdx] = null;
                for (int i = firstIdx +1; i < buckets.length; i++) {
                    if (buckets[i]!=null){
                        preTail.next = buckets[i];
                        preTail = tails[i];
                        buckets[i] = null;
                        tails[i] = null;
                    }
                }

                digit *= 10;
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = result.val;
                result = result.next;
            }
        }

        class Node {
            Node next;
            int val;

            Node(int val) {
                this.val = val;
            }
        }

    }

}
