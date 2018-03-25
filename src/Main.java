import java.util.List;

import MDP.GridMaze;
import MDP.Policy;
import utils.DisplayUtil;
import utils.FileIO;

public class Main {
	public static void main(String[] args){
		GridMaze maze = new GridMaze();
		DisplayUtil.displayGridMaze(maze);
		
		System.out.println("---Value Iteration---\n");
		int e = 40;
		System.out.println("Maximum error allowed in the utility of any state: " + e +"\n");
		List<Policy> policiesVI = ValueIteration.valueIteration(maze, 40);
		Policy policyVI = policiesVI.get(policiesVI.size()-1);

		DisplayUtil.displayActions(policyVI);
		DisplayUtil.displayUtilities(policyVI, maze.getGridMaze());
		
		System.out.println("---Policy Iteration---\n");
		int k = 20;
		System.out.println("Number of iterations of the simplified Bellman update: "+ k +"\n");
		List<Policy> policiesPI = PolicyIteration.policyIteration(maze, k);
		Policy policyPI = policiesPI.get(policiesPI.size()-1);
		
		DisplayUtil.displayActions(policyPI);
		DisplayUtil.displayUtilities(policyPI, maze.getGridMaze());

		FileIO.writeToFile(policiesVI, "data/policiesVI.csv");
		FileIO.writeToFile(policiesPI, "data/policiesPI.csv");
	}
}
