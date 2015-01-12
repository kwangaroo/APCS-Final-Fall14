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
	for(int i=0;i<9;i++){
	    a[rownum+switchwith][i]=save[i];
	}
    }

    public void scramblecols(int[][]a){
	int colnum = r.NextInt(9);
	int[]save;
	save=new int[9];
	for(int i=0;i<9;i++){
	    save[i]=a[i][colnum];
	}
	int switchwith = r.nextInt(3) - 2;
	for(int i=0;i<9;i++){
	    a[i][colnum]=a[i][colnum+switchWith];
	}
	for(int i=0;i<9;i++){
	    a[i][colnum+switchWith]=save[i];
	}
    }

    public void remove(int[][]a){
	//difficulty means that the probability that a number will be removed
	//easy: 30% chance
	//medium: 50% chance
	//hard: 70% chance 
	//for loop that goes through rows and columns. if there is something there, do the random check & remove & go on
	//minimum 1 or 2 in each row/col/group box
	int chance = 30 + (difficulty*20);
	int save;
	for(int i=0;i<9;i++){
	    for(int j=0;j<9;j++){
		if(r.nextInt(100)+1 < chance){
		    a[i][j]=save;
		    a[i][j]=null;
		    if(!checker(a)){
			a[i][j]=save;
			//this is messy 
		    }
		}
	    }
	}
   }

    public void solver(){
    }

    public boolean checker(int[][]a){
	//for loop going through rows/cols/groups 
	//inside is an arrayList {1,2,3,4,5,6,7,8,9} 
	//remove as you go through, if false stop the whole thing
	int save;
	for(int i=0;i<9;i++){
	    ArrayList<Integer>base = new ArrayList<Integer>(){{
		    add(1);
		    add(2);
		    add(3);
		    add(4);
		    add(5);
		    add(6);
		    add(7);
		    add(8);
		    add(9);
		}}
	    for(int j=0;j<9;j++){
		a[i][j]=save;
		if(!base.remove(save)){
		    return false;
		}
		base.remove(save);
	    }
	}
	for(int i=0;i<9;i++){
	    ArrayList<Integer>base = new ArrayList<Integer>(){{
		    add(1);
		    add(2);
		    add(3);
		    add(4);
		    add(5);
		    add(6);
		    add(7);
		    add(8);
		    add(9);
		}}
	    for(int j=0;j<9;j++){
		a[j][i]=save;
		if(!base.remove(save)){
		    return false;
		}
		base.remove(save);
	    }
	}
	return true;
    }
    //also groups 

    public void printSoln(){ 
    }

    public String toString(){
    }

}
