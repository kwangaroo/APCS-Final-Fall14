import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Interface extends JFrame implements ActionListener{
    private JTextField blank[][] = new JTextField[9][9];
    private JPanel grid[][] = new JPanel[3][3];
	private JButton check, easy, medium, hard, solution;
	private JLabel num;

	public Interface(){
		setTitle("Sudoku");
		getContentPane().add(createTopPanel(), BorderLayout.NORTH);
		getContentPane().add(createCenterPanel(), BorderLayout.CENTER);
		setMinimumSize(new Dimension(450,450));
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

	public JPanel createCenterPanel(){
		JPanel centerPanel = new JPanel(new GridLayout(3,3,5,5));

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
			    centerPanel.add(grid[i][j]);
			}
	    }
		return centerPanel;
	}

    public JPanel createEasyPanel(){
	Sudoku a = new Sudoku(1);
	a.fillBoard();
	a.remove(a.getBoard());
	int [][] board = a.getBoard();
	
	JPanel easyPanel = new JPanel (new GridLayout(3,3,5,5));
		
	for(int i=0;i<9;i++){
	    for(int j=0;j<9;j++){
		if(board[i][j] == 0){
		    blank[i][j] = new JTextField(1);
		}else{
		    blank[i][j]= new JTextField("" + board[i][j]);
		    blank[i][j].setEditable(false);
		}
	    }
	}
	
	for(int i=0;i<3;i++){
		    for(int j=0;j<3;j++){
			grid[i][j] = new JPanel(new GridLayout(3,3));
		    }
	}
	
	for(int i=0;i<3;i++){
	    for(int j=0;j<3;j++){
		for(int x=0;x<3;x++){
			    for(int y=0;y<3;y++){
				grid[i][j].add(blank[y+i*3][x+j*3]);
			    }
		}
		easyPanel.add(grid[i][j]);
	    }
	}
	return easyPanel;
    }
    
    public JPanel createHardPanel(){
	Sudoku a = new Sudoku(2);
	a.fillBoard();
	a.remove(a.getBoard());
	int [][] board = a.getBoard();
		
	JPanel hardPanel = new JPanel (new GridLayout(3,3,5,5));
	
	for(int i=0;i<9;i++){
	    for(int j=0;j<9;j++){
		if(board[i][j] == 0){
			    blank[i][j] = new JTextField(1);
		}else{
		    blank[i][j]= new JTextField("" + board[i][j]);
		    blank[i][j].setEditable(false);
		}
	    }
	}
		
	for(int i=0;i<3;i++){
	    for(int j=0;j<3;j++){
		grid[i][j] = new JPanel(new GridLayout(3,3));
	    }
		}
	
	for(int i=0;i<3;i++){
	    for(int j=0;j<3;j++){
		for(int x=0;x<3;x++){
		    for(int y=0;y<3;y++){
			grid[i][j].add(blank[y+i*3][x+j*3]);
		    }
			}
		hardPanel.add(grid[i][j]);
	    }
	}
	return hardPanel;
    }

    public JPanel createMediumPanel(){
	Sudoku a = new Sudoku(2);
	a.fillBoard();
	a.remove(a.getBoard());
	int [][] board = a.getBoard();
	
	JPanel medPanel = new JPanel (new GridLayout(3,3,5,5));
		
	for(int i=0;i<9;i++){
	    for(int j=0;j<9;j++){
		if(board[i][j] == 0){
		    blank[i][j] = new JTextField(1);
		}else{
		    blank[i][j]= new JTextField("" + board[i][j]);
		    blank[i][j].setEditable(false);
		}
	    }
	}
	for(int i=0;i<3;i++){
	    for(int j=0;j<3;j++){
		grid[i][j] = new JPanel(new GridLayout(3,3));
	    }
	}
	
	for(int i=0;i<3;i++){
	    for(int j=0;j<3;j++){
		for(int x=0;x<3;x++){
		    for(int y=0;y<3;y++){
			grid[i][j].add(blank[y+i*3][x+j*3]);
		    }
		}
		medPanel.add(grid[i][j]);
	    }
	}
	return medPanel;
    }
    
    public void actionPerformed(ActionEvent e){
		String action = e.getActionCommand();
		//if (action.equals("Check"){
		//if(action.equals("solution"){
		if(action.equals("easy")){
		    getContentPane().remove(createCenterPanel());
		    getContentPane().add(createEasyPanel(), BorderLayout.CENTER);
		    getContentPane().invalidate();
		    getContentPane().validate();
		}
		if(action.equals("medium")){
		    getContentPane().remove(createCenterPanel());
		    getContentPane().add(createMediumPanel(), BorderLayout.CENTER);
		    getContentPane().invalidate();
		    getContentPane().validate();
		} 
		if(action.equals("hard")){
		    getContentPane().remove(createCenterPanel());
		    getContentPane().add(createMediumPanel(), BorderLayout.CENTER);
		    getContentPane().invalidate();
		    getContentPane().validate();
		}		
			
    }
}
