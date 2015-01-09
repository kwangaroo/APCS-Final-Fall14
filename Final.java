import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Final{
    public Final(){
	JFrame frame = new JFrame("Sudoku");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	frame.add(new JLabel("Difficulty Level"));
	DefaultComboBoxModel model = new DefaultComboBoxModel();
	model.addElement("Easy");
	model.addElement("Medium");
	model.addElement("Hard");
	JComboBox comboBox = new JComboBox(model);
	
	//creates a menu bar
	JMenuBar menu = new JMenuBar();
	menu.setOpaque(true);
	menu.setBackground(new Color(154,165,127));
	menu.setPreferredSize(new Dimension(900,900));
	
	//creates label to put in content pane
	JLabel label = new JLabel();
	label.setOpaque(true);
	label.setBackground(new Color(248,213,131));
	label.setPreferredSize(new Dimension(900,180));
	
	frame.setJMenuBar(menu);
	frame.getContentPane().add(comboBox);
	frame.getContentPane().add(label, BorderLayout.CENTER);

	frame.pack();
	frame.setVisible(true);
	
    }
    
    public static void main(String[]args){
	Final g = new Final();
    }
}
			   
    