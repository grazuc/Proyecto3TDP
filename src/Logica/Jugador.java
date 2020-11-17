package Logica;
/** 
 * Clase Contenedor
 * Interfaz Grafica que modela el juego Sudoku.
 * @author Ignacio Niveyro, Gonzalo Razuc, Guadalupe Carreño.
 * */

public class Jugador {
	/** 
	 * pos X determina la coordenada X en el mapa del jugador.
	*/
	int posX;
	/** 
	 * pos y determina la coordenada Y en el mapa del jugador.
	*/
	int posY;
	/** 
	 * cargaViral determina del 0 al 100 la carga viral del jugador.
	*/
	int cargaViral;
	/** 
	 * infectado, true si cargaViral llego a 100, false caso contrario.
	*/
	boolean infectado;
	/** 
	 * velocidad determina que tan rápido se desplaza.
	*/
	int velocidad;
	int bordex;
	int bordey;
	//ArmaDesinfectante a;
	
	public Jugador(int x,int y) {
		velocidad=10; //CAMBIAR
		bordex=0;
		bordey=y-150;
		cargaViral=0;
		infectado=false;
	}
	

	public int moverIzquierda() {
		if (bordex<posX) {
			int posXOriginal=posX;
			posX=posX-velocidad;
		}
		return posX;
}
	
	public int moverDerecha() {
		if (bordey>posX) {
			int posXOriginal=posX;
			posX=posX+velocidad;
		}
		return posX;
	}
}
