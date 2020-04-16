package letcode.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zbs
 * �ϲ�����
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class Day56 {
    public int[][] merge(int[][] intervals) {
    	if(intervals==null || intervals.length<2) return intervals;
    	//�Ȱ�����ϵ�����
    	Arrays.sort(intervals, Comparator.comparingInt(s->s[0]));
    	//���������s0����ϵ� >= s1���Ҷ˵㣬������ж��غ�
    	List<int[]> temp = new ArrayList<int[]>();
    	temp.add(intervals[0]);
    	for(int i=1;i<intervals.length;i++) {
    		int[] cur = intervals[i];//��ǰ�ڵ�
    		int[] pre = temp.get(temp.size()-1);//ǰһ�����
    		if(pre[1] >= cur[0]) {//�غ�
    			pre[1] = Math.max(pre[1], cur[1]);
    		}else {
    			temp.add(cur);
    		}
    		
    	}
    	return temp.toArray(new int[temp.size()][]);
    }
}
