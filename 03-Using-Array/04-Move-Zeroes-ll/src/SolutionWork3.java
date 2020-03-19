/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: 课后作业 Leetcode  80 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * @Autor:CourageHe
 * @Date: 2020/3/15 18:02
 */

public class SolutionWork3 {

    //80题 采用多指针法
    public int removeDuplicates2(int[] nums) {
        //在nums中[0,k)中的数字未重复两次以上
        //j作为开头的坐标，以计算重复的个数
        int j = 0,k = 0;
        //遍历第i个元素后，保证[0……i]中的所有未重复两次以上元素都
        //按照顺序排列在[0……k)中
        for (int i = 0; i < nums.length; i++) {
            //主要通过坐标定位，将超过两个以上的数字排除掉
            if(nums[i] != nums[j])
                j=i;
            if((i-j) < 2 )
                nums[k++] = nums[i];
        }
        return k;
    }
    public int removeDuplicates22(int[] nums) {
        int i = 0;
        for (int num : nums)
            if (i < 2 || num > nums[i - 2])
                nums[i++] = num;
        return i;
    }

    public static void main(String[]args){
        int nums[] = {0,0,1,1,1,1,2,3,3};
        long startTime = System.currentTimeMillis();

        SolutionWork3 s = new SolutionWork3();
       int result =  s.removeDuplicates22(nums);

        System.out.println("new length of Array："+result);
        long endTime = System.currentTimeMillis();
        System.out.println("Move-zeroes run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");

    }
}
