import org.omg.CORBA.INTERNAL;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: leetcode 209 https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * @Autor:CourageHe
 * @Date: 2020/3/19 10:45
 */
public class Solution {

    //暴力解法
    //时间复杂度 O(n^2)
    public int minSubArrayLen(int s, int[] nums) {
        int maxLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s)
                    maxLen = maxLen < (j - i + 1) ? maxLen : (j - i + 1);
            }
        }
        if(maxLen !=Integer.MAX_VALUE)return maxLen;
        return  0;
    }
    //双指针之滑动窗口法
    public int minSubArrayLen2(int s, int[] nums) {
        int i = 0, j = 0;
        int maxLen = Integer.MAX_VALUE;
        int sum = 0;
        while (i < nums.length) {
            if (sum < s && j < nums.length) {
                sum += nums[j++];
            } else
                sum -= nums[i++];

            if (sum >= s) {
                maxLen = Math.min(maxLen, (j - i ));
            }

        }

        if (maxLen != Integer.MAX_VALUE) return maxLen;
        return 0;
    }
    public static void main(String[]args){
        int nums[] = {2,3,1,2,4,3};
        long startTime = System.currentTimeMillis();

        Solution s = new Solution();
        int res = s.minSubArrayLen2(7,nums);

        System.out.println("Result："+res);
        long endTime = System.currentTimeMillis();
        System.out.println("Minimum-Size-Subarray-Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");

    }
}
