
public class Cerchio {
	private Punto centro;
	private int raggio;

	public static int BASECANVAS = 250;
	public static int ALTEZZACANVAS = 250;

	public Cerchio() {
		this.centro = new Punto(0, 0);
		this.raggio = 10;
	}

	public Cerchio(Punto x, int r) {
		this.centro = new Punto(x);
		this.raggio = r;
	}

	public Punto getCentro() {
		return centro;
	}

	public void setCentro(Punto centro) {
		this.centro = centro;
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

}
