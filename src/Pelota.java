import java.awt.Color;
import java.awt.Graphics;

public class Pelota extends Actor{

	private int velocidadX = -5;
	private int velocidadY = -5;
	
	/**
	 * 
	 */
	public Pelota() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param x
	 * @param y
	 * @param ancho
	 * @param largo
	 * @param img
	 */
	public Pelota(int x, int y, int ancho, int largo, String img) {
		super(x, y, ancho, largo, img);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param velocidadX
	 * @param velocidadY
	 */
	public Pelota(int velocidadX, int velocidadY) {
		super();
		this.velocidadX = velocidadX;
		this.velocidadY = velocidadY;
	}

	/**
	 * @return the velocidadX
	 */
	public int getVelocidadX() {
		return velocidadX;
	}

	/**
	 * @param velocidadX the velocidadX to set
	 */
	public void setVelocidadX(int velocidadX) {
		this.velocidadX = velocidadX;
	}

	/**
	 * @return the velocidadY
	 */
	public int getVelocidadY() {
		return velocidadY;
	}

	/**
	 * @param velocidadY the velocidadY to set
	 */
	public void setVelocidadY(int velocidadY) {
		this.velocidadY = velocidadY;
	}

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(this.x, this.y, this.alto, this.ancho);
	}
	
	@Override
	public void actua() {
		
	// El monstruo se mueve de manera horizontal, en cada FPS
			this.x += this.velocidadX;
			// Si el monstruo abandona la escena por la izquierda o la derecha, rebota
			if (this.x < 0 || this.x > 800) {
				this.velocidadX = -this.velocidadX;
			}
			
			// Copiamos el esquema anterior para el movimiento vertical
			this.y += this.velocidadY;
			// Si el monstruo abandona la escena por la izquierda o la derecha, rebota
			if (this.y < 0 || this.y > 600) {
				this.velocidadY = -this.velocidadY;
			}
		
	}
	
}
