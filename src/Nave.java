import java.awt.Color;
import java.awt.Graphics;

public class Nave extends Actor{

	
	
	/**
	 * 
	 */
	public Nave() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param x
	 * @param y
	 * @param ancho
	 * @param alto
	 * @param img
	 */
	public Nave(int x, int y, int ancho, int alto, String img) {
		super(x, y, ancho, alto, img);
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(this.x, this.y, 60, 10);
	}
	
	@Override
	public void actua() {
		
	}
	
	
}
