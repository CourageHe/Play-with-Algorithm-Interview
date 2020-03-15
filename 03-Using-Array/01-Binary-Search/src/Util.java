/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Util
 * @Description: 工具类，用于生成有序、无序数组
 * @Autor:CourageHe
 * @Date: 2020/3/15 15:27
 */
public class Util {

    private Util(){}

    /**
     * @param n 数组位数
     * @param rangeL 左边界
     * @param rangeR 右边界
     * @Description:用于生成无序数组
     * @return
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR){
        assert n > 0 && rangeL<=rangeR;

        Integer[] arr = new Integer[n];
        for(int i = 0;i < n;i++)
            arr[i] = (int)(Math.random()*(rangeR-rangeL))+rangeL;
        return arr;
    }

    /**
     *
     * @param n 数组位数
     * @Description:用于生成有序数组
     * @return
     */
    public static Integer[] generateOrderArray(int n){
        assert n > 0 ;

        Integer[] arr = new Integer[n];
        for(int i = 0;i < n;i++)
            arr[i] = i;
        return arr;
    }
}
