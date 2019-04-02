import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (60.42%)
 * Total Accepted:    14.8K
 * Total Submissions: 24.5K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 
 * 说明:
 * 
 * 
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
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

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0)
            return new int[0];
        // qsort(nums1, 0, nums1.length-1);
        // qsort(nums2, 0, nums2.length-1);
        HashSet<Integer> sets = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        for (int i= 0 ; i < nums1.length; i++) 
            sets.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++) {
            if(sets.contains(nums2[i])){
                ans.add(nums2[i]);
            }
        }
        int[] result = new int[ans.size()];
        int count = 0;
        for (int a : ans){
            result[count++] = a;
        }

        return result;

    }
}
