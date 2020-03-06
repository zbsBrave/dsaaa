package letcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 	����������
 *	��������	
 */
public class T57 {
    public int[][] findContinuousSequence(int target) {
    	List<int[]> list = new ArrayList<int[]>();
    	
    	int left=1,right=1,sum=0;
    	while(left <= target/2) {//��Ϊ( target/2 + (target+1)/2 ) > target, (ע��9/2=4,����Ҫ����=)
    		if(sum < target) {//�ұ߽細�����һ���
    			sum += right;
    			right ++;
    		}else if(sum > target) {//��߽細�����һ���
    			sum -= left;
    			left ++;
    		}else {//sum=target���ʱ����Ϊ��Ҫ��ֵ
    			int[] temp = new int[right - left];//����ҺϵĻ�������
    			for(int i = left; i<right ;i++) {
    				temp[i-left] = i;
    			}
    			list.add(temp);
    			//��߽������ƶ�
    			sum -= left;
    			left++;
    		}
    	}
    	
    	return list.toArray(new int[list.size()][]);
    }
}
