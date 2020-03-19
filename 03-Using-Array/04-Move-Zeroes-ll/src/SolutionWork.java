/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: 课后作业 Leetcode  26 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @Autor:CourageHe
 * @Date: 2020/3/15 18:02
 */

public class SolutionWork {

    //26题 采用双指针法
    public int removeDuplicates(int[] nums) {
        int k = 0;//在nums中[0,k]中的数字无重复
        //遍历第i个元素后，保证[0……i]中的所有不重复元素都
        //按照顺序排列在[0……k)中
        for (int i = 1; i < nums.length; i++)
            if(nums[i] != nums[k] )
                nums[++k] = nums[i];
        return k+1;
    }


    public static void main(String[]args){
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        long startTime = System.currentTimeMillis();

        SolutionWork s = new SolutionWork();
       int result =  s.removeDuplicates(nums);

        System.out.println("new length of Array："+result);
        long endTime = System.currentTimeMillis();
        System.out.println("Move-zeroes run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");

    }
}
