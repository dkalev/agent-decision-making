package utils;
import MDP.GridMaze;
import MDP.Policy;
import MDP.State;

public class DisplayUtil {
	
	/**
	 * Prints the GridMaze in the console
	 * @param gridMaze
	 */
	public static void displayGridMaze(GridMaze gridMaze) {
		State[][] grid = gridMaze.getGridMaze();
		
		
		StringBuilder builder = new StringBuilder();

		drawBorder(builder, GridMaze.NUM_COL, 8);
		
		for(int row = 0; row < GridMaze.NUM_ROW; row++) {
			builder.append("|");
			for(int col = 0; col < GridMaze.NUM_COL; col++) {
				if(grid[row][col].isWall()) {
					builder.append("  WALL  |");
				} else if (grid[row][col].getReward() < 0){
					builder.append(String.format(" %.2f  |", grid[row][col].getReward()));
				}else {
					builder.append(String.format("  %.2f  |", grid[row][col].getReward()));
				}
			}
			builder.append("\n");
			drawBorder(builder, GridMaze.NUM_COL, 8);
		}
		System.out.println(builder.toString());
	}
	
	/**
	 * Prints a map of the optimal policy for each state
	 * @param policy
	 */
	public static void displayActions(final Policy policy) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Policy:\n");
		
		drawBorder(builder, GridMaze.NUM_COL, 3);
		for(int row = 0; row < GridMaze.NUM_ROW; row++) {
			builder.append("|");
			for(int col = 0; col < GridMaze.NUM_COL; col++) {
				if(policy.getPolicyAction(row, col) != null)
					builder.append(String.format(" %s |", policy.getPolicyAction(row, col)));
				else
					builder.append("   |");
			}
			builder.append("\n");
			drawBorder(builder, GridMaze.NUM_COL, 3);
		}
		
		System.out.println(builder.toString());
	}
	
	/**
	 * Prints all utilities of the final policy in the format (col, row)
	 * Skips wall states
	 * @param policy
	 * @param grid
	 */
	public static void displayUtilities(final Policy policy, final State[][] grid) {
		System.out.println("Utilities:\n");
		for(int col = 0; col < GridMaze.NUM_COL; col++) {
			for(int row = 0; row < GridMaze.NUM_ROW; row++) {
				if(!grid[col][row].isWall()) {
					System.out.printf("(%1d, %1d): %.6f\n", col, row, policy.getPolicyUtil(col, row));
				}
			}
		}
		System.out.println("\n");
	}
	
	/**
	 * Helper function to print the borders of the grid
	 * @param builder
	 * @param length
	 * @param tileSize
	 */
	private static void drawBorder(StringBuilder builder, int length, int tileSize) {
		builder.append("|");
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < tileSize; j++) {
				builder.append("-");
			}
			builder.append("|");
		}
		builder.append("\n");
	}
}
