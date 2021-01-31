package pakageSnake;

public class Serpent{
	
	private int mX;
	private int mY;
	
	public Serpent() {
		System.out.println("inisialisation du serpent");
		mX = 0;
		mY = 0;
	}

	public int getX() {
		return mX;
	}

	public void setX(int x) {
		mX = x;
	}

	public int getY() {
		return mY;
	}

	public void setY(int y) {
		mY = y;
	}
}
