import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Ladrillo extends Actor{
	
	private int espaciado = 3;
	private static String color[] = new String[] {ResourcesCache.IMAGEN_LADRILLO_AMARILLO, ResourcesCache.IMAGEN_LADRILLO_CYAN, 
			ResourcesCache.IMAGEN_LADRILLO_MORADO, ResourcesCache.IMAGEN_LADRILLO_ROJO, ResourcesCache.IMAGEN_LADRILLO_ROSA,
			ResourcesCache.IMAGEN_LADRILLO_VERDE};
	
	

	/**
	 * 
	 */
	public Ladrillo() {
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
	public Ladrillo(int x, int y, int num_color, int ancho, int alto) {
		super(x, y, ancho, alto);
		this.setSpriteActual(ResourcesCache.getInstance().getImagen(color[num_color]));
		// TODO Auto-generated constructor stub
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

	@Override
	public void actua() {
		
	}
	
	@Override
	public void colisionaCon(Actor a) {
		super.colisionaCon(a);
		// Si colisionamos con un player o un disparo, eliminamos al monstruo
		if (a instanceof Pelota) {
			Arkanoid.getInstance().eliminaActor(this);
			ResourcesCache.getInstance().playSonido("explosion.wav");
			Arkanoid.getInstance().incorporaNuevoActor(new Explosion(this.x, this.y));
		}
	}
	
	
}
