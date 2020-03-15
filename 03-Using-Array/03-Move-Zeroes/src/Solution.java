import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: LeetCode 题目 https://leetcode-cn.com/problems/move-zeroes/submissions/
 * @Autor:CourageHe
 * @Date: 2020/3/15 18:02
 */
public class Solution {
    //时间复杂度 O(n)
    //空间复杂度O(n)
    public void  moveZeroes(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for(int i = 0;i < nums.length;i++)
            if(nums[i] != 0)
                arr.add(nums[i]) ;
        for(int i = 0;i < arr.size();i++)
            nums[i] =arr.get(i);
        for(int i = arr.size(); i < nums.length;i++)
            nums[i] = 0;

        for(int i : nums)
            System.out.print(i + " ");

    }
    public static void main(String[]args){
        int nums[] = {0};
        long startTime = System.currentTimeMillis();

        Solution s = new Solution();
        s.moveZeroes(nums);

        System.out.println();
        long endTime = System.currentTimeMillis();
        System.out.println("Move-zeroes run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");

    }
}
