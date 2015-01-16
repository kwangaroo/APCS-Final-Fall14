import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Final extends JFrame implements ActionListener{
    private JTextField blank[][] = new JTextField[9][9];
    private JPanel grid[][] = new JPanel[3][3];
    private JButton check, easy, medium, hard, solution;
    
    
    

    public Final(){
	super("Sudoku");

	setLayout(new FlowLayout());
	JToolBar toolBar = new JToolBar("Menu");
	makeButtons(toolBar);
	setPreferredSize(new Dimension(450,130));
	add(toolBar, BorderLayout.PAGE_START );
      
	public void makeBoard(){
	    for(int i=0;i<9;i++){
		for(int j=0;j<9;j++){
		    blank[i][j] = new JTextField(1);
		}
	    }
	
	    for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
		    grid[i][j] = new JPanel(new GridLayout(3,3));
		}
	    }

	    for(int i=0; i<3; i++){
		for(int j=0;j<3;j++){
		    for(int x=0;x<3;x++){
			for(int y =0; y<3;y++){
			    grid[i][j].add(blank[y+i*3][x+j*3]);
			}
		    }
		    add(grid[i][j]);
		}
	    }
	    
	}

	setLayout(new GridLayout(3,3,5,5));
	setSize(450,450);
	setLocation(500,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void makeButtons(JToolBar toolBar){
       	check = new JButton("Check your solution!");
	easy = new JButton("Easy");
	medium = new JButton("Medium");
	hard = new JButton("Hard");
	solution = new JButton("Show a Solution");
	toolBar.add(check);
	toolBar.add(easy);
	toolBar.add(medium);
	toolBar.add(hard);
	toolBar.add(solution);

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
    }

    public void actionPerformed(ActionEvent e){
    }
}
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         