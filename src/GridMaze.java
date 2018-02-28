
public class GridMaze {
	public static final int NUM_ROW = 6;
	public static final int NUM_COL = 6;
	
	private static final double WHITE_REWARD = -0.04;
	private static final double GREEN_REWARD = +1.0;
	private static final double ORANGE_REWARD = -1.0;
	
	private State[][] grid;
	
	public GridMaze() {
		grid = new State[NUM_ROW][NUM_COL];
		buildOriginalMaze();
	}
	
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
	
	public void displayGridMaze() {
		for(int row = 0; row < NUM_ROW; row++) {
			System.out.print("|");
			for(int col = 0; col < NUM_COL; col++) {
				double cur = grid[row][col].getReward();
				if (cur >= 0)
					System.out.format("  %.2f |", cur);
				else
					System.out.format(" %.2f |", cur);
			}
			System.out.println();
		}
	}
}
