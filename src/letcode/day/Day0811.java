package letcode.day;

/**
 * @author zbs
 *	Ӳ�� 1,5,10,25
 *	https://leetcode-cn.com/problems/coin-lcci/
 *	dp[j] ��������ֵj�ķ�������
 *	���Ӳ��ȫ��Ϊ1 ��dp[j]=1
 *	���Ӳ��ȫ��Ϊ1 ��5�� dp[j] = (Ӳ��ȫΪ1)dp[j] + (Ӳ��Ϊ1��5)dp[j]
 *		(Ӳ��Ϊ1��5)dp[j],����Ҫ��һ��5(��Ȼ����Ӳ��ȫΪ1��),��������Ҫ�����ʵ������ֵj-5�ж����ֽ⣬��dp[j-5]
 *	������
 *	�Դ����ƣ����ǾͿ��Եõ�1��5��10��25���ֻ������j�Ľ�
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
    			//������������һЩ
    			//����:��i=1����Ӳ��Ϊ5
    			//	  dp[j](i=1ʱ�Ľ�) = dp[j](������ʵ��i=0ʱ�Ľ�) + dp[j-coins[i]];
    			dp[j] = (j-coins[i] < 0) ? dp[j] : (dp[j] + dp[j-coins[i]])%1000000007;
    		}
    	}
    	return dp[n];
    }
    public static void main(String[] args) {
		System.out.println(new Day0811().waysToChange(10));
	}
}
