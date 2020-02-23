/**
 * An exception that is thrown whenever you try to access an index outside the bounds of the grid.
 * @author Jeff
 *
 */
public class GridCoordsOutOfBoundsException extends IndexOutOfBoundsException {
	public GridCoordsOutOfBoundsException() {
		super("index out of bounds");
	}
	public GridCoordsOutOfBoundsException(String s) {
		super(s);
	}
}
