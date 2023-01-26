import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Nave extends Actor{

	// Propiedades que indican si se está produciendo un movimiento en una dirección
	private boolean izquierda = false, derecha = false;
	// Velocidad de la nave, expresada en píxeles por cada frame
	public static int VELOCIDAD = 5;
	
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
	 * @param img
	 * @param ancho
	 * @param alto
	 */
	public Nave(int x, int y, int ancho, int alto) {
		super(x, y, ancho, alto);
		this.setSpriteActual(ResourcesCache.getInstance().getImagen(ResourcesCache.IMAGEN_NAVE));
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param izquierda
	 * @param derecha
	 * @param ancho
	 * @param alto
	 */
	public Nave(boolean izquierda, boolean derecha, int ancho, int alto) {
		super();
		this.izquierda = izquierda;
		this.derecha = derecha;
		this.ancho = ancho;
		this.alto = alto;
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

	
	@Override
	public void actua() {
		super.actua();
		
		if (izquierda) this.x -= VELOCIDAD;
		if (derecha) this.x += VELOCIDAD;
		
		mover(this.x);
		
	}
	
	public void mover(int x) {
		this.x = x;
		// Controlo los casos en los que el jugador pueda salir del Canvas
		MiCanvas canvas = Arkanoid.getInstance().getCanvas(); // Referencia al objeto Canvas usado

		if (this.x > (canvas.getWidth() - 60)) {
			this.x = canvas.getWidth() - 60;
		}

		// Compruebo si el jugador sale por la izquierda
		if (this.x < 0) {
			this.x = 0;
		}
	
	}
	
	public void keyPressed (KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			izquierda = true; break;
		case KeyEvent.VK_RIGHT:
			derecha = true; break;
		}
	}
	
	public void keyReleased (KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			izquierda = false; break;
		case KeyEvent.VK_RIGHT:
			derecha = false; break;
		}
	}
	
}
