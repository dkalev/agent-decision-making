package MDP;

public class GridMaze {
	public static final int NUM_ROW = 6;
	public static final int NUM_COL = 6;
	public static final double DISCOUNT = 0.99;
	
	private static final double WHITE_REWARD = -0.04;
	private static final double GREEN_REWARD = +1.0;
	private static final double ORANGE_REWARD = -1.0;
	
	private static final double INTENDED_PROB = 0.8;
	private static final double RIGHT_ANGLE_PROB = 0.1;
	
	private State[][] grid;
	
	public GridMaze() {
		grid = new State[NUM_ROW][NUM_COL];
		buildOriginalMaze();
	}
	
	/**
	 * Generates the original GridMaze map
	 */
	private void buildOriginalMaze() {
		grid[0][0] = new State(GREEN_REWARD);
		grid[0][1] = new State(State.WALL);
		grid[0][2] = new State(GREEN_REWARD);
		grid[0][3] = new State(WHITE_REWARD);
		grid[0][4] = new State(WHITE_REWARD);
		grid[0][5] = new State(GREEN_REWARD);
		
		grid[1][0] = new State(WHITE_REWARD);
		grid[1][1] = new State(ORANGE_REWARD);
		grid[1][2] = new State(WHITE_REWARD);
		grid[1][3] = new State(GREEN_REWARD);
		grid[1][4] = new State(State.WALL);
		grid[1][5] = new State(ORANGE_REWARD);
		
		grid[2][0] = new State(WHITE_REWARD);
		grid[2][1] = new State(WHITE_REWARD);
		grid[2][2] = new State(ORANGE_REWARD);
		grid[2][3] = new State(WHITE_REWARD);
		grid[2][4] = new State(GREEN_REWARD);
		grid[2][5] = new State(WHITE_REWARD);
		
		grid[3][0] = new State(WHITE_REWARD);
		grid[3][1] = new State(WHITE_REWARD);
		grid[3][2] = new State(WHITE_REWARD);
		grid[3][3] = new State(ORANGE_REWARD);
		grid[3][4] = new State(WHITE_REWARD);
		grid[3][5] = new State(GREEN_REWARD);
		
		grid[4][0] = new State(WHITE_REWARD);
		grid[4][1] = new State(State.WALL);
		grid[4][2] = new State(State.WALL);
		grid[4][3] = new State(State.WALL);
		grid[4][4] = new State(ORANGE_REWARD);
		grid[4][5] = new State(WHITE_REWARD);
		
		grid[5][0] = new State(WHITE_REWARD);
		grid[5][1] = new State(WHITE_REWARD);
		grid[5][2] = new State(WHITE_REWARD);
		grid[5][3] = new State(WHITE_REWARD);
		grid[5][4] = new State(WHITE_REWARD);
		grid[5][5] = new State(WHITE_REWARD);
	}
	
	public State[][] getGridMaze(){
		return grid;
	}
	/**
	 * Calculates the utility of given state and a given action
	 * @param row
	 * @param col
	 * @param action
	 * @param curUtils - the current utilities of all states
	 * @return utility of the action
	 */
	public double calcUtility(int row, int col, Action action, double[][] curUtils) {
		double util = 0.0;
		switch (action) {
			case UP:
				if (row - 1 >= 0 && !grid[row-1][col].isWall()) {
					util += curUtils[row-1][col]*INTENDED_PROB;
				}else {
					util += curUtils[row][col]*INTENDED_PROB;
				}
				if(col - 1 >= 0 && !grid[row][col-1].isWall()) {
					util += curUtils[row][col-1]*RIGHT_ANGLE_PROB;
				}else {
					util += curUtils[row][col]*RIGHT_ANGLE_PROB;
				}
				if(col + 1 < GridMaze.NUM_COL && !grid[row][col+1].isWall()) {
					util +=curUtils[row][col+1]*RIGHT_ANGLE_PROB;
				}else {
					util += curUtils[row][col]*RIGHT_ANGLE_PROB;
				}
				break;
			case DOWN:
				if (row + 1 < GridMaze.NUM_ROW && !grid[row+1][col].isWall()) {
					util += curUtils[row+1][col]*INTENDED_PROB;
				}else {
					util += curUtils[row][col]*INTENDED_PROB;
				}
				if(col - 1 >= 0 && !grid[row][col-1].isWall()) {
					util += curUtils[row][col-1]*RIGHT_ANGLE_PROB;
				}else {
					util += curUtils[row][col]*RIGHT_ANGLE_PROB;
				}
				if(col + 1 < GridMaze.NUM_COL && !grid[row][col+1].isWall()) {
					util +=curUtils[row][col+1]*RIGHT_ANGLE_PROB;
				}else {
					util += curUtils[row][col]*RIGHT_ANGLE_PROB;
				}
				break;
			case LEFT:
				if (col - 1 >= 0 && !grid[row][col-1].isWall()) {
					util += curUtils[row][col-1]*INTENDED_PROB;
				}else {
					util += curUtils[row][col]*INTENDED_PROB;
				}
				if(row - 1 >= 0 && !grid[row-1][col].isWall()) {
					util += curUtils[row-1][col]*RIGHT_ANGLE_PROB;
				}else {
					util += curUtils[row][col]*RIGHT_ANGLE_PROB;
				}
				if(row + 1 < GridMaze.NUM_ROW && !grid[row+1][col].isWall()) {
					util +=curUtils[row+1][col]*RIGHT_ANGLE_PROB;
				}else {
					util += curUtils[row][col]*RIGHT_ANGLE_PROB;
				}
				break;
			case RIGHT:
				if (col + 1 < GridMaze.NUM_COL && !grid[row][col+1].isWall()) {
					util += curUtils[row][col+1]*INTENDED_PROB;
				}else {
					util += curUtils[row][col]*INTENDED_PROB;
				}
				if(row - 1 >= 0 && !grid[row-1][col].isWall()) {
					util += curUtils[row-1][col]*RIGHT_ANGLE_PROB;
				}else {
					util += curUtils[row][col]*RIGHT_ANGLE_PROB;
				}
				if(row + 1 < GridMaze.NUM_ROW && !grid[row+1][col].isWall()) {
					util +=curUtils[row+1][col]*RIGHT_ANGLE_PROB;
				}else {
					util += curUtils[row][col]*RIGHT_ANGLE_PROB;
				}
				break;
		}
			
		return util;
	}
}
