import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Actor {
	
	protected int x,y;
	protected BufferedImage img;
	protected int ancho;
	protected int alto;
	
	
	
	
	/**
	 * 
	 */
	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @param x
	 * @param y
	 * @param img
	 * @param ancho
	 * @param largo
	 */
	public Actor(int x, int y, int ancho, int alto, BufferedImage img) {
		super();
		this.x = x;
		this.y = y;
		this.setImg(img);
		this.ancho = ancho;
		this.alto = alto;
	}



	public abstract void actua ();
	
	
	public void paint(Graphics g) {
		g.drawImage(this.img, this.x, this.y, null);
	}
	
	/**
	 * Método que se podrá sobrescribir en los subtipos para decidir la acción a realizar al colisionar
	 * con otro actor
	 * @param a
	 */
	public void colisionaCon(Actor a) {
	}
	

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the img
	 */
	public BufferedImage getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(BufferedImage img) {
		this.img = img;
		this.ancho = this.img.getWidth();
		this.alto = this.img.getHeight();
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


	
	
	
	
	

}
