/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: 课后作业 Leetcode 27 https://leetcode-cn.com/problems/remove-element/
 *                                26 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *                                80 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * @Autor:CourageHe
 * @Date: 2020/3/15 18:02
 */

public class SolutionWork {
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

        SolutionWork s = new SolutionWork();
       int result =  s.removeDuplicates22(nums);

        System.out.println("new length of Array："+result);
        long endTime = System.currentTimeMillis();
        System.out.println("Move-zeroes run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");

    }
}
