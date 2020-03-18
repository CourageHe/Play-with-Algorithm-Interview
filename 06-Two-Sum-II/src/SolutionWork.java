import java.util.HashSet;
import java.util.Set;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SolutionWork
 * @Description: leetCode 125 https://leetcode-cn.com/problems/valid-palindrome/submissions/
 *                        344 https://leetcode-cn.com/problems/reverse-string/submissions/
 *                        345 https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 *                        11 https://leetcode-cn.com/problems/container-with-most-water/
 *
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
        //      String str = "...,,";
        //        char [] chars = {'H','a','n','n','a','h'};
        //        String str =  "leetcode";
        int height[] = {1,8,6,2,5,4,8,3,7};
        long startTime = System.currentTimeMillis();

        SolutionWork s = new SolutionWork();
        int res = s.maxArea(height);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}