/**
 * A class that represents a coordinate.
 * @author Jeff
 *
 */
public final class Coordinate {
	private final int x;
	private final int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	/**
	 * @param dx
	 * @param dy
	 * @return a new coordinate with the new x and y values added to the old values.
	 */
	public Coordinate plus(int dx, int dy) {
		return new Coordinate(x+dx, y+dy);
	}
	
	/**
	 * An overloaded method that also adds the x and y values but takes in another coordinate in the parameters.
	 * @param delta
	 * @return a new coordinate with the added values.
	 */
	public Coordinate plus(Coordinate delta) {
		int dx = delta.getX();
		int dy = delta.getY();
		return new Coordinate(x+dx, y+dy);
	}
	
	/**
	 * An overloaded method that also adds the x and y values but takes in a direction in the parameters.
	 * @param d
	 * @return a new coordinate with the added values.
	 */
	public Coordinate plus(Direction d) {
		Coordinate c = d.delta();
		int dx = c.getX();
		int dy = c.getY();
		return new Coordinate(x+dx, y+dy);
	}
	
	/**
	 * @return a string of the coordinates in the form: "(x, y)"
	 */
	@Override public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}
