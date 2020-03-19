/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description:    leetcode 3 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Autor:CourageHe
 * @Date: 2020/3/19 16:33
 */
public class Solution {

    //双指针法 之窗口法
    public int lengthOfLongestSubstring(String s) {
        int l =0,r=0;
        int max = 0;
        while (r<s.length()){
            char pointer = s.charAt(r);
            if(r <= s.indexOf(pointer,l)){
                max =Math.max(max , r-l+1);
                r++;
            }else{
                l= s.indexOf(pointer,l)+1;
            }
        }
        return max;
    }

    //优化 不使用字符串自带的查找函数
    public int lengthOfLongestSubstring2(String s) {
        int l =0,r=0;//滑动窗口为[l,r)
        int max = 0;
        int freq[] = new int[256];
        while (r<s.length()){
            char pointerR = s.charAt(r);
            char pointerL = s.charAt(l);
            if(freq[pointerR]==0){
                max =Math.max(max , r-l+1);
                freq[pointerR]++;
                r++;
            }else{
                freq[pointerL]--;
                l++;
            }
        }
        return max;
    }


    public static void main(String[]args){
        String str = "pwwkew";
        long startTime = System.currentTimeMillis();

        Solution s = new Solution();
        int res = s.lengthOfLongestSubstring2(str);
        System.out.println("Result："+res);
        long endTime = System.currentTimeMillis();
        System.out.println("Longest-Substring-Without-Repeating-Characters run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");

    }
}
