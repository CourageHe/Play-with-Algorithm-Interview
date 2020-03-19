/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: 课后作业 Leetcode 27 https://leetcode-cn.com/problems/remove-element/
 * @Date: 2020/3/15 18:02
 */

public class SolutionWork2 {
    //时间复杂度 O(n)
    //空间复杂度O(1)
    //27题 采用双指针法
    public int removeElement(int[] nums, int val) {
        int k = 0;//在nums中[0,k)中的数字不等于val
        //遍历第i个元素后，保证[0……i]中的所有不等于val的元素都
        //按照顺序排列在[0……k)中
        for(int i = 0;i < nums.length;i++)
            if(nums[i] != val) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k++] = temp;
            }
        return k;
    }



    public static void main(String[]args){
        int nums[] = {0,1,2,2,3,0,4,2};
        long startTime = System.currentTimeMillis();

        SolutionWork2 s = new SolutionWork2();
       int result =  s.removeElement(nums,2);

        System.out.println("new length of Array："+result);
        long endTime = System.currentTimeMillis();
        System.out.println("Move-zeroes run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");

    }
}
