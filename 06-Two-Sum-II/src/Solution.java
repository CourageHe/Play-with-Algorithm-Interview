/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: leetcode 167 https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @Autor:CourageHe
 * @Date: 2020/3/18 16:29
 */
public class Solution {

    //暴力解法 超时
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i = 0;i<numbers.length;i++){
            res[0]=i+1;
            int another = target -numbers[i];
            for(int j = 0;j<numbers.length;j++) {
                if(another == numbers[j] &&i!=j) {
                    res[1] = j + 1;
                    return res;
                }
            }
        }
        return res;
    }

    int[] res = new int[2];
    //结合二分查找法
    public int[] twoSum2(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            int another = target - numbers[i];
            int state = binarySearch(numbers,i,numbers.length-1,another);
            res[0] = i+1;
            if(state != -1){
                res[1] = state +1;
                return  res;
            }
        }
        return res;
    }
    //在numbers数组中 [left……right]中寻找another值坐标
    public int binarySearch(int[] numbers,int left,int right,int another){
        int mid = left + (right -left)/2;
        if(left<=right){
        if(numbers[mid] == another&&mid != res[0])//排除第一个数
            return mid;
        if(numbers[mid]>another)
            return binarySearch(numbers,left,mid-1,another);
        else if(numbers[mid]<=another)
            return binarySearch(numbers,mid+1,right,another);
    }
        return -1;
}



    //双指针法 之对撞指针
    public int[] twoSum3(int[] numbers, int target) {
        int res[] = new int[2];
        int i = 0, j = numbers.length - 1;
        while ((numbers[i] + numbers[j]) != target) {
            if ((numbers[i] + numbers[j]) > target)
                j--;
            if ((numbers[i] + numbers[j]) < target)
                i++;
        }
        res[0] = i+1;
        res[1] = j+1;
        return res;
    }

    public static void main(String[]args){
        int nums[] = {1,2,3,4,4,9,56,90};


        long startTime = System.currentTimeMillis();

        Solution s = new Solution();
        int[] res = s.twoSum3(nums,8);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res[0]+","+res[1]);
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
