import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Interface extends JFrame implements ActionListener{
	private JButton check, easy, medium, hard, solution;

	public Interface(){
		setTitle("Sudoku");
		//getContentPane().add(createCenterPanel(), BorderLayout.CENTER);
		getContentPane().add(createTopPanel(), BorderLayout.NORTH);
		setMinimumSize(new Dimension(600,300));
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JPanel createTopPanel(){
		JPanel topPanel = new JPanel(new GridBagLayout());

		check = new JButton("Check your solution!");
		easy = new JButton("Easy");
		medium = new JButton("Medium");
		hard = new JButton("Hard");
		solution = new JButton("Show a Solution");

		check.setActionCommand("Check");
		check.addActionListener(this);
		easy.setActionCommand("easy");
		easy.addActionListener(this);
		medium.setActionCommand("medium");
		medium.addActionListener(this);
		hard.setActionCommand("hard");
		hard.addActionListener(this);
		solution.setActionCommand("solution");
		solution.addActionListener(this);

	//	topPanel.add(new JSeparator(JSeparator.VERTICAL));
		topPanel.add(easy);
		topPanel.add(medium);
		topPanel.add(hard);
		topPanel.add(check);
		topPanel.add(solution);		

		topPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		return topPanel;
	}

//	public JPanel createCenterPanel(){
	//}

	
	public JLabel createLabel(String text){
		JLabel label = new JLabel(text);
		label.setHorizontalAlignment(JLabel.CENTER);
		return label;
	}

    public void actionPerformed(ActionEvent e){
    }
}
