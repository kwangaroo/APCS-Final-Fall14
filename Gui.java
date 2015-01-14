import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame implements ActionListener{
    private Container pane;
    private JButton check, easy, medium, hard, solution;
    private JTextField f[][] = new JTextField[9][9];
    private JPanel p[][] = new JPanel[3][3];
    private JLabel difficulty;

    public Gui(){
	this.setTitle("Sudoku");
	this.setSize(900,900);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	JPanel p = new JPanel      (new GridLayout());

	for(int i=0;i<9; i++){
	    for(int j=0;j<9;j++){
		f[i][j] = new JTextField(1);
	    }
	}
	for(int i=0;i<3;i++){
	    for(int j=0;j<3;j++){
		p[i][j] = new JPanel(new GridLayout(3,3));
	    }
	}
	
	p.setLayout(new GridLayout(3,3,5,5));

	for(int i=0; i<3; i++){
	    for(int j=0;j<3;j++){
		for(int x=0;x<3;x++){
		    for(int y =0; y<3;y++){
			p[i][j].add(f[y+i*3][x+j*3]);
		    }
		}
	    }
	}

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