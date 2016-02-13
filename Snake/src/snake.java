import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.widgets.Button;

import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.SWT;

public class snake {

	protected Shell shell;
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(163, 106, 75, 25);
		btnNewButton.setText("New Button");

		text = new Text(shell, SWT.BORDER);
		text.setBounds(79, 35, 76, 21);


	}
}
