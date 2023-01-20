
public class Pelota extends Actor{

	private int velocidadX = 4;
	private int velocidadY = 4;
	

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
	public Pelota(int x, int y, int ancho, int alto) {
		super(x, y, ancho, alto, ImagesCache.getInstance().getImagen(ImagesCache.IMAGEN_PELOTA));
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
