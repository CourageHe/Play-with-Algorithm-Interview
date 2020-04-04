import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: leetcode 454 https://leetcode-cn.com/problems/4sum-ii/
 * @Autor:CourageHe
 * @Date: 2020/3/30 15:44
 */
public class Solution {


    //时间复杂度 O(n^2)
    //空间复杂度 O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer,Integer>mapAB = new HashMap<>();
        for(int a:A)
            for(int b:B)
                mapAB.put(a+b,mapAB.getOrDefault(a+b,0)+1);

        int res = 0;
        for(int c:C)
            for(int d:D){
                if(mapAB.get(-(c+d))!= null)
                    res+=mapAB.get(-(c+d));
            }

        return res;
    }


    public static void main(String[]args){
        int []A = { 1, 2};
        int []B = {-2,-1};
        int []C = {-1, 2};
        int []D = { 0, 2};

        long startTime = System.currentTimeMillis();

        Solution ss = new Solution();
        int res = ss.fourSumCount(A,B,C,D);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
