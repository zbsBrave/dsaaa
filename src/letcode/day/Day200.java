package letcode.day;

/**
 * @author zbs
 *	��������
 *	https://leetcode-cn.com/problems/number-of-islands/ 
 *	�����������,�����������
 */
public class Day200 {
	//�����������dfs
    public int dfs0(char[][] grid) {
    	int islands = 0;
    	for(int r=0;r<grid.length;r++) {
    		for(int c=0;c<grid[0].length;c++) {
    			if(grid[r][c] == '1') {
    				islands++;
    				dfs(grid, r, c);
    			}
    		}
    	}
    	return islands;
    }
    public void dfs(char[][] grid,int r,int c) {
    	//Խ�� ���� =0
    	if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]=='0') {
    		return;
    	}
    	grid[r][c] = '0';
    	dfs(grid, r-1, c);
    	dfs(grid, r, c+1);
    	dfs(grid, r+1, c);
    	dfs(grid, r, c-1);
    }
}
