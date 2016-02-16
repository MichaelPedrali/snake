import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;

public class snake {

	protected Shell shlSnake;
	private Text text;
	private int BASECANVAS=500;
	private int ALTCANVAS=350;
    Cerchio c = new Cerchio();
    Punto centro = new Punto(BASECANVAS/2,ALTCANVAS/2);
    char tasto;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			snake window = new snake();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlSnake.open();
		shlSnake.layout();
		while (!shlSnake.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSnake = new Shell();
		shlSnake.setSize(536, 450);
		shlSnake.setText("SNAKE");
		
		Canvas canvas = new Canvas(shlSnake, SWT.NONE);
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		canvas.setBounds(10, 10, 500, 350);
		
		text = new Text(shlSnake, SWT.BORDER);
		text.setBounds(10, 380, 210, 30);
		
		Button btnNewButton = new Button(shlSnake, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GC gc= new GC(canvas);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				gc.drawOval(centro.getX(), centro.getY(),c.getRaggio() ,c.getRaggio() );
				for(int i = 0; i < 10000; i++){
					c.sposta(10, 0);
					gc.drawOval((centro.getX())+i, (centro.getY())+i,c.getRaggio() ,c.getRaggio() );
				
			    if (tasto==224){
				    ;
					if(tasto==72){
						//freccia in alto
						centro.setY((centro.getY()-1)); //posY--;
					}
					if(tasto==80){
						//freccia in basso
						centro.setY((centro.getY()+1)); //posY--;
					}
					if(tasto==77){
						//freccia a destra
						centro.setX((centro.getX()+1)); //posY--;
					}
					if(tasto==75){
						//freccia a sinistra
						centro.setX((centro.getX()-1));
					}
				}
				}
				
				
			}
		});
		btnNewButton.setBounds(226, 380, 170, 30);
		btnNewButton.setText("START");
		
		Label lblScore = new Label(shlSnake, SWT.NONE);
		lblScore.setBounds(402, 383, 108, 25);
		lblScore.setText("SCORE");


	}
}
