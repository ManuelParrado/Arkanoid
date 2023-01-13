import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.rmrsoft.spaceInvaders.Actor;
import org.rmrsoft.spaceInvaders.MiCanvas;

public class Arkanoid {

	private static int FPS = 60;
	private JFrame ventana = null;
	private List<Actor> actores = new ArrayList<Actor>();
	private MiCanvas canvas = null;
	Nave nave = null;

	
	private static Arkanoid instance = null;
	
	public static Arkanoid getInstance () {
		if (instance == null) { // Si no está inicializada, se inicializa
			instance = new Arkanoid();
		}
		return instance;
	}
	
	public Arkanoid () {
		ventana = new JFrame("Space Invaders");
		ventana.setBounds(0, 0, 500, 650);

		// Para colocar objetos sobre la ventana debo asignarle un "layout" (plantilla) al panel principal de la ventana
		ventana.getContentPane().setLayout(new BorderLayout());
		
		// Creo una lista de actores que intervendrá en el juego.
		actores = creaActores();
		
		// Creo y agrego un canvas, es un objeto que permitirá dibujar sobre él
		canvas = new MiCanvas(actores);
		
		canvas.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
				nave.mover(e.getX(), e.getY());
			}			
		});
		
		ventana.getContentPane().add(canvas, BorderLayout.CENTER);
		// Consigo que la ventana no se redibuje por los eventos de Windows
		ventana.setIgnoreRepaint(true);
		// Hago que la ventana sea visible
		ventana.setVisible(true);
		
		// Control del evento de cierre de ventana
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});

	}

	
	public static void main(String[] args) {
		
		Arkanoid.getInstance().juego();

	}
	
	private void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"¿Desea cerrar la aplicación?","Salir de la aplicación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void juego () {
		int millisPorCadaFrame = 1000 / FPS;
		do {
			
			long millisAntesDeProcesarEscena = new Date().getTime();
			
			
			canvas.repaint();
			
			
			for (Actor a : actores) {
				a.actua();
			}
			
			
			long millisDespuesDeProcesarEscena = new Date().getTime();
			int millisDeProcesamientoDeEscena = (int) (millisDespuesDeProcesarEscena - millisAntesDeProcesarEscena);
			int millisPausa = millisPorCadaFrame - millisDeProcesamientoDeEscena;
			millisPausa = (millisPausa < 0)? 0 : millisPausa;
			
			try {
				Thread.sleep(millisPausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}
	
	
	
	public List<Actor> creaActores () {
		List<Actor> actores = new ArrayList<Actor>();
		
		//Creo la pelota
		Pelota pelota = new Pelota(240, 325, 10, 10, null);
		actores.add(pelota);
		
		int x = 30;
		int y = 50;
		
		// Creo los ladrillos del juego
		for (int i = 0; i < 6; i++) {
			if (i > 0) {
				x = 30;
			}
			
			Color color = null;
			 
			if (i == 0) {
				color = Color.CYAN;
			} else if (i == 1) {
				color = Color.GREEN;
			} else if (i == 2) {
				color = Color.MAGENTA;
			} else if (i == 3) {
				color = Color.PINK;
			} else if (i == 4) {
				color = Color.YELLOW;
			} else {
				color = Color.RED;
			}
			
			for (int j = 0; j < 12; j++) {
				Ladrillo ladrillos = new Ladrillo(x, y, 35, 15, null, color);
				x = x + ladrillos.getEspaciado();
				actores.add(ladrillos);
				x += 33;
			}
			y += 20;
		}
		
		nave = new Nave(220, 500, 10, 10, null);
		actores.add(nave);
		
		// Devuelvo la lista con todos los actores del juego
		return actores;
	}
	
	public MiCanvas getCanvas() {
		return canvas;
	}
	
	
	
}
