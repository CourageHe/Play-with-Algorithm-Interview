import java.util.HashSet;
import java.util.Set;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SolutionWork
 * @Description: leetCode 344 https://leetcode-cn.com/problems/reverse-string/submissions/
 *
 * @Autor:CourageHe
 * @Date: 2020/3/18 22:33
 */

public  class SolutionWork2 {

    //344 双指针法 之对撞指针
    public void reverseString(char[] s) {
        int i =0,j = s.length-1;
        while(i <= j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;j--;
        }

    }


    public static void main(String[]args){
                char [] chars = {'H','a','n','n','a','h'};
        long startTime = System.currentTimeMillis();

        SolutionWork2 s = new SolutionWork2();
        s.reverseString(chars);

        long endTime = System.currentTimeMillis();
//        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}