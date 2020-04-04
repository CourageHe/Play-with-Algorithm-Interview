import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution217
 * @Description: leetcode 217 https://leetcode-cn.com/problems/contains-duplicate/submissions/
 * @Autor:CourageHe
 * @Date: 2020/3/30 23:57
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            if(set.contains(nums[i]))return true;
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[]args){
        int[] nums = {1,2,3,1};
        int k=3;

        long startTime = System.currentTimeMillis();

        Solution217 ss = new Solution217();
        boolean res = ss.containsDuplicate(nums);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");



    }
}
