import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.widgets.Button;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;



public class snake implements java.io.Serializable{

	protected Shell shlSnake;
	private Text text;
	Canvas canvas;
	private int BASECANVAS = 500;
	private int ALTCANVAS = 350;
	Cerchio serpente = new Cerchio();
	char c = 'd';
	Random ran = new Random();
	Cerchio mela;
	GC gc;
	int i = 0;
	Label label;
	private boolean ris = false;

	/**
	 * Launch the application.
	 * 
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
	
	public void setInterval(int time){
		try {
			Thread.sleep(time);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		muovi(serpente);	
	}

	/**
	 * Open the window.
	 */

	
	public void muovi(Cerchio serpente){
		System.out.println(c);
		switch(c){
		case 'd':
            elimina();
			serpente.sposta(+10, 0);
            serpente();
            if(serpente.getCentro().getX()>480){
            	
            	elimina();
            	serpente.setCentro(new Punto(10,serpente.getCentro().getY()));
    			serpente.sposta(+10, 0);
            }
            collisione();         
			break;
			
		case 's':
            elimina();
			serpente.sposta(-10, 0);
			serpente();
			if(serpente.getCentro().getX()<5){
            	
            	elimina();
            	serpente.setCentro(new Punto(475,serpente.getCentro().getY()));
    			serpente.sposta(+10, 0);
            }
            collisione();
			break;
			
		case 'a':
            elimina();
			serpente.sposta(0, -10);
			serpente();
			if(serpente.getCentro().getY()<5){
            	
            	elimina();
            	serpente.setCentro(new Punto(serpente.getCentro().getX(),340));
    			serpente.sposta(0, -10);
            }
            collisione();       
			break;
			
		case 'b':
            elimina();
			serpente.sposta(0, +10);
			serpente();
			if(serpente.getCentro().getY()>345){
            	
            	elimina();
            	serpente.setCentro(new Punto(serpente.getCentro().getX(),5));
    			serpente.sposta(0, +10);
            }
            collisione();            
			break;
		}	
	}
	
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlSnake.open();
		shlSnake.layout();
		while (!shlSnake.isDisposed()) {
			if (!display.readAndDispatch()) {	
				if(ris == true){
				setInterval(80);
				}
			}
		}}
	
	
	public void collisione(){
		
		boolean ris=false;
		for(int i=0; i<10; i++){
			System.out.println(mela.getCentro().getX() +"-"+ serpente.getCentro().getX() +"-"+ mela.getCentro().getY() +"-"+serpente.getCentro().getY());
			
		if (mela.getCentro().getX() == serpente.getCentro().getX() && mela.getCentro().getY() == serpente.getCentro().getY()){
			ris = true;
			break;
		}if (mela.getCentro().getX()+i == serpente.getCentro().getX() && mela.getCentro().getY() == serpente.getCentro().getY()){
		    ris = true;
		    break;
		}if (mela.getCentro().getX() == serpente.getCentro().getX() && mela.getCentro().getY()+i == serpente.getCentro().getY()){
		    ris = true;
		    break;
		}if( mela.getCentro().getX()-i == serpente.getCentro().getX() && mela.getCentro().getY() == serpente.getCentro().getY()){
			ris = true;
			break;
		}if (mela.getCentro().getX() == serpente.getCentro().getX() && mela.getCentro().getY()-1 == serpente.getCentro().getY()){
			ris = true;
			break;
		}if (mela.getCentro().getX()+i == serpente.getCentro().getX() && mela.getCentro().getY()+i == serpente.getCentro().getY()){
			ris = true;
			break;
		}if (mela.getCentro().getX()-i == serpente.getCentro().getX() && mela.getCentro().getY()-i == serpente.getCentro().getY()){
			ris = true;
			break;
		}
		}
		if(ris == true){
			i = i + 10;
			eliminaMela();
			mele();
			label.setText(i + "");
		}
	}
	
	public void elimina(){
		gc = new GC(canvas);
		gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		gc.fillOval(serpente.getCentro().getX(), serpente.getCentro().getY(), serpente.getRaggio(), serpente.getRaggio());
		gc.drawOval(serpente.getCentro().getX(), serpente.getCentro().getY(), serpente.getRaggio(), serpente.getRaggio());
	}
	
	public void eliminaMela(){
		gc = new GC(canvas);
		gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		gc.fillOval(mela.getCentro().getX(), mela.getCentro().getY(), mela.getRaggio(), mela.getRaggio());
		gc.drawOval(mela.getCentro().getX(), mela.getCentro().getY(), mela.getRaggio(), mela.getRaggio());
	}
	
	public void mele(){
		int x= ran.nextInt(50)*10;
		int y= ran.nextInt(35)*10;
		mela = new Cerchio(new Punto(x,y), 5);
		gc = new GC(canvas);
		gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		gc.fillOval(x,y, mela.getRaggio(), mela.getRaggio());
		gc.drawOval(x,y, mela.getRaggio(), mela.getRaggio());
	}
	
	public void serpente(){
		gc = new GC(canvas);
		gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		gc.fillOval(serpente.getCentro().getX(), serpente.getCentro().getY(), serpente.getRaggio(), serpente.getRaggio());
		gc.drawOval(serpente.getCentro().getX(), serpente.getCentro().getY(), serpente.getRaggio(), serpente.getRaggio());
	}
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSnake = new Shell();
		shlSnake.setSize(536, 487);
		shlSnake.setText("SNAKE");

	    canvas = new Canvas(shlSnake, SWT.NONE);
	    canvas.addKeyListener(new org.eclipse.swt.events.KeyAdapter() {
	    	
	    	
	    @Override
	    	public void keyPressed(org.eclipse.swt.events.KeyEvent e) {
	    		switch(e.keyCode){
				case 16777217 :
					c= 'a';
					System.out.println(c);
				break;
				case 16777219:
					c = 's';
					System.out.println(c);
				break;
				
				case 16777218:
					c = 'b';
					System.out.println(c);
				break;
				case 16777220:
					c = 'd';
					System.out.println(c);
				}
	    	}
	    });
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		canvas.setBounds(10, 10, 500, 350);
	
		
	
		text = new Text(shlSnake, SWT.BORDER);
		text.setBounds(10, 366, 210, 30);

		Button btnNewButton = new Button(shlSnake, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

                //serpente();
				mele();
				ris = true;
				//muovi(c);
				
			}
		});
		btnNewButton.setBounds(226, 366, 170, 30);
		btnNewButton.setText("START");

		Label lblScore = new Label(shlSnake, SWT.NONE);
		lblScore.setBounds(436, 366, 49, 15);
		lblScore.setText("SCORE:");

		label = new Label(shlSnake, SWT.NONE);
		label.setBounds(436, 385, 45, 30);
		
		Button btnSave = new Button(shlSnake, SWT.NONE);
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					ris=false;
					ObjectOutputStream stream= new ObjectOutputStream(new FileOutputStream("record.txt"));
					stream.writeObject(i);
					stream.close();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnSave.setBounds(10, 407, 210, 30);
		btnSave.setText("SAVE");
		
		Button btnLoad = new Button(shlSnake, SWT.NONE);
		btnLoad.setBounds(226, 407, 170, 30);
		btnLoad.setText("LOAD");

	
}
}
