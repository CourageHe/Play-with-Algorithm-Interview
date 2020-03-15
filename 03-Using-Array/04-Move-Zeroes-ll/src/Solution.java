import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: LeetCode 题目 https://leetcode-cn.com/problems/move-zeroes/submissions/
 *              优化方案一：双指针法
 * @Autor:CourageHe
 * @Date: 2020/3/15 18:02
 */
public class Solution {
    //时间复杂度 O(n)
    //空间复杂度O(1)
    public void  moveZeroes(int[] nums) {
        int k = 0;//nums中，在[0……k)的元素均为非0元素
        //遍历第i个元素后，保证[0……i]中的所有非零元素都
        //按照顺序排列在[0……k)中
        for(int i = 0;i < nums.length;i++)
            if (nums[i] != 0)
                nums[k++] = nums[i];
        //将nums中剩余的位置置为零
        for(int i = k;i < nums.length;i++)
            nums[i] = 0;

        for(int i : nums)
            System.out.print(i + " ");
    }
    public static void main(String[]args){
        int nums[] = {0,1,0,3,12};
        long startTime = System.currentTimeMillis();

        Solution s = new Solution();
        s.moveZeroes(nums);

        System.out.println();
        long endTime = System.currentTimeMillis();
        System.out.println("Move-zeroes run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");

    }
}
