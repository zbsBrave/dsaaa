package letcode.day;

import java.util.Stack;

/**
 * @author zbs
   *    两数相加 II
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class Day445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	Stack<ListNode> stack1 = new Stack<ListNode>();
    	Stack<ListNode> stack2 = new Stack<ListNode>();
    	ListNode temp = l1;
    	while (temp!=null) {
			stack1.push(temp);
			temp = temp.next;
		}
    	temp = l2;
    	while (temp!=null) {
    		stack2.push(temp);
    		temp = temp.next;
    	}
    	int remainder = 0;//余数
    	while (!stack1.isEmpty() || !stack2.isEmpty() || remainder!=0) {
			int v1 = stack1.isEmpty()?0:stack1.pop().val;
			int v2 = stack2.isEmpty()?0:stack2.pop().val;
			int count = v1 + v2 + remainder;
			remainder = count/10;
			ListNode cur = new ListNode(count%10);
			if(temp==null) {
				temp = cur;
			}else {
				cur.next = temp;
				temp = cur;
			}
		}
    	return temp;
    }
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
