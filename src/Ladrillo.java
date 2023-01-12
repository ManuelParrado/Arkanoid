import java.awt.Color;
import java.awt.Graphics;

public class Ladrillo extends Actor{
	
	private Color color;
	private int espaciado = 4;

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
	 * @param ancho
	 * @param largo
	 * @param img
	 */
	public Ladrillo(int x, int y, int ancho, int largo, String img, Color color) {
		super(x, y, ancho, largo, img);
		this.color = color;
		// TODO Auto-generated constructor stub
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

	@Override
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(this.x, this.y, this.ancho, this.alto);
	}
	
	@Override
	public void actua() {
		
	}
	
	
}
