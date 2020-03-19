import java.util.HashSet;
import java.util.Set;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SolutionWork
 * @Description: leetCode 125 https://leetcode-cn.com/problems/valid-palindrome/submissions/
 * @Autor:CourageHe
 * @Date: 2020/3/18 22:33
 */

public  class SolutionWork {
    //125双指针法 之对撞指针
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char left = ' ', right = ' ';
        while (i <= j) {
            left = s.charAt(i);
            right = s.charAt(j);
            if (!Character.isLetterOrDigit(left)){
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(right)){
                j--;
                continue;
            }
            if (Character.toUpperCase(left) != Character.toUpperCase(right))
                return false;
            i++;j--;
        }
        return true;
    }

    //过滤
    public boolean isPalindrome2(String s) {

        StringBuilder builder = new StringBuilder();

        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c))
                builder.append(c);
        }
        return builder.toString().equalsIgnoreCase(builder.reverse().toString());
    }

    public static void main(String[]args){
        String str = "...,,";
        int height[] = {1,8,6,2,5,4,8,3,7};
        long startTime = System.currentTimeMillis();

        SolutionWork s = new SolutionWork();
        boolean res = s.isPalindrome(str);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}