import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: leetcode 447 https://leetcode-cn.com/problems/number-of-boomerangs/
 * @Autor:CourageHe
 * @Date: 2020/3/30 17:24
 */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res= 0;
        for(int i=0;i<points.length;i++){
            // record中存储 点i 到所有其他点的距离出现的频次
            Map<Integer,Integer> map = new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i!=j){
                    //不进行开方了 避免造成数据误差
                    int len = (int)(Math.pow(points[i][1]-points[j][1],2)+Math.pow(points[i][0]-points[j][0],2));
                    map.put(len,map.getOrDefault(len,0)+1);
                }
            }
            for(int count:map.values())
                //全排列
                res+=count*(count-1);

        }
        return res;
    }

    public static void main(String[]args){
//        int [][]points = {{0,0},{1,0},{2,0}};
        int [][]points = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};

        long startTime = System.currentTimeMillis();

        Solution ss = new Solution();
        int res = ss.numberOfBoomerangs(points);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
