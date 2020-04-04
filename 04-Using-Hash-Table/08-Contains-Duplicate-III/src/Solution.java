import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.FileHandler;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution220
 * @Description: leetcode 220 https://leetcode-cn.com/problems/contains-duplicate-iii/
 * @Autor:CourageHe
 * @Date: 2020/3/31 0:03
 */
public class Solution {


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long>set = new TreeSet<>();
        for(int i =0;i<nums.length;i++){

            if(set.ceiling((long) nums[i]-t) !=null&&set.ceiling((long)nums[i]-t) <=((long)nums[i]+t))return true;
            set.add((long)nums[i]);
            if(set.size() == k+1)
                set.remove((long)nums[i-k]);

        }
        return false;
    }


    public static void main(String[]args){
//        int[] nums = {1,5,9,1,5,9};
//        int k=2;
//        int t =5;
        int[] nums = {0,2147483647};
        int k=1;
        int t =2147483647;

        long startTime = System.currentTimeMillis();

        Solution ss = new Solution();
        boolean res = ss.containsNearbyAlmostDuplicate(nums,k,t);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");



    }
}
