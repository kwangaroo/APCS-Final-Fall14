import java.util.*;
public class Sudoku{ 
    private int difficulty;
    int[][]board;
    int[][]soln;
    Random r = new Random(); 

    public Sudoku(){
	this(9, 2);
    }

    public Sudoku(int size, int diff){
	board = int[size][size];
	difficulty = diff;
	//1 is easy, 2 is medium, 3 is hard
    }

    public void fillBoard(){
     	init=new int[9][9]{
	    {1,2,3,4,5,6,7,8,9},
	    {4,5,6,7,8,9,1,2,3},
	    {7,8,9,1,2,3,4,5,6},
	    {2,3,4,5,6,7,8,9,1},
	    {5,6,7,8,9,1,2,3,4},
	    {8,9,1,2,3,4,5,6,7},
	    {3,4,5,6,7,8,9,1,2},
	    {6,7,8,9,1,2,3,4,5},
	    {9,1,2,3,4,5,6,7,8}
	};
	scramblerows(init);
	scramblecols(init); 
	//begin with classic board, 3x3 box in top left is 1 2 3 / 4 5 6 / 7 8 9 
	//helper functions that would go through rows and randomly swap them with a random other row in that group 
	//same with columns, maybe diagonals
	//after row swap function, use the checker: if false then call the rowswap again
	soln = board; 
    }

    public void scramblerows(int[][]a){
	int rownum = r.nextInt(9); 
	int[]save;
	save = new int[9];
	for(int i=0;i<9;i++){
	    save[i] = a[rownum][i];
	}
	int switchwith = r.nextInt(3) - 2;
	for(int i=0;i<9;i++){
	    a[rownum][i]=a[rownum+switchwith][i];
	}
    }

    public void remove(){
	//difficulty means that the probability that a number will be removed
	//easy: 30% chance
	//medium: 50% chance
	//hard: 70% chance 
	//for loop that goes through rows and columns. if there is something there, do the random check & remove & go on
	//minimum 1 or 2 in each row/col/group box
   }

    public void solver(){
    }

    public boolean checker(){
	//for loop going through rows/cols/groups 
	//inside is an arrayList {1,2,3,4,5,6,7,8,9} 
	//remove as you go through, if false stop the whole thing
    }

    public void printSoln(){ 
    }

    public String toString(){
    }

}
