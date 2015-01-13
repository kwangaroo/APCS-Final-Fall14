import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame implements ActionListener{
    private Container pane;
    private JButton check, easy, medium, hard, solution;
    private JTextField f[][];
    private JPanel p[][];
    private JLabel difficulty;

    public Gui(int size){
	this.setTitle("Sudoku");
	this.setSize(900,900);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	setLayout(new GridLayout());
	f = new JTextField[size][size];
	p = new JPanel[(int)Math.sqrt((double)size)][(int)Math.sqrt((double)size)];

	for(int i=0;i<size; i++){
	    for(int j=0;j<size;j++){
		f[i][j] = new JTextField(1);
	    }
	}
	for(int i=0;i<Math.sqrt((double)size);i++){
	    for(int j=0;j<Math.sqrt((double)size);j++){
		p[i][j] = new Jpanel(new GridLayout(Math.sqrt((double)size), Math.sqrt((double)size)));
	    }
	}
	
	setLayout(new GridLayout(sqrt((double)size), sqrt((double)size), size, size));

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
	Gui g = new Gui(3);
	g.setVisible(true);
    }
 }