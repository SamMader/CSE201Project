package CSE201;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommentBox extends JDialog implements ActionListener {

	private static final long serialVersionUID = -1143588213979856124L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private ApplicationEntry a;

	/**
	 * Create the dialog.
	 */
	public CommentBox() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 33, 432, 185);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblComment = new JLabel("Comment");
		lblComment.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblComment.setBounds(167, 0, 130, 29);
		contentPanel.add(lblComment);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("CANCEL");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if (cmd == "OK") {
			int x = textField.getText().length();
			if (x <= 256) {
				a.addComment(textField.getText());
				this.setVisible(false);
				this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(this, "Comment is too long!");
				textField.setText("");
			}
		}
		else if (cmd == "CANCEL") {
			this.setVisible(false);
			this.dispose();
		}
	}
	
	public void getApplication(ApplicationEntry b) {
		a = b;
	}
	
}
