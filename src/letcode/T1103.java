package letcode;
/**
 *	���ǹ�2
 *	
 */
public class T1103 {
	public int[] distributeCandies(int candies, int num_people) {
		int[] arr = new int[num_people];
		int i=0;//���ǹ��Ĵ���
		while(candies >0) {
			if(i <= num_people) {//����һ���ǹ�
				arr[i] = Math.min(i+1, candies);
			}else {//�������ǹ�
				arr[i % num_people] += Math.min(i+1, candies);//i % num_people���Լ�������º��ӵ�����
			}
			candies -= Math.min(i+1, candies);
			i++;
		}
		
		return arr;
    }
	public static void main(String[] args) {
	}
}
