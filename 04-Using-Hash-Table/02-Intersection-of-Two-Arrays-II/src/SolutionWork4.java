import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SolutionWork
 * @Description: leetcode 205 https://leetcode-cn.com/problems/isomorphic-strings/
 * @Autor:CourageHe
 * @Date: 2020/3/25 14:37
 */
public class SolutionWork4 {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())return false;
        Map<Character,Character>map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char key = s.charAt(i);
            char value = t.charAt(i);
            //存在该key
            if(map.containsKey(key)){
                if(!map.get(key).equals(value))return false;
            }
            //不存再改key
            else{

                //该value存在却对应不同key值
                if(map.containsValue(value))return false;
                //key value 都不存在 则存入map中
                map.put(key,value);
            }
        }
        return true;
    }

    public static void main(String[]args){
        String s = "egg";
        String t = "add";

        long startTime = System.currentTimeMillis();

        SolutionWork4 ss = new SolutionWork4();
        boolean res = ss.isIsomorphic(s,t);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
