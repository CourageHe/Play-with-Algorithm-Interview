import sun.security.util.LegacyAlgorithmConstraints;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Test
 * @Description:
 * @Autor:CourageHe
 * @Date: 2020/3/17 21:42
 */
public class Solution {
    //求数列的最大字段和


    public int crossSum(int[] nums, int left, int right, int p) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = p; i >= left; i--) {
            currSum += nums[i];
            leftSum = Math.max(currSum, leftSum);
        }
        currSum = 0;
        for (int i = p+ 1; i <= right; i++) {
            currSum += nums[i];
            rightSum = Math.max(currSum, rightSum);
        }
        return leftSum + rightSum;
    }

    public int helper(int[] nums, int left, int right) {
        if(left == right) return nums[left];
        int mid = left +(right-left)/2;
        int leftSum = helper(nums, left, mid);
        int rightSum = helper(nums, mid+1, right);
        int crossSum = crossSum(nums,left,right,mid);
        return Math.max(crossSum,Math.max(leftSum,rightSum));
    }
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

       public static void main(String[]args){
//           int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
           int nums[] = {-2,1};


        long startTime = System.currentTimeMillis();

        Solution s = new Solution();
        int res = s.maxSubArray(nums);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Test run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }

}
