import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SolutionWork
 * @Description: leetcode 438 https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * @Autor:CourageHe
 * @Date: 2020/3/19 20:58
 */
public class SolutionWork {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length() < p.length())return list;
        int l=0,r=-1;//[l……r]为固定窗口
        int freq_p[] = new int[26];//Ascii码频率数组
        int freq_s[] = new int[26];//Ascii码频率数组
        for(char ch : p.toCharArray()){//将两数组初始化，并将r移至p字符串长度
            freq_p[ch-'a']++;
            freq_s[s.charAt(++r)-'a']++;
        }
        if(Arrays.equals(freq_s,freq_p))
            list.add(l);
        //固定窗口 并移动比较l
        while(r<s.length()-1){
            freq_s[s.charAt(++r)-'a']++;
            freq_s[s.charAt(l++)-'a']--;
            if(Arrays.equals(freq_s,freq_p))
                list.add(l);

        }

        return list;
    }

    public static void main(String[]args){
        String s = "abab";
        String p = "ab";
        long startTime = System.currentTimeMillis();

        SolutionWork ss = new SolutionWork();
        List<Integer> list = ss.findAnagrams(s,p);

        System.out.println("Result："+list);
        long endTime = System.currentTimeMillis();
        System.out.println("Longest-Substring-Without-Repeating-Characters run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");

    }
}
