import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SolutionWork
 * @Description: leetcode 242 https://leetcode-cn.com/problems/valid-anagram/
 * @Autor:CourageHe
 * @Date: 2020/3/25 14:37
 */
public class SolutionWork2 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        List<Character> list =new ArrayList<Character>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            list.add(c);
        }
        for(int i = 0;i<t.length();i++){
            char c = t.charAt(i);
            if(list.contains(c)) {
                list.remove((Object) c);
            }
        }
        return list.isEmpty();
    }

    public static void main(String[]args){
        String s = "rat";
        String t = "car";

        long startTime = System.currentTimeMillis();

        SolutionWork2 ss = new SolutionWork2();
        boolean res = ss.isAnagram(s,t);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
