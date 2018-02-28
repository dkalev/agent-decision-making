
public class StateTransition {
	
	private static final double INTENDED_PROB = 0.8;
	private static final double RIGHT_ANGLE_PROB = 0.1;

	public static double nextState(int row, int col, Action action, GridMaze gridMaze) {
		double util = 0.0;
		State[][] grid = gridMaze.getGridMaze();
		switch (action) {
			case UP:
				if (row - 1 >= 0)
					util += grid[row-1][col].getReward()*INTENDED_PROB;
				if(col - 1 >= 0)
					util += grid[row][col-1].getReward()*RIGHT_ANGLE_PROB;
				if(col + 1 < GridMaze.NUM_COL)
					util +=grid[row][col+1].getReward()*RIGHT_ANGLE_PROB;
				break;
			case DOWN:
				if (row + 1 < GridMaze.NUM_ROW)
					util += grid[row+1][col].getReward()*INTENDED_PROB;
				if(col - 1 >= 0)
					util += grid[row][col-1].getReward()*RIGHT_ANGLE_PROB;
				if(col + 1 < GridMaze.NUM_COL)
					util +=grid[row][col+1].getReward()*RIGHT_ANGLE_PROB;
				break;
			case LEFT:
				if (col - 1 >= 0)
					util += grid[row][col-1].getReward()*INTENDED_PROB;
				if(row - 1 >= 0)
					util += grid[row-1][col].getReward()*RIGHT_ANGLE_PROB;
				if(row + 1 < GridMaze.NUM_ROW)
					util +=grid[row+1][col].getReward()*RIGHT_ANGLE_PROB;
				break;
			case RIGHT:
				if (col + 1 < GridMaze.NUM_COL)
					util += grid[row][col+1].getReward()*INTENDED_PROB;
				if(row - 1 >= 0)
					util += grid[row-1][col].getReward()*RIGHT_ANGLE_PROB;
				if(row + 1 < GridMaze.NUM_ROW)
					util +=grid[row+1][col].getReward()*RIGHT_ANGLE_PROB;
				break;
		}
			
		return util;
		
	}
	
}
