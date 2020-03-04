package codingAlgorithm;
/**
 *找出重复数字
 *长度为n的数组，数字范围在0~n-1
 *page39
 */
public class 重复数字_2 {
	public static void main(String[] args) {
		int[] s = {1,2,0,3,0,1};
		System.out.println(duplicate(s));
	}
	public static boolean duplicate(int[] numbers) {
		if(numbers==null) return false;
		int temp = 0;
		for(int i=0;i<numbers.length;i++) {
			while(numbers[i] != i) {
				temp = numbers[i];
				System.out.println(i);
				if(numbers[i] == numbers[temp]) return true;
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}
		return false;
	}
}
