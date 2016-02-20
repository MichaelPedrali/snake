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
    ElencoCerchi ec = new ElencoCerchi();
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
		shlSnake.setSize(536, 529);
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
				gc.drawOval(c.getCentro().getX(), c.getCentro().getY(),c.getRaggio() ,c.getRaggio() );
					//gc.drawOval((centro.getX())+i, (centro.getY())+i,c.getRaggio() ,c.getRaggio() );
				/*
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
				}*/
				
				
				
			}
		});
		btnNewButton.setBounds(226, 380, 170, 30);
		btnNewButton.setText("START");
		
		Label lblScore = new Label(shlSnake, SWT.NONE);
		lblScore.setBounds(413, 383, 49, 25);
		lblScore.setText("SCORE:");
		
		Label label = new Label(shlSnake, SWT.NONE);
		label.setBounds(457, 383, 45, 22);
		label.setText("0");
		
		Button btnNewButton_1 = new Button(shlSnake, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GC gc= new GC(canvas);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
				gc.drawOval(c.getCentro().getX(),c.getCentro().getY(), c.getRaggio(), c.getRaggio());
				c.sposta(0, -10);
				ec.aggiungi(c);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				gc.drawOval(c.getCentro().getX(),c.getCentro().getY(), c.getRaggio(), c.getRaggio());
				
			}
		});
		btnNewButton_1.setBounds(203, 416, 75, 25);
		btnNewButton_1.setText("^");
		
		Button btnNewButton_2 = new Button(shlSnake, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GC gc= new GC(canvas);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
				gc.drawOval(c.getCentro().getX(),c.getCentro().getY(), c.getRaggio(), c.getRaggio());
				c.sposta(0, +10);
				ec.aggiungi(c);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				gc.drawOval(c.getCentro().getX(),c.getCentro().getY(), c.getRaggio(), c.getRaggio());
			}
		});
		btnNewButton_2.setBounds(203, 456, 75, 25);
		btnNewButton_2.setText("v");
		
		Button btnNewButton_3 = new Button(shlSnake, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				GC gc= new GC(canvas);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
				gc.drawOval(c.getCentro().getX(),c.getCentro().getY(), c.getRaggio(), c.getRaggio());
				c.sposta(-10, 0);
				ec.aggiungi(c);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				gc.drawOval(c.getCentro().getX(),c.getCentro().getY(), c.getRaggio(), c.getRaggio());
			}
		});
		btnNewButton_3.setBounds(111, 435, 75, 25);
		btnNewButton_3.setText("<");
		
		Button btnNewButton_4 = new Button(shlSnake, SWT.NONE);
		btnNewButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GC gc= new GC(canvas);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
				gc.drawOval(c.getCentro().getX(),c.getCentro().getY(), c.getRaggio(), c.getRaggio());
				c.sposta(+10, 0);
				ec.aggiungi(c);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				gc.drawOval(c.getCentro().getX(),c.getCentro().getY(), c.getRaggio(), c.getRaggio());
			}
		});
		btnNewButton_4.setBounds(294, 435, 75, 25);
		btnNewButton_4.setText(">");


	}
}
