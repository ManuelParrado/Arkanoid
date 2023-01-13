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
	
	public void mover(int x, int y) {
		this.x = x;
		this.y = y;
		// Controlo los casos en los que el jugador pueda salir del Canvas
		MiCanvas canvas = Arkanoid.getInstance().getCanvas(); // Referencia al objeto Canvas usado

		// Compruebo si el ratón sale por la derecha
		if (this.x > (canvas.getWidth() - this.ancho)) {
			this.x = canvas.getWidth() - this.ancho;
		}
		// Compruebo si el ratón sale por abajo
		if (this.y > (canvas.getHeight() - this.alto)) {
			this.y = canvas.getHeight() - this.alto;
		}
	}
	
	
}
