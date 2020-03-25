import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: leetcode  349 https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @Autor:CourageHe
 * @Date: 2020/3/25 12:59
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1  = new HashSet<Integer>();
        for(int num :nums1)
            set1.add(num);
        Set<Integer> set2  = new HashSet<>();
        for(int num :nums2){
            if(set1.contains(num)){
                set2.add(num);
            }
        }
        int [] res = new int[set2.size()];
        int i=0;
        for(int num : set2)
            res[i++] = num;

        return res;
    }



    public static void main(String[]args){
        int nums1[] = {1,2,2,1};
        int nums2[]={2,2};

        long startTime = System.currentTimeMillis();

        Solution s = new Solution();
        int[] res = s.intersection(nums1,nums2);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
