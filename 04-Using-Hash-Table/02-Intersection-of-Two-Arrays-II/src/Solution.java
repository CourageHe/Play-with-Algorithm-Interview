import java.util.*;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: leetcode 350 https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * @Autor:CourageHe
 * @Date: 2020/3/25 13:48
 */
public class Solution {
    //时间复杂度（O(nlogn)）
    //空间复杂度（O(n)）
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map  = new HashMap<>();
        //O(nlogn)
        for(int num :nums1)
            map.put(num,map.getOrDefault(num,0)+1);

        List<Integer> list = new ArrayList<>();
        //O(nlogn)
        for(int num :nums2){
            if(map.getOrDefault(num,0 ) != 0){
                map.put(num,map.getOrDefault(num,0)-1);
                list.add(num);
            }
        }

        int [] res = new int[list.size()];
//        O(n)
        for (int i = 0; i < list.size(); i++) {
            res[i] =list.get(i);
        }
        return res;
    }

    public static void main(String[]args){
        int nums1[] = {4,9,5};
        int nums2[]={9,4,9,8,4};

        long startTime = System.currentTimeMillis();

        Solution s = new Solution();
        int[] res = s.intersect(nums1,nums2);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
