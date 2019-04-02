import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
 *
 * algorithms
 * Easy (39.49%)
 * Total Accepted:    26.5K
 * Total Submissions: 67K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 
 * 说明：
 * 
 * 
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 
 * 
 * 进阶:
 * 
 * 
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 
 * 
 */
class Solution {
    public void qsort(int[] nums, int i, int j) {
        if (i >= j)
            return;

        int start = i, end = j;
        int compare = nums[i];

        while (start < end) {

            while (start < end && nums[end] >= compare)
                end--;
            while (start < end && nums[start] <= compare)
                start++;

            if (start < end)
                swap(nums, start, end);
        }
        swap(nums, i, end);
        qsort(nums, i, end - 1);
        qsort(nums, end + 1, j);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void qsort2(int nums[], int a, int b) {
        if (a >= b)
            return;
        int i = a, j = b;
        int compare = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= compare)
                j--;
            nums[i] = nums[j];
            while (i < j && nums[i] <= compare)
                i++;
            nums[j] = nums[i];
        }
        nums[j] = compare;
        qsort(nums, a, j - 1);
        qsort(nums, j + 1, b);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        qsort2(nums1, 0, nums1.length - 1);
        qsort2(nums2, 0, nums2.length - 1);

        int count1 = 0, count2 = 0;
        int index = 0;
        while (count1 < nums1.length && count2 < nums2.length) {
            if (nums1[count1] == nums2[count2]) {
                nums1[index++] = nums1[count1++];
                count2++;
            } else if (nums1[count1] < nums2[count2]) {
                count1 ++;
            } else {
                count2 ++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, index);
    }
}
