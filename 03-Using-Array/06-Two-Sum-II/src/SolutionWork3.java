import java.util.HashSet;
import java.util.Set;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SolutionWork
 * @Description: leetCode 345 https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 *
 * @Autor:CourageHe
 * @Date: 2020/3/18 22:33
 */

public  class SolutionWork3 {


    //345
    public String reverseVowels(String s) {
        StringBuilder builder = new StringBuilder(s);
        int i =0,j = s.length()-1;
        char left = ' ', right = ' ';
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        while(i <= j){
            left = s.charAt(i);
            right = s.charAt(j);
            if(!set.contains(left )){
                i++;
                continue;
            }
            if(!set.contains(right)){
                j--;
                continue;
            }
            builder.setCharAt(i,right);
            builder.setCharAt(j,left);
            i++;j--;

        }

        return builder.toString();
    }


    public static void main(String[]args){
        String str =  "leetcode";
        long startTime = System.currentTimeMillis();

        SolutionWork3 s = new SolutionWork3();
        String res = s.reverseVowels(str);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}