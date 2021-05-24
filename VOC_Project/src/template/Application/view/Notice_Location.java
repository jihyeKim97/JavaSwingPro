package template.Application.view;
import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Notice_Location extends JDialog {

	private final JPanel pn_Location = new JPanel();
	Notice_main NM;


	/**
	 * Create the dialog.
	 */
	public Notice_Location(Notice_main NM) {
		this.NM = NM;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pn_Location.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pn_Location, BorderLayout.CENTER);
		pn_Location.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		pn_Location.add(lblNewLabel, BorderLayout.CENTER);
	}

}
