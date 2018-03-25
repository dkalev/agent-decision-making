package utils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import MDP.GridMaze;
import MDP.Policy;

public class FileIO {

	/**
	 * Stores the results from the policy evaluation in a .csv file
	 * @param policies
	 * @param fileName
	 */
	public static void writeToFile(List<Policy> policies, String fileName) {
		StringBuilder builder = new StringBuilder();
		DecimalFormat df = new DecimalFormat("00.000");
		
		for(int row = 0; row < GridMaze.NUM_ROW; row++) {
			for(int col = 0; col < GridMaze.NUM_COL; col++) {
				for(int i = 0; i < policies.size(); i++) {
					builder.append(df.format(policies.get(i).getPolicyUtil(row, col)));
					
					if(i < policies.size() - 1)
						builder.append(",");
				}
				builder.append("\n");
			}
		}
		
		try {
			FileWriter fw = new FileWriter(new File(fileName), false);
			fw.write(builder.toString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
