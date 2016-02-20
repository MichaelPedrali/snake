
public class Cerchio {
	private Punto centro;
	private int raggio;

	private int BASECANVAS=500;
	private int ALTCANVAS=350;

	public Cerchio() {
		this.centro = new Punto(BASECANVAS/2, ALTCANVAS/2);
		this.raggio = 10;
	}

	public Cerchio(Cerchio c) {
		setCentro(c.getCentro());
		setRaggio(c.getRaggio());
	}

	public Cerchio(Punto x, int r) {
		this.centro = new Punto(x);
		this.raggio = r;
	}

	public Punto getCentro() {
		return centro;
	}

	public void setCentro(Punto centro) {
		this.centro = new Punto(centro);
	}

	public int getRaggio() {
		return raggio;
	}

	public void setRaggio(int raggio) {
		this.raggio = raggio;
	}

	public void sposta(int deltax, int deltay) {
		centro.setX(centro.getX() + deltax);
		centro.setY(centro.getY() + deltay);

	}
	
	public boolean equals(Cerchio c) {
		if (centro.equals(c.getCentro())){
			return true;
		}else{
			return false;
		}
	}

}
