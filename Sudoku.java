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
   


	soln = board; 
    }

    public void remove(){
    }

    public void solver(){
    }

    public void checker(){
    }

    public void printSoln(){ 
    }

    public String toString(){
    }

}
