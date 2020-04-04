import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: leetcode 1 https://leetcode-cn.com/problems/two-sum/
 * @Autor:CourageHe
 * @Date: 2020/3/27 14:19
 */
public class Solution {

    //时间复杂度O(n)
    //空间复杂度O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();//key-->num value -->index
        for(int i =0;i<nums.length;i++){
            int complement = target-nums[i];
            if(map.containsKey(complement))
                return new int[]{map.get(complement),i};
            map.put(nums[i],i);
        }
        throw new IllegalStateException("the input has no solution");
    }


    public static void main(String[]args){
        int nums[] = {2, 7, 11, 15};
        int target = 9;

        long startTime = System.currentTimeMillis();

        Solution s = new Solution();
        int[] res = s.twoSum(nums,target);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Solution run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
