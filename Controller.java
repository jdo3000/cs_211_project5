import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller implements Signalable<Drone> {
	private int tokens;
	private ArrayList<Coordinate> tokensFound;
	
	public Controller() {
		this.tokens = 0;
		this.tokensFound = new ArrayList<Coordinate>();
	}
	
	public int count() {
		return this.tokens;
	}
	
	/**
	 * 
	 * @return an unmodifiable list of tokensFound
	 */
	public List<Coordinate> getCoords() {
		return Collections.unmodifiableList(tokensFound);
	}
	
	/**
	 * checks if the list tokensFound already contains the coordinate
	 * if it does not, add it to the list and increase the tokens count by 1;
	 */
	@Override
	public void signal(Drone d) {
		Coordinate c = d.getPosition();
		if (!(tokensFound.contains(c))) {
			this.tokensFound.add(c);
			this.tokens += 1;

		}
	}

}
