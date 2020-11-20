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

	private JPanel contentPane;
	int numero;
	private JLabel labelFondo,labelJugador,labelInfectado,labelInfectado2,labelDisparo,labelLimite;
	protected Jugador j;
	private String [] jugador = new String [] {"/JUGADOR/Jugador.png","/JUGADOR/Disparo.png"};
	private String [] infectadoAlpha = new String [] {"/gif1/gif1.gif"};
	private String [] infectadoBeta = new String [] {"/gif2/gif3.gif"};
	private String [] fondos=new String[] {"/Fondos/Fondo1.jpg","/Fondos/Fondo2.jpg"};
	private String [] barricada = new String[] {"/Jugador/Barricada.png"};

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creo el lbl Fondo
		labelFondo=new JLabel();
		labelFondo.setBounds(0, 0, 984,761);
		
		//Añado el fondo y el panelentidades a contentpane
		contentPane.add(labelFondo);
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
            		labelJugador.setBounds(j.moverIzquierda(),640,150,150);
            	} else if (ke.getKeyChar() == 'd' || ke.getKeyChar() == 'D' || ke.getKeyCode() == 39) {
            		labelJugador.setBounds(j.moverDerecha(),640,150,150);
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
		ImageIcon graficoBarricada = new ImageIcon(this.getClass().getResource(this.barricada[0]));
		
		//Creo los labels de infectados
		labelInfectado = new JLabel();
		labelInfectado2 = new JLabel();
		labelJugador = new JLabel();
		labelDisparo = new JLabel();
		labelLimite = new JLabel();
		
		//Los añado al panel de entidades
		//labelFondo.add(labelInfectado);
		//labelFondo.add(labelInfectado2);
		//labelFondo.add(labelJugador);
		//labelFondo.add(labelDisparo);
		contentPane.add(labelInfectado2,0);
		contentPane.add(labelInfectado,0);
		contentPane.add(labelLimite,0);
		contentPane.add(labelJugador,0);
		contentPane.add(labelDisparo,0);
		Random NumeroAleatorio = new Random();
		labelInfectado2.setIcon(grafico4);
		labelInfectado.setIcon(grafico3);
		labelJugador.setIcon(grafico2);
		labelDisparo.setIcon(graficoDisparo);
		labelLimite.setIcon(graficoBarricada);
		numero = NumeroAleatorio.nextInt(550-350+1) + 350;
		labelInfectado2.setBounds(numero,400,250,230);
		numero = NumeroAleatorio.nextInt(550-350+1) + 350;
		labelInfectado.setBounds(numero,400,250,230);
		labelJugador.setBounds(0,640,984,150);
		labelLimite.setBounds(0,611,984,150);
		movimiento(labelInfectado);
		movimiento(labelInfectado2);
		
		contentPane.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					movimientoDisparo(labelDisparo,arg0.getXOnScreen(),680);
					System.out.println("y:" +arg0.getY());
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
			
		});
		
	}
	
	private void movimientoDisparo(JLabel label,int x,int y) {
		Timer timer = new Timer();
		TimerTask tarea=new TimerTask() {
			@Override
            public void run() {
					label.setBounds(x, y+20, 250,230);
			}
		};
		timer.schedule(tarea, 0, 500);
	}
	
	
	private void movimiento(JLabel label) {
		Timer timer = new Timer();
		TimerTask tarea=new TimerTask() {
			@Override
            public void run() {
					if (label.getY()>labelLimite.getY()-60) {
						label.setBounds(label.getX(), 400, label.getWidth(), label.getHeight());
					}else {
						label.setBounds(label.getX(), label.getY()+10, label.getWidth(), label.getHeight());
					}
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
