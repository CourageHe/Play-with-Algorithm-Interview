/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: Leetcode 题目 75 https://leetcode-cn.com/problems/sort-colors/
 * @Autor:CourageHe
 * @Date: 2020/3/16 16:21
 */
public class Solution {

    //时间复杂度 O(n)
    //空间复杂度 O(1)
    public void sortColors(int[] nums) {
        int count[] = {0,0,0};//存放0.1.2三个元素的频率
        for(int i = 0;i < nums.length;i++)
            count[nums[i]]++;

        int index = 0;
//        for(int i = 0;i < count[0];i++)
//            nums[index++]=0;
//        for(int i = 0;i < count[1];i++)
//            nums[index++]=1;
//        for(int i = 0;i < count[2];i++)
//            nums[index++]=2;

        for(int i = 0;i < count.length;i++)
            for(int j = 0;j < count[i];j++)
                nums[index++]=i;

        //仅用于测试
        for(int i = 0;i < nums.length;i++)
            System.out.print(nums[i]+" ");
    }


    public static void main(String[]args){
        int nums[] = {2,0,2,1,1,0};

        long startTime = System.currentTimeMillis();

        Solution s = new Solution();
        s.sortColors(nums);

        long endTime = System.currentTimeMillis();
        System.out.println("sortColors run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
