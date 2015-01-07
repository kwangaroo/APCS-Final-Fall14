public class Sudoku{ 
    private int difficulty;
    int[][]board;
    int[][]soln;

    public Sudoku(){
	this(9, 2);
    }

    public Sudoku(int size, int diff){
	board = int[size][size];
	difficulty = diff;
	//1 is easy, 2 is medium, 3 is hard
    }

    public void fillBoard(){
	int[][]init; 

	//begin with classic board, 3x3 box in top left is 1 2 3 / 4 5 6 / 7 8 9 
	//helper functions that would go through rows and randomly swap them with a random other row in that group 
	//same with columns, maybe diagonals
	//after row swap function, use the checker: if false then call the rowswap again

	soln = board; 
    }

    public void remove(){
    }

    public void solver(){
    }

    public boolean checker(){
    }

    public void printSoln(){ 
    }

    public String toString(){
    }

}
