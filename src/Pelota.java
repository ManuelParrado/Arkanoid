import java.awt.Color;
import java.awt.Graphics;

public class Pelota extends Actor{

	private int velocidadX = -5;
	private int velocidadY = -5;
	private int ancho;
	private int alto;
	

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
	 * @param img
	 * @param ancho
	 * @param alto
	 */
	public Pelota(int x, int y, String img, int ancho, int alto) {
		super(x, y, img, ancho, alto);
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param velocidadX
	 * @param velocidadY
	 * @param ancho
	 * @param alto
	 */
	public Pelota(int velocidadX, int velocidadY, int ancho, int alto) {
		super();
		this.velocidadX = velocidadX;
		this.velocidadY = velocidadY;
		this.ancho = ancho;
		this.alto = alto;
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

	/**
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	/**
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(int alto) {
		this.alto = alto;
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
			if (this.x < 0 || (this.x + this.ancho) > Arkanoid.getInstance().getCanvas().getWidth()) {
				this.velocidadX = -this.velocidadX;
			}
			
			// Copiamos el esquema anterior para el movimiento vertical
			this.y += this.velocidadY;
			// Si el monstruo abandona la escena por la izquierda o la derecha, rebota
			if (this.y < 0 || (this.y + this.alto) > Arkanoid.getInstance().getCanvas().getHeight()) {
				this.velocidadY = -this.velocidadY;
			}
		
	}
	
	@Override
	public void colisionaCon(Actor a) {
		super.colisionaCon(a);
		if (a instanceof Nave || a instanceof Ladrillo) {
			this.velocidadY = -this.velocidadY;
		}
	}
	
}
