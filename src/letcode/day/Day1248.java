package letcode.day;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zbs
 * 	 统计「优美子数组」
 *	 https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 *	 感觉可以用滑动窗口
 */
public class Day1248 {
    public int numberOfSubarrays(int[] nums, int k) {
    	int count =0;
    	ArrayList<Integer> list = new ArrayList<Integer>();//存储奇数的索引
    	//list初始化时需要考虑 list[0]前面有多少偶数，list[length-1]后面有多少偶数
    	//所以list初始化时需要加入nums数组的 头索引0和 尾索引n(nums.length-1)
    	//由于奇数本身也算在里面，所以list最好初始化为0-1  n(nums.length-1)+1
    	list.add(-1);
    	for(int i=0;i<nums.length;i++) {
    		if(nums[i]%2 != 0) list.add(i);
    	}
    	list.add(nums.length);
    	//list的头和尾不是奇数，而是为了方便初始化的，所以应该从1开始算
    	for(int i=1;i+k<list.size();i++) {
    		count += ( list.get(i) - list.get(i-1) ) * ( list.get(i+k) - list.get(i+k-1) );
    	}
    	return count;
    }
    public static void main(String[] args) {
		int[] nums = {2,2,2,1,2,2,1,2,2,2};
		System.out.println(new Day1248().numberOfSubarrays(nums, 3));
	}
}
