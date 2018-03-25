package MDP;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Action {
	UP{
        public String toString(){
            return "^";}
        },
	DOWN{
        public String toString(){
            return "v";}
        },
	LEFT{
        public String toString(){
            return "<";}
        },
	RIGHT{
        public String toString(){
            return ">";}
        };

	public static Action getRandomAction() {
		Random rand = new Random();
		List<Action> values =
			Collections.unmodifiableList(Arrays.asList(values()));
		return values.get(rand.nextInt(values.size()));
	}
}
