package MDP;

public class State {
	public static final boolean WALL = true;
	
	private double reward;
	private boolean isWall;
		
	public State(double reward) {
		this.reward = reward;
		isWall = false;
	}
	
	public State(boolean isWall) {
		this.isWall = isWall;
		this.reward = 0.0;
	}
	
	public double getReward() {
		return reward;
	}
	
	public boolean isWall() {
		return isWall;
	}

}
