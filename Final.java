import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Final extends JFrame{
	private JTextField blank[][] = new JTextField[9][9];
	private JPanel grid[][] = new JPanel[3][3];
	
    public Final(){
	super("Sudoku");

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

	setLayout(new GridLayout(3,3,5,5));
	setSize(450,450);
	setLocation(500,100);

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
    
    public static void main(String[]args){
	Final g = new Final();
	g.setVisible(true);
    }
}