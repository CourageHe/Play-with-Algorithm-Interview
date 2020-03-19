/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SolutionWork
 * @Description: 课后作业 lettcode 215 https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @Autor:CourageHe
 * @Date: 2020/3/16 22:21
 */
public class SolutionWork2 {

    //215题 冒泡法优化
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int kk = nums.length - k;
        do{
            int index = 0;//排序辅助坐标点 在nums(index……n)中是有序的
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;

                    index = i;//记录最后一次交换的坐标
                }
            }
            n = index;
            if (index < kk) return nums[kk];
        }while(n > 0);
        return nums[kk];
    }

    //215题 快排优化
    public int findKthLargest2(int[] nums, int k) {

        return 0;
    }
    public static void main(String[]args){
        int nums[] = {1};
        long startTime = System.currentTimeMillis();

        SolutionWork2 s = new SolutionWork2();
        int res = s.findKthLargest(nums,1);

        System.out.println("result："+res);

        long endTime = System.currentTimeMillis();
        System.out.println("homework run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
