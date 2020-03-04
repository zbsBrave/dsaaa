package letcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *	���õ�����
 *	�����������
 */
public class T994 {
	public static void main(String[] args) {
		int[][] s = {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println(new T994().orangesRotting(s));
	}
    class Node{
    	int x,y,minute;
    	public Node(int _x,int _y,int _minute){
    		x = _x;
    		y = _y;
    		minute = _minute;
    	}
    }
    public int orangesRotting(int[][] grid) {
    	int row = grid.length;
    	int col = grid[0].length;
    	int minute = 0;
    	Queue<Node> queue = new LinkedList<>();
    	//�ҳ����е�������
    	for(int i=0;i<row;i++) {
    		for(int j=0;j<col;j++) {
    			if(grid[i][j] ==2) queue.add(new Node(i, j, minute));
    		}
    	}
    	
    	int[][] tool = {{-1,0},{0,-1},{1,0},{0,1}}; //�����ж������ӵ���������
    	while(!queue.isEmpty()) {
    		Node poll = queue.poll();
    		minute = poll.minute;
    		for(int i=0;i<4;i++) {
    			int x = poll.x + tool[i][0];
    			int y = poll.y + tool[i][1];
    			if(x>=0 && x<row && y>=0 && y<col && grid[x][y]==1) {
    				grid[x][y] = 2;//���Ϊ����
    				queue.add(new Node(x, y, minute+1));
    			}
    		}
    	}
    	//����Ƿ�����������
    	for(int[] r:grid) {
    		for(int i:r) {
    			if(i==1) return -1;//�������������
    		}
    	}
    	return minute;
    }

}
