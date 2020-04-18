package letcode.day;

/**
 * @author zbs
 *	ʢ���ˮ������
 *	https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Day11 {
    public int maxArea(int[] height) {
		int max = 0, i = 0, j = height.length-1;
		while(i < j) {
			max = Math.max(max, Math.min(height[i], height[j])*(j-i));
			if(height[i] < height[j]) {
				i++;
			}else {
				j--;
			}
		}
		return max;
    }
}
