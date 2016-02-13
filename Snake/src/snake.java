import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

public class snake {

	protected Shell shlSnake;
	private Text text;

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
		shlSnake.setSize(536, 456);
		shlSnake.setText("SNAKE");
		
		Canvas canvas = new Canvas(shlSnake, SWT.NONE);
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		canvas.setBounds(10, 10, 500, 350);
		
		text = new Text(shlSnake, SWT.BORDER);
		text.setBounds(10, 380, 210, 30);
		
		Button btnNewButton = new Button(shlSnake, SWT.NONE);
		btnNewButton.setBounds(226, 380, 170, 30);
		btnNewButton.setText("START");
		btnNewButton.setText("New Button");
		
		Label lblScore = new Label(shlSnake, SWT.NONE);
		lblScore.setBounds(415, 380, 95, 30);
		lblScore.setText("SCORE");


	}
}
