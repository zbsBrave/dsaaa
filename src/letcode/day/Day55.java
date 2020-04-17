package letcode.day;

/**
 * @author zbs
 *	跳跃游戏
 *	https://leetcode-cn.com/problems/jump-game/
 */
public class Day55 {
    public boolean canJump(int[] nums) {
    	int max=nums[0],len=nums.length;
    	for(int i=0;i<len;i++) {
    		if(i > max) return false;//i 不可达
    		int cur = i + nums[i];
    		max = Math.max(max, cur);
    		if(max >= len-1) return true;
    	}
    	return false;
    }
}
