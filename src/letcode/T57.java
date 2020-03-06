package letcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 	连续正整数
 *	滑动窗口	
 */
public class T57 {
    public int[][] findContinuousSequence(int target) {
    	List<int[]> list = new ArrayList<int[]>();
    	
    	int left=1,right=1,sum=0;
    	while(left <= target/2) {//因为( target/2 + (target+1)/2 ) > target, (注意9/2=4,所以要加上=)
    		if(sum < target) {//右边界窗口向右滑动
    			sum += right;
    			right ++;
    		}else if(sum > target) {//左边界窗口向右滑动
    			sum -= left;
    			left ++;
    		}else {//sum=target相等时，即为所要的值
    			int[] temp = new int[right - left];//左闭右合的滑动窗口
    			for(int i = left; i<right ;i++) {
    				temp[i-left] = i;
    			}
    			list.add(temp);
    			//左边界向右移动
    			sum -= left;
    			left++;
    		}
    	}
    	
    	return list.toArray(new int[list.size()][]);
    }
}
