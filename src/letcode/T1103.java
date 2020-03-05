package letcode;
/**
 *	分糖果2
 *	
 */
public class T1103 {
	public int[] distributeCandies(int candies, int num_people) {
		int[] arr = new int[num_people];
		int i=0;//发糖果的次数
		while(candies >0) {
			if(i <= num_people) {//发第一轮糖果
				arr[i] = Math.min(i+1, candies);
			}else {//发多轮糖果
				arr[i % num_people] += Math.min(i+1, candies);//i % num_people可以计算多轮下孩子的坐标
			}
			candies -= Math.min(i+1, candies);
			i++;
		}
		
		return arr;
    }
	public static void main(String[] args) {
	}
}
