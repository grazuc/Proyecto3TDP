package Logica;

public interface Visitor {
	public void visit (Jugador J);
	public void visit (InfectadoAlpha a);
	public void visit (InfectadoBeta b);
	public void visit (EfectoTemporal e);
	public void visit (ObjetosPreciosos o);
	public void visit (ProyectilJugador pj);
	public void visit (ProyectilInfectado pi);
}
