import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame implements ActionListener{
    private Container pane;
    private JButton check, easy, medium, hard, solution;
    private JTextField space; //number and location of spaces vary for each puzzle
    private JLabel difficulty;

    public Gui(){
	this.setTitle("Sudoku");
	this.setSize(900,900);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	
	check = new JButton("Check your solution!");
	easy = new JButton("Easy");
	medium = new JButton("Medium");
	hard = new JButton("Hard");
	solution = new JButton("Show a Solution");
	difficulty = new JLabel("Difficulty Level:", null, JLabel.CENTER);
	// initialize space textboxes ):

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

	pane.add(difficulty);
	pane.add(easy);
	pane.add(medium);
	pane.add(hard);
	pane.add(check);
	pane.add(solution);


    }
   
    public void actionPerformed(ActionEvent e){
    }
   
    public static void main(String[]args){
	Gui g = new Gui();
	g.setVisible(true);
    }
 }