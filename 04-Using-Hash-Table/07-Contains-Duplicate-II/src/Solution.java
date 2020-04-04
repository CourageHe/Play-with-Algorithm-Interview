import java.util.HashSet;
import java.util.Set;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: leetcode 219 https://leetcode-cn.com/problems/contains-duplicate-ii/
 * @Autor:CourageHe
 * @Date: 2020/3/30 23:23
 */
public class Solution {
    //窗口法
    //时间复杂度O(n)
    //空间复杂度O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length==0||k==0)return false;
        //在合理区间检查是否存在重复 若存在则直接为true
        int l=0;int r=(l+k)>(nums.length-1)?(nums.length-1):(l+k);

        //利用set集合判断是否存在重复
        Set<Integer>set = new HashSet<>();
        for(int i =l;i<=r-1;i++){
            if(set.contains(nums[i]))return true;
            set.add(nums[i]);
        }
        while(r<nums.length){
            if(set.contains(nums[r]))return true;
            set.add(nums[r]);
            set.remove((Object)nums[l]);
            l++;r++;
        }

        return false;
    }
    //窗口简化版
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer>set = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            if(set.contains(nums[i]))return true;
            set.add(nums[i]);
            if(set.size() == k+1)
                set.remove((Object)nums[k-i]);
        }
        return false;
    }


        public static void main(String[]args){
        int[] nums = {1,2,3,1};
        int k=3;

        long startTime = System.currentTimeMillis();

        Solution ss = new Solution();
        boolean res = ss.containsNearbyDuplicate(nums,k);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
