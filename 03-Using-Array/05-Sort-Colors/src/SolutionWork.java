import javax.swing.plaf.synth.SynthStyle;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SolutionWork
 * @Description: 课后作业 lettcode 88 https://leetcode-cn.com/problems/merge-sorted-array/
 *                                215 https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @Autor:CourageHe
 * @Date: 2020/3/16 22:21
 */
public class SolutionWork {

    //88题 二路归并法
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums = new int[m+n];
        int i=0,j=0,k=0;
        while (i<m&&j<n) {
            newNums[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < m){
            newNums[k++] = nums1[i++];
        }
        while (j < n) {
            newNums[k++] = nums2[j++];
        }

        for(int l =0;l< newNums.length;l++){
            nums1[l] = newNums[l];
            System.out.print(nums1[l]+" ");
        }
    }


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

        SolutionWork s = new SolutionWork();
        int res = s.findKthLargest(nums,1);

        System.out.println("result："+res);

        long endTime = System.currentTimeMillis();
        System.out.println("homework run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
