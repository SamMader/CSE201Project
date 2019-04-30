package CSE201;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RateBox extends JDialog implements ActionListener{

	private static final long serialVersionUID = 7268746291077216157L;
	private final JPanel contentPanel = new JPanel();
	
	private ApplicationEntry a;
	private User u;

	public RateBox() {
		setBounds(100, 100, 340, 152);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton buttonOne = new JButton("1");
			buttonOne.setBounds(12, 40, 50, 25);
			buttonOne.addActionListener(this);
			buttonOne.setActionCommand("ONE");
			contentPanel.add(buttonOne);
		}
		{
			JButton buttonTwo = new JButton("2");
			buttonTwo.setBounds(74, 40, 50, 25);
			buttonTwo.addActionListener(this);
			buttonTwo.setActionCommand("TWO");
			contentPanel.add(buttonTwo);
		}
		{
			JButton buttonThree = new JButton("3");
			buttonThree.setBounds(136, 40, 50, 25);
			buttonThree.addActionListener(this);
			buttonThree.setActionCommand("THREE");
			contentPanel.add(buttonThree);
		}
		{
			JButton buttonFour = new JButton("4");
			buttonFour.setBounds(198, 40, 50, 25);
			buttonFour.addActionListener(this);
			buttonFour.setActionCommand("FOUR");
			contentPanel.add(buttonFour);
		}
		{
			JButton buttonFive = new JButton("5");
			buttonFive.setBounds(260, 40, 50, 25);
			buttonFive.addActionListener(this);
			buttonFive.setActionCommand("FIVE");
			contentPanel.add(buttonFive);
		}
	}
	
	
	
	public void getApplication(ApplicationEntry b) {
		a = b;
	}

	public void getUser(User x) { 
		u = x;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if (cmd == "ONE") {
			a.calculateRating(1);
			a.rated.add(u);
			this.setVisible(false);
			this.dispose();
		}
		else if (cmd == "TWO") {
			a.calculateRating(2);
			a.rated.add(u);
			this.setVisible(false);
			this.dispose();
		}
		else if (cmd == "THREE") {
			a.calculateRating(3);
			a.rated.add(u);
			this.setVisible(false);
			this.dispose();
		}
		else if (cmd == "FOUR") {
			a.calculateRating(4);
			a.rated.add(u);
			this.setVisible(false);
			this.dispose();
		}
		else if (cmd == "FIVE") {
			a.calculateRating(5);
			a.rated.add(u);
			this.setVisible(false);
			this.dispose();
		}
	}

}
