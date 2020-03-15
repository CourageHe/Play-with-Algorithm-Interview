import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:BinarySearcch
 * @Description:
 * @Autor:CourageHe
 * @Date: 2020/3/15 15:26
 */
public class BinarySearcch {

    private  BinarySearcch(){}

    public static int binarySearch(Comparable[]arr,int n,Comparable target){
        int l = 0,r=n-1;//在[l……r]的范围里寻找target
        while(l <= r){//当 l > r 时，区间[l……r]是无效的
            int mid = l+(r - l)/2;//防止整形溢出
            if(target.compareTo(arr[mid]) == 0)
                return mid;
            if(target.compareTo(arr[mid]) > 0 )
                l = mid + 1;//target在[mid+1……r]中
            else//target < arr[mid]
                r = mid - 1;//target在[l……mid-1]中
        }

        return -1;
    }
    public static void main(String[]args){
        int n = (int) Math.pow(10,7);
        Integer data[] = Util.generateOrderArray(n);

        long startTime = System.currentTimeMillis();
        for(int i = 0;i < n;i++){
            if(i !=binarySearch(data,n,i))
                throw new IllegalStateException("find i failed!!!");
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Binary Seasrch test complete");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");

    }
}
