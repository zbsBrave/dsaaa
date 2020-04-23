package letcode.day;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zbs
 * 	 ͳ�ơ����������项
 *	 https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 *	 �о������û�������
 */
public class Day1248 {
    public int numberOfSubarrays(int[] nums, int k) {
    	int count =0;
    	ArrayList<Integer> list = new ArrayList<Integer>();//�洢����������
    	//list��ʼ��ʱ��Ҫ���� list[0]ǰ���ж���ż����list[length-1]�����ж���ż��
    	//����list��ʼ��ʱ��Ҫ����nums����� ͷ����0�� β����n(nums.length-1)
    	//������������Ҳ�������棬����list��ó�ʼ��Ϊ0-1  n(nums.length-1)+1
    	list.add(-1);
    	for(int i=0;i<nums.length;i++) {
    		if(nums[i]%2 != 0) list.add(i);
    	}
    	list.add(nums.length);
    	//list��ͷ��β��������������Ϊ�˷����ʼ���ģ�����Ӧ�ô�1��ʼ��
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
