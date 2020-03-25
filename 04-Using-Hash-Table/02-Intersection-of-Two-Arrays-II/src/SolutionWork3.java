import kotlin.ranges.CharRange;
import sun.nio.cs.FastCharsetProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SolutionWork
 * @Description: leetcode 290 https://leetcode-cn.com/problems/word-pattern/
 * @Autor:CourageHe
 * @Date: 2020/3/25 14:37
 */
public class SolutionWork3 {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null) return false;
        String [] sources = str.split(" ");
        if(sources.length!= pattern.length())return false;

        Map<Character,String> map = new HashMap<>();
        for(int i = 0 ;i<pattern.length();i++){
            char key= pattern.charAt(i);
            //若map中存在 c
            if(map.containsKey(key)){
                if (!map.get(key).equals(sources[i]))return false;
            }
            //若map中不存在key
            else{
                //若map中存在 value 对应的key却不同
                if(map.containsValue(sources[i]))return false;
                //若map中不存在就加入
                map.put(key,sources[i]);
            }
        }
        return true;
    }

    public static void main(String[]args){
        String pattern = "abba";
        String str = "dog cat cat dog";

        long startTime = System.currentTimeMillis();

        SolutionWork3 ss = new SolutionWork3();
        boolean res = ss.wordPattern(pattern,str);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
