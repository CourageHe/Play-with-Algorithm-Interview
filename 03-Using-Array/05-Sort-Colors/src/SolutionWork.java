import javax.swing.plaf.synth.SynthStyle;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SolutionWork
 * @Description: 课后作业 lettcode 88 https://leetcode-cn.com/problems/merge-sorted-array/
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



    public static void main(String[]args){
        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};
        long startTime = System.currentTimeMillis();

        SolutionWork s = new SolutionWork();
        s.merge(nums1,3,nums2,3);

//        System.out.println("result："+res);

        long endTime = System.currentTimeMillis();
        System.out.println("homework run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
