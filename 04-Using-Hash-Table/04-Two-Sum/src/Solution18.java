import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SolutionWork2
 * @Description: leetcode 18 https://leetcode-cn.com/problems/4sum/
 * @Autor:CourageHe
 * @Date: 2020/3/27 17:01
 */
public class Solution18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {

            if (target >= 0 && nums[i] > target) break;//优化 如果大于目标值 后面没有计算的必要
            if (i > 0 && nums[i] == nums[i - 1]) continue;//去重
            int newtarget = target - nums[i];

            for (int j = i + 1; j < nums.length - 2; j++) {

                if (newtarget >= 0 && nums[j] > newtarget) break;//优化 如果大于目标值 后面没有计算的必要
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;//去重
                int newtarget2 = newtarget - nums[j];

                int l = j + 1, r = nums.length - 1;

                while (l < r) {
                    if (nums[r] + nums[l] == newtarget2) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);
                        while (l < r && nums[l] == nums[l + 1]) l++;//去重
                        while (l < r && nums[r] == nums[r - 1]) r--;//去重

                        r--;
                        l++;
                    } else if (nums[r] + nums[l] < newtarget2) {
                        while (l < r && nums[l] == nums[l + 1]) l++;//去重
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;//去重
                        r--;
                    }
                }
            }

        }
        return res;
    }

    public static void main(String[]args){
//        int nums[] = {1, 0, -1, 0, -2, 2};
//        int nums[]={0,0,0,0};
//        int nums[]={-5,-4,-3,-2,-1,0,0,1,2,3,4,5};
//        int target = 0;

        int nums[]={1,-2,-5,-4,-3,3,3,5};
        int target = -11;

        long startTime = System.currentTimeMillis();

        Solution18 s = new Solution18();
        List<List<Integer>> res = s.fourSum(nums, target);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Solution run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
