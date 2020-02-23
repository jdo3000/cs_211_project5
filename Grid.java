/**
 * represents a grid that the drone can move in.
 * @author Jeff
 *
 */
public class Grid {
	private int sizeX;
	private int sizeY;
	private boolean[][] gridArray;
	
	public Grid(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.gridArray = new boolean[sizeX][sizeY];
	}
	
	public int sizeX() {
		return this.sizeX;
	}
	
	public int sizeY() {
		return this.sizeY;
	}
	
	/**
	 * sets the point on the grid at coordinate c to true (signifying that there is a token)
	 * @param c
	 * @throws GridCoordsOutOfBoundsException (if index is out of bounds)
	 */
	public void setToken(Coordinate c) throws GridCoordsOutOfBoundsException {
		try {
			int x = c.getX();
			int y = c.getY();
			this.gridArray[x][y] = true;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new GridCoordsOutOfBoundsException();
		}
	}
	
	/**
	 * overloaded method that does the same thing as the method above but with different parameters.
	 * @param x
	 * @param y
	 * @throws GridCoordsOutOfBoundsException (if index is out of bounds)
	 */
	public void setToken(int x, int y) throws GridCoordsOutOfBoundsException {
		try {
			this.gridArray[x][y] = true;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new GridCoordsOutOfBoundsException();
		}
	}
	
	/**
	 * sets the point at coordinate c to false (signifying that there is no token)
	 * @param c
	 * @throws GridCoordsOutOfBoundsException (if index is out of bounds)
	 */
	public void resetToken(Coordinate c) throws GridCoordsOutOfBoundsException {
		try {
			int x = c.getX();
			int y = c.getY();
			this.gridArray[x][y] = false;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new GridCoordsOutOfBoundsException();
		}
	}
	/**
	 * overloaded method that does the same thing as the method above but with different parameters.
	 * @param x
	 * @param y
	 * @throws GridCoordsOutOfBoundsException (if index is out of bounds)
	 */
	public void resetToken(int x, int y) throws GridCoordsOutOfBoundsException {
		try {
			this.gridArray[x][y] = false;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new GridCoordsOutOfBoundsException();
		}
	}
	
	/**
	 * checks if the point at coordinate c is true. If yes, return true, else return false
	 * @param c
	 * @return boolean
	 * @throws GridCoordsOutOfBoundsException (if index is out of bounds)
	 */
	public boolean hasToken(Coordinate c) throws GridCoordsOutOfBoundsException {
		try {
			int x = c.getX();
			int y = c.getY();
			if (this.gridArray[x][y] == true) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new GridCoordsOutOfBoundsException();
		}
	}
	
	/**
	 * overloaded method that does the same thing as the method above but with different parameters.
	 * @param x
	 * @param y
	 * @return
	 * @throws GridCoordsOutOfBoundsException (if index is out of bounds)
	 */
	public boolean hasToken(int x, int y) throws GridCoordsOutOfBoundsException {
		try {
			if (this.gridArray[x][y] == true) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new GridCoordsOutOfBoundsException();
		}
	}
}
