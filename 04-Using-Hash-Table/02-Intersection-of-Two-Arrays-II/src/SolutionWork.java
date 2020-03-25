import org.omg.CORBA.INTERNAL;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SolutionWork
 * @Description: leetcode 202 https://leetcode-cn.com/problems/happy-number/
 * @Autor:CourageHe
 * @Date: 2020/3/25 14:37
 */
public class SolutionWork {
    public boolean isHappy(int n) {
        int counter =0;
        while(counter<20){
            int sum =0;
            while (n!= 0){
                sum +=(n%10)*(n%10);
                n=n/10;
            }
            n = sum;
            counter++;
            if(n == 1){
                return true;
            }
        }
        return  false;
    }

    public static void main(String[]args){
        long startTime = System.currentTimeMillis();

        SolutionWork ss = new SolutionWork();
        boolean res = ss.isHappy(15);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
