import com.sun.xml.internal.bind.v2.runtime.SwaRefAdapter;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: Leetcode 题目 75 https://leetcode-cn.com/problems/sort-colors/
 * @Autor:CourageHe
 * @Date: 2020/3/16 16:21
 */
public class Solution2 {

    //时间复杂度 O(n)
    //空间复杂度 O(1)
    //三路插入排序
    public void sortColors(int[] nums) {
        int zero = -1; //nums[0……zero] =0
        int two = nums.length; //nums[two……n) =0

        for(int i = 0;i < two;){
            if(nums[i] == 1){
                i++;
            }else if(nums[i] == 2){
                swap(nums,i,--two);
            }else{
                swap(nums,i++,++zero);
            }
        }
        for(int i = 0;i <nums.length;i++)
            System.out.print(nums[i]+" ");
    }
    public void swap(int nums[],int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public static void main(String[]args){
        int nums[] = {2,0,2,1,1,0};

        long startTime = System.currentTimeMillis();

        Solution2 s = new Solution2();
        s.sortColors(nums);

        long endTime = System.currentTimeMillis();
        System.out.println("sortColors run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
