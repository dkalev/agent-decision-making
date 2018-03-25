import java.util.ArrayList;
import java.util.List;

import MDP.Action;
import MDP.GridMaze;
import MDP.Policy;
import MDP.State;

public class PolicyIteration {
	/**
	 * Modified Policy Iteration
	 * @param gridMaze Markov Decision Process(MDP)
	 * @param k number of iterations of the Bellman update
	 * @return List of policies; the last policy is the optimal one
	 */
	public static List<Policy> policyIteration(final GridMaze gridMaze, int k){
		
		//initialize vectors
		Policy policy = new Policy(GridMaze.NUM_ROW, GridMaze.NUM_COL);
		List<Policy> policies = new ArrayList<>();
		State[][] grid = gridMaze.getGridMaze();
		
		for(int row = 0; row < GridMaze.NUM_ROW; row++) {
			for(int col = 0; col < GridMaze.NUM_COL; col++) {
				if(grid[row][col].isWall())
					continue;
				policy.setPolicyAction(row, col, Action.getRandomAction());
			}
		}
		
		boolean changed;
		
		int num_iter = 0;
		
		do {
			
			policies.add(policy.clone());
			
			policy = policyEval(policy, gridMaze, k);
			
			
			changed = false;
			
			//for each state s in S
			for(int row = 0; row < GridMaze.NUM_ROW; row++) {
				for(int col = 0; col < GridMaze.NUM_COL; col++) {
					
					
					if (grid[row][col].isWall())
						continue;
					
					double max = Double.NEGATIVE_INFINITY;
					double newUtil = 0;
					Action newAction = Action.DOWN;
					
					//find highest util and best action
					for (Action action : Action.values()) {
						newUtil = gridMaze.calcUtility(row, col, action, policy.getPolicyUtils());
						if (max < newUtil) {
							max = newUtil;
							newAction = action;
						}
					}			
					newUtil = max;
					
					double curUtil = gridMaze.calcUtility(row, col, policy.getPolicyAction(row, col), policy.getPolicyUtils());
					
					//if better than the current util, replace
					if (newUtil > curUtil) {
						policy.setPolicyAction(row, col, newAction);
						changed = true;
					}
					
				}
			}
			
			num_iter++;
			
		}while(changed);
		
		System.out.println("Number of policy iterations: " + num_iter +"\n");
		
		return policies;
	}
	/**
	 * Uses the simplified Bellman update to evaluate and improve the current policy
	 * @param current policy
	 * @param Markov Decision Process(MDP)
	 * @param k number of times the algorithm is repeated to produce the utility
	 * @return updated policy
	 */
	private static Policy policyEval(final Policy policy, final GridMaze gridMaze, int k){
		
		Policy newPolicy = policy.clone();
		State[][] grid = gridMaze.getGridMaze();
		
		for(int i = 0; i < k; i++) {
			for(int row = 0; row < GridMaze.NUM_ROW; row++) {
				for(int col = 0; col < GridMaze.NUM_COL; col++) {
					
					if (grid[row][col].isWall())
						continue;
					
					double util = grid[row][col].getReward() + GridMaze.DISCOUNT*gridMaze.calcUtility(row, col, newPolicy.getPolicyAction(row, col), newPolicy.getPolicyUtils());
					newPolicy.setPolicyUtil(row, col, util);
				}
			}
		}
		return newPolicy;
	}
	
}
