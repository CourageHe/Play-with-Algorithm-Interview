import sun.security.x509.AttributeNameEnumeration;

import java.util.*;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution49
 * @Description: leetcode 49 https://leetcode-cn.com/problems/group-anagrams/
 * @Autor:CourageHe
 * @Date: 2020/3/30 16:43
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res= new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[]chs = str.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if(!map.containsKey(key)) map.put(key,new ArrayList<String>());
            map.get(key).add(str);
        }

        return new ArrayList(map.values());
    }

    public static void main(String[]args){
        String[]strs = { "eat", "tea", "tan", "ate", "nat", "bat"};
        long startTime = System.currentTimeMillis();

        Solution49 ss = new Solution49();
        List<List<String>> res = ss.groupAnagrams(strs);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
