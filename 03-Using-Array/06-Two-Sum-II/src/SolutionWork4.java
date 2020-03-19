import java.util.HashSet;
import java.util.Set;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SolutionWork
 * @Description: leetCode 11 https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @Autor:CourageHe
 * @Date: 2020/3/18 22:33
 */

public  class SolutionWork4 {
    //11
    public int maxArea(int[] height) {
        int i =0,j = height.length-1;
        int h= 0,max = 0;
        while(i <= j){
            h = height[i]>height[j]?height[j]:height[i];
            int result = h*(j-i);
            max = max>result?max:result;

            if( height[i]>height[j])
                j--;
            else
                i++;
        }

        return max;
    }
    public static void main(String[]args){
        int height[] = {1,8,6,2,5,4,8,3,7};
        long startTime = System.currentTimeMillis();

        SolutionWork4 s = new SolutionWork4();
        int res = s.maxArea(height);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}