import java.util.ArrayList;
import java.util.List;

import MDP.Action;
import MDP.GridMaze;
import MDP.Policy;
import MDP.State;

public class ValueIteration {
	/**
	 * 
	 * @param gridMaze Markov Decission Process
	 * @param e max error allowed in the utility of any state
	 * @return List of policies; the last one is optimal
	 */
	public static List<Policy> valueIteration(final GridMaze gridMaze, double e) {
		Policy policy = new Policy(GridMaze.NUM_COL, GridMaze.NUM_ROW);
		List<Policy> policies = new ArrayList<>();
		double[][] nextUtils = new double[GridMaze.NUM_ROW][GridMaze.NUM_COL];
		double d;
		State[][] grid = gridMaze.getGridMaze();
		
		for(int row = 0; row < GridMaze.NUM_ROW; row++) {
			for(int col = 0; col < GridMaze.NUM_COL; col++) {
				nextUtils[row][col] = 0;
				policy.setPolicyUtil(row, col, 0);
			}
		}
		
		int num_iter = 0;
		
		do {
			for(int row = 0; row < GridMaze.NUM_ROW; row++) {
				for(int col = 0; col < GridMaze.NUM_COL; col++) {
					policy.setPolicyUtil(row, col, nextUtils[row][col]);
				}
			}
			d = 0;
			
			for(int row = 0; row < GridMaze.NUM_ROW; row++) {
				for(int col = 0; col < GridMaze.NUM_COL; col++) {
					
					if(grid[row][col].isWall())
						continue;
					
					double max = Double.NEGATIVE_INFINITY;
					for (Action action : Action.values()) {
						double maxUtil = gridMaze.calcUtility(row, col, action, policy.getPolicyUtils());
						if (max < maxUtil) {
							max = maxUtil;
							policy.setPolicyAction(row, col, action);
						}
					}
					nextUtils[row][col] = grid[row][col].getReward() + GridMaze.DISCOUNT * max;

					if (Math.abs(policy.getPolicyUtil(row, col) - nextUtils[row][col]) > d)
						d = Math.abs(policy.getPolicyUtil(row, col) - nextUtils[row][col]);
				}
			}
			
			num_iter++;
			policies.add(policy.clone());
			
		}while(d >= e*(1-GridMaze.DISCOUNT)/GridMaze.DISCOUNT);
		
		System.out.println("Number of value iterations: " + num_iter+ "\n");
		
		return policies;
		
	}
	
}
