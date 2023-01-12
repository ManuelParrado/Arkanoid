import java.awt.BorderLayout;
import java.awt.Color;
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
	private static JFrame ventana = null;
	private static List<Actor> actores = new ArrayList<Actor>();
	private static MiCanvas canvas = null;
	
	public static void main(String[] args) {
		
		JFrame ventana = new JFrame("Arkanoid");
		ventana.setBounds(0, 0, 500, 650);
		
		ventana.getContentPane().setLayout(new BorderLayout());
		
		
		actores = creaActores();
		
		
		canvas = new MiCanvas(actores);
		ventana.getContentPane().add(canvas, BorderLayout.CENTER);
		
		ventana.setIgnoreRepaint(true);
		
		ventana.setVisible(true);
		
		
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
				
				juego();
	

	}
	
	private static void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"¿Desea cerrar la aplicación?","Salir de la aplicación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public static void juego () {
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
	
	
	
	public static List<Actor> creaActores () {
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
				color = Color.cyan;
			} else if (i == 1) {
				color = Color.green;
			} else if (i == 2) {
				color = Color.magenta;
			} else if (i == 3) {
				color = Color.pink;
			} else if (i == 4) {
				color = Color.yellow;
			} else if (i == 5) {
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
		
		Nave nave = new Nave(220, 500, 10, 10, null);
		actores.add(nave);
		
		// Devuelvo la lista con todos los actores del juego
		return actores;
	}
	
	
	
}
