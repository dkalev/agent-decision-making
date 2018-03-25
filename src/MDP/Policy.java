package MDP;
/**
 * Policy objects store utilities and actions for each of the states in the map
 * @author dkalev
 *
 */
public class Policy implements Cloneable{
	private Action[][] actions;
	private double[][] utils;
	private int num_row;
	private int num_col;
	
	public Policy(int num_row, int num_col) {
		this.num_row = num_row;
		this.num_col = num_col;
		actions = new Action[num_row][num_col];
		utils = new double[num_row][num_col];
	}
	
	public void setPolicy(int row, int col, double util, Action action) {
		utils[row][col] = util;
		actions[row][col] = action;
	}
	
	public void setPolicyUtil(int row, int col, double util) {
		utils[row][col] = util;
	}
	
	public void setPolicyAction(int row, int col, Action action) {
		actions[row][col] = action;
	}
	
	public double getPolicyUtil(int row, int col) {
		return utils[row][col];
	}
	
	public Action getPolicyAction(int row, int col) {
		return actions[row][col];
	}
	
	public double[][] getPolicyUtils() {
		return utils;
	}
	
	public Action[][] getPolicyActions() {
		return actions;
	}
	
	public Policy clone(){
		Policy cloned = new Policy(num_row, num_col);
		for(int row = 0; row < num_row; row++) {
			for(int col = 0; col < num_col; col++) {
				cloned.setPolicy(row, col, this.getPolicyUtil(row, col), this.getPolicyAction(row, col));
			}
		}
		return cloned;
	}
}
