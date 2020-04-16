package letcode.day;

/**
 * 机器人的运动范围
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class Day13 {
    public int movingCount(int m, int n, int k) {
    	boolean[][] bool = new boolean[m][n];//初始值false
    	int count = 0;
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(i==0 || j==0) {
    				bool[i][j] = check(i, j, k);
    				if(bool[i][j]) {
    					count++;
    					break;
    				}
    			}else {
    				bool[i][j] = check(i, j, k) && (bool[i-1][j] || bool[i][j-1]);
				}
    			if(bool[i][j]) count++;
    		}
    	}
    	return count;
    }
    //判断行坐标和列坐标的数位之和是否大于k的格子，是：返回false
    public boolean check(int x,int y,int k) {
    	int total = 0;
    	while(x>0 || y>0) {
    		total += x%10 + y%10;
    		x = x/10;
    		y = y/10;
    	}
    	if(total > k) return false;
    	return true;
    }
    public static void main(String[] args) {
		System.out.println(new Day13().movingCount(38, 15, 9));
		//System.out.println(new Day13().movingCount(38, 15, 9));
	}
}
