import java.util.ArrayList;
/**
 * represents a drone that can move in a grid.
 * @author Jeff
 *
 */
public class Drone {
	private Coordinate start;
	private Grid grid;
	private ArrayList<Signalable> listenersList = new ArrayList<Signalable>();
	
	public Drone(Coordinate start, Grid grid) {
		this.start = start;
		this.grid = grid;
	}
	
	public Drone(int x, int y, Grid grid) {
		this.start = new Coordinate(x, y);
		this.grid = grid;
	}
	
	public void addTokenListener(Signalable listener) {
		this.listenersList.add(listener);
	}
	
	public void removeTokenListener(Signalable listener) {
		this.listenersList.remove(listener);
	}
	
	public Coordinate getPosition() {
		return this.start;
	}
	
	/**
	 * looks through every element in listenersList and signal it on this drone.
	 */
	private void signalAll() {
		for (Signalable s : listenersList) {
			s.signal(this);    
			}
	}
	
	/**
	 * create the drone's new position by adding direction d to its start position. check if the new position has a 
	 * token by calling the grid's hasToken method. Finally set the start position to the new position. 
	 * @param d
	 * @throws GridCoordsOutOfBoundsException (if index is out of bounds)
	 */
	public void move(Direction d) throws GridCoordsOutOfBoundsException {
		try {
			Coordinate newPos = start.plus(d);
			if (grid.hasToken(newPos)) {
				signalAll();
			}
			this.start = newPos;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new GridCoordsOutOfBoundsException();
		}
	}
	
	/**
	 * calls the searchHelper method that recursively searches the grid.
	 */
	public void search() {
		searchHelper(0,0);
	}
	
	/**
	 * recursively searches the grid.
	 * base case: if the x and y values are at the end of the grid.
	 * recursive search: call searchHelper recursively with incremented x until it reaches the end
	 * then move up one, reset x to zero, and search again (left to right) until you reach the end
	 * of the grid.
	 * checks if there are tokens at each coordinate by using move(Direction.NONE).
	 * @param x
	 * @param y
	 */
	private void searchHelper(int x, int y) {
		int maxX = grid.sizeX()-1;
		int maxY = grid.sizeY()-1;

		this.start = new Coordinate(x,y);
		move(Direction.NONE);
		
		if (x == maxX && y == maxY) {
			return;
		}
		else {
			if (x<maxX) {
				searchHelper(x+1, y);
			}
			else {
				searchHelper(0, y+1);
			}
		}
	}
	
}
