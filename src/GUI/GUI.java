package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Jugador;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GUI extends JFrame {

	private JPanel contentPane,panelEntidades;
	int numero;
	private JLabel labelFondo,labelJugador,labelInfectado,labelInfectado2,labelDisparo;
	protected Jugador j;
	private String [] jugador = new String [] {"/JUGADOR/Jugador.png","/JUGADOR/Disparo.png"};
	private String [] infectadoAlpha = new String [] {"/gif1/gif1.gif"};
	private String [] infectadoBeta = new String [] {"/gif2/gif3.gif"};
	private String [] fondos=new String[] {"/Fondos/Fondo1.jpg","/Fondos/Fondo2.jpg"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public GUI() {
		setTitle("Juego");
		setBounds(100, 100, 1000,800);
		//Creo los paneles
		panelEntidades = new JPanel();
		panelEntidades.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panelEntidades.setLayout(null);
		
		//Creo el lbl Fondo
		labelFondo=new JLabel();
		labelFondo.setBounds(0, 0, 984,761);
		
		//Añado el fondo y el panelentidades a contentpane
		contentPane.add(labelFondo,-1);
		contentPane.add(panelEntidades,-1);
		ImageIcon grafico = new ImageIcon(this.getClass().getResource(this.fondos[1]));
		labelFondo.setIcon(grafico);
		reDimensionar(labelFondo,grafico);
		ImageIcon grafico2 = new ImageIcon(this.getClass().getResource(this.jugador[0]));
		
		//Creo el jugador (y lo necesario para que se mueva)
		j=new Jugador(0,1000);
		addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent ke) {
                //int coordenadaX=j.moverDerecha();
            	if (ke.getKeyChar() == 'a' || ke.getKeyChar() == 'A' || ke.getKeyCode() == 37) {
            		labelJugador.setBounds(j.moverIzquierda(),611,150,150);
            	} else if (ke.getKeyChar() == 'd' || ke.getKeyChar() == 'D' || ke.getKeyCode() == 39) {
            		labelJugador.setBounds(j.moverDerecha(),611,150,150);
            	}
            }

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		
		//Creo los imageicon
		ImageIcon grafico3 = new ImageIcon(this.getClass().getResource(this.infectadoAlpha[0]));
		ImageIcon grafico4 = new ImageIcon(this.getClass().getResource(this.infectadoBeta[0]));
		ImageIcon graficoDisparo = new ImageIcon(this.getClass().getResource(this.jugador[1]));
		
		//Creo los labels de infectados
		labelInfectado = new JLabel();
		labelInfectado2 = new JLabel();
		labelJugador = new JLabel();
		
		//Los añado al panel de entidades
		panelEntidades.add(labelInfectado2,-1);
		panelEntidades.add(labelInfectado,-1);
		panelEntidades.add(labelJugador,-1);
		//labelFondo.add(labelInfectado);
		//labelFondo.add(labelInfectado2);
		//labelFondo.add(labelJugador);
		Random NumeroAleatorio = new Random();
		labelInfectado2.setIcon(grafico4);
		labelInfectado.setIcon(grafico3);
		labelJugador.setIcon(grafico2);
		numero = NumeroAleatorio.nextInt(550-350+1) + 350;
		labelInfectado2.setBounds(numero,400,250,230);
		numero = NumeroAleatorio.nextInt(550-350+1) + 350;
		labelInfectado.setBounds(numero,400,250,230);
		labelJugador.setBounds(0,611,984,150);
		labelInfectado.setVisible(true);
		movimiento(labelInfectado);
		movimiento(labelInfectado2);

		
		//labelDisparo = new JLabel();
		//labelDisparo.setIcon(graficoDisparo);		
		
		/*contentPane.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int x= arg0.getX();
				int y = arg0.getY();
				int h= 450;
				int altura = labelInfectado.getHeight();
				while (h>=altura) {
					h=h-10;
				labelDisparo.setBounds(x,y,984,h);
				labelFondo.add(labelDisparo);
				labelDisparo.repaint();
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});*/
		
	}
	
	private void movimiento(JLabel label) {
		Timer timer = new Timer();
		TimerTask tarea=new TimerTask() {
			@Override
            public void run() {
					label.setBounds(label.getX(), label.getY()+20, label.getWidth(), label.getHeight());
			}
		};
		timer.schedule(tarea, 0, 500);
	}
	
	
	
	private void reDimensionar(JLabel label, ImageIcon grafico) {
		Image image = grafico.getImage();
		if (image != null) {  
			Image newimg = image.getScaledInstance(label.getWidth(), label.getHeight(),  java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
			label.repaint();
		}
	}
		
}

