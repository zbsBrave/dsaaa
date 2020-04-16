package letcode.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zbs
 * 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class Day56 {
    public int[][] merge(int[][] intervals) {
    	if(intervals==null || intervals.length<2) return intervals;
    	//先按照左断点排序
    	Arrays.sort(intervals, Comparator.comparingInt(s->s[0]));
    	//便利，如果s0的左断点 >= s1的右端点，则可以判断重合
    	List<int[]> temp = new ArrayList<int[]>();
    	temp.add(intervals[0]);
    	for(int i=1;i<intervals.length;i++) {
    		int[] cur = intervals[i];//当前节点
    		int[] pre = temp.get(temp.size()-1);//前一个结点
    		if(pre[1] >= cur[0]) {//重合
    			pre[1] = Math.max(pre[1], cur[1]);
    		}else {
    			temp.add(cur);
    		}
    		
    	}
    	return temp.toArray(new int[temp.size()][]);
    }
}
