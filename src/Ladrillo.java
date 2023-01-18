import java.awt.Color;
import java.awt.Graphics;

public class Ladrillo extends Actor{
	
	private Color color;
	private int espaciado = 3;
	private int ancho;
	private int alto;
	
	
	/**
	 * @param x
	 * @param y
	 * @param img
	 * @param ancho
	 * @param alto
	 */
	public Ladrillo(int x, int y, String img, int ancho, int alto) {
		super(x, y, img, ancho, alto);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public Ladrillo() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @param color
	 * @param espaciado
	 * @param ancho
	 * @param alto
	 */
	public Ladrillo(Color color, int espaciado, int ancho, int alto) {
		super();
		this.color = color;
		this.espaciado = espaciado;
		this.ancho = ancho;
		this.alto = alto;
	}
	
	

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the espaciado
	 */
	public int getEspaciado() {
		return espaciado;
	}

	/**
	 * @param espaciado the espaciado to set
	 */
	public void setEspaciado(int espaciado) {
		this.espaciado = espaciado;
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
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(this.x, this.y, this.ancho, this.alto);
	}
	
	
	@Override
	public void actua() {
		
	}
	
	@Override
	public void colisionaCon(Actor a) {
		super.colisionaCon(a);
		// Si colisionamos con un player o un disparo, eliminamos al monstruo
		if (a instanceof Pelota) {
			Arkanoid.getInstance().eliminaActor(this);
		}
	}
	
	
}
