/**
 * An enum that moves the drone in a certain direction
 * @author Jeff
 *
 */
public enum Direction {
	UP, DOWN, LEFT, RIGHT, NONE;
	
	public Coordinate delta() {
		if (this == UP) {
			return new Coordinate(0, 1);
		}
		if (this == DOWN) {
			return new Coordinate(0, -1);
		}
		if (this == LEFT) {
			return new Coordinate(-1, 0);
		}
		if (this == RIGHT) {
			return new Coordinate(1, 0);
		}
		else {
			return new Coordinate(0, 0);
		}
	}
	
}
