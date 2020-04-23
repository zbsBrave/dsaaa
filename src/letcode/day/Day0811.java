package letcode.day;

/**
 * @author zbs
 *	硬币 1,5,10,25
 *	https://leetcode-cn.com/problems/coin-lcci/
 *	dp[j] 代表总面值j的方案数量
 *	如果硬币全部为1 ，dp[j]=1
 *	如果硬币全部为1 、5， dp[j] = (硬币全为1)dp[j] + (硬币为1，5)dp[j]
 *		(硬币为1，5)dp[j],至少要有一个5(不然就是硬币全为1了),所以我们要求的其实是总面值j-5有多少种解，即dp[j-5]
 *	。。。
 *	以此类推，我们就可以得到1，5，10，25四种货币组成j的解
 */
public class Day0811 {
    public int waysToChange(int n) {
    	int[] coins = {1,5,10,25};
    	int[] dp = new int[n+1];
    	for(int i=0;i<coins.length;i++) {
    		for(int j=0;j<=n;j++) {
    			if(i==0) {
    				dp[j] = 1;
    				continue;
    			}
    			//这里可能难理解一些
    			//举例:当i=1，即硬币为5
    			//	  dp[j](i=1时的解) = dp[j](这里其实是i=0时的解) + dp[j-coins[i]];
    			dp[j] = (j-coins[i] < 0) ? dp[j] : (dp[j] + dp[j-coins[i]])%1000000007;
    		}
    	}
    	return dp[n];
    }
    public static void main(String[] args) {
		System.out.println(new Day0811().waysToChange(10));
	}
}
