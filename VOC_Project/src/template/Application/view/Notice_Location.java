package template.Application.view;
import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Notice_Location extends JDialog {

	private final JPanel pn_Location = new JPanel();


	/**
	 * Create the dialog.
	 */
	public Notice_Location() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pn_Location.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pn_Location, BorderLayout.CENTER);
		pn_Location.setLayout(new BorderLayout(0, 0));
		{
			JPanel pn_TheaterLocationImage = new JPanel();
			pn_Location.add(pn_TheaterLocationImage, BorderLayout.CENTER);
		}
	}

}
