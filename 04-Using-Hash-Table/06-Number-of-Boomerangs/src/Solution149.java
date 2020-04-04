import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution149
 * @Description: leetcode 149 https://leetcode-cn.com/problems/max-points-on-a-line/
 * @Autor:CourageHe
 * @Date: 2020/3/30 21:15
 */
public class Solution149 {
    public int maxPoints(int[][] points) {
        //两点确定一条直线
        if(points.length<3)return points.length;
        int res =0;
        for(int i=0;i<points.length;i++){
            int flag =0;//当值相同时 临时加偏移量
            // record中存储 点i 到所有其他点的距离出现的频次
            Map<Long,Integer> map = new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i!=j){
                    //不进行开方了 避免造成数据误差
                     long k = getSlope(points[i],points[j]);

                    if(k==123456)//两点相等时 所有斜率点皆可加1
                        flag++;
                    else
                        map.put(k,map.getOrDefault(k,1)+1);
                }
            }
            if(map.size() != 0){
                for(int count:map.values()) {
                    //全排列
                    res = res > (count+flag) ? res : (count+flag);
                }
            }else
                return flag+1;

        }
        return res;
    }
    private long getSlope(int[]pointA,int[]pointB){
        if(pointA[0]==pointB[0]&&pointA[1]==pointB[1])return 123456l;//当两点相等
        if(pointA[0]==pointB[0])return 999999l;//当两点直线x坐标 斜率无穷大
        long slope =  (long)(pointA[1]-pointB[1])* (pointA[0]-pointB[0]);
        return slope;
    }
    public static void main(String[]args){
//        int [][]points =  {{1,1},{1,1},{2,2},{2,2}};
        int [][]points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
//        int [][] points = {{0,0},{94911151,94911150},{94911152,94911151}};

        long startTime = System.currentTimeMillis();

        Solution149 ss = new Solution149();
        int res = ss.maxPoints(points);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
