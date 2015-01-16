import java.util.*;
public class Sudoku{ 
    private int difficulty;
    int[][]board;
    int[][]soln= new int[9][];
    Random r = new Random(); 

    public Sudoku(){
	this(9, 2);
    }

    public Sudoku(int size, int diff){
	board = new int[size][];
	difficulty = diff;
	//1 is easy, 2 is medium, 3 is hard
    }

    public int[][] getBoard(){
	return board;   
    }

    public void fillBoard(){
	int[][]init=new int[][]{
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
        board = init;
	//HOW DO I INITIALIZE THIS OMG

	scramblerows();
	scramblecols(); 

	int[][]b = new int[9][];
	for(int i=0;i<9;i++){
	    for(int j=0;j<9;j++){
		b[i][j]=board[i][j];
	    }
	}
	soln=b;
	//begin with classic board, 3x3 box in top left is 1 2 3 / 4 5 6 / 7 8 9 
	//helper functions that would go through rows and randomly swap them with a random other row in that group 
	//same with columns, maybe diagonals
	//after row swap function, use the checker: if false then call the rowswap again
    }

    public void scramblerows(){
	int rownum = r.nextInt(9); 
	int[]save = new int[9];
	save = new int[9];
	for(int i=0; i<9; i++){
	    save[i] = board[rownum][i];
	}
	int switchWith = r.nextInt(3) - 2;
	for(int i=0; i<9; i++){
	    if(rownum+switchWith<9 && rownum+switchWith >= 0){
	    board[rownum][i]=board[rownum+switchWith][i];
	    }
	}
	for(int i=0; i<9; i++){
	    if(rownum+switchWith<9 && rownum+switchWith >= 0){
		board[rownum+switchWith][i]=save[i];
	    }
	}
    }

    public void scramblecols(){
	int colnum = r.nextInt(9);
	int[]save=new int[9];
	for(int i=0; i<9; i++){
	    save[i]=board[i][colnum];
	}
	int switchWith = r.nextInt(3) - 2;
	for(int i=0; i<9; i++){
	    if(colnum+switchWith >= 0 && colnum+switchWith < 9){
	    board[i][colnum]=board[i][colnum+switchWith];
	    }
	}
	for(int i=0; i<9; i++){
	    if(colnum+switchWith >= 0 && colnum+switchWith < 9){
	    board[i][colnum+switchWith]=save[i];
	    }
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
	int save = 0;
	for(int i=0; i<9; i++){
	    for(int j=0; j<9; j++){
		if(r.nextInt(100)+1 < chance){
		    a[i][j]=save;
		    a[i][j]=0; //no null for int, only for Integer -- we'll figure this out when we get to the GUI? maybe convert 0 to _ in toString
		    if(!checker(a)){
			a[i][j]=save;
			//this is messy 
		    }
		}
	    }
	}
   }

    public boolean checker(int[][]a){
	return (lineChecker(a) && checkGroups(a));
    }

    public boolean lineChecker(int[][]a){
	//for loop going through rows/cols/groups 
	//inside is an arrayList {1,2,3,4,5,6,7,8,9} 
	//remove as you go through, if false stop the whole thing
	int save=0;
	for(int i=0; i<9; i++){
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
		}}; 
	    for(int j=0; j<9; j++){
		a[i][j]=save;
		if(!base.contains(save)){
		    return false;
		}
		base.remove(save);
	    }
	}
	for(int i=0; i<9; i++){
	    ArrayList<Integer>base;
	    base = new ArrayList<Integer>(){{
		    add(1);
		    add(2);
		    add(3);
		    add(4);
		    add(5);
		    add(6);
		    add(7);
		    add(8);
		    add(9);
		}};
	    for(int j=0; j<9; j++){
		a[j][i]=save;
		if(!base.contains(save)){
		    return false;
		}
		base.remove(save);
	    }
	}
	return true;
    }
    //also groups 
    public boolean checkGroups(int[][]a){
	int save=0;
	for(int k=0; k<9; k+=3){
	    for(int m=0; m<9; m+=3){
		ArrayList<Integer>base;
		base = new ArrayList<Integer>(){{
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
			add(6);
			add(7);
			add(8);
			add(9);
		    }};
		for(int n=0; n<3; n++){
		    for(int o=0; o<3; o++){
			a[k+n][m+o]=save;
			if(!base.contains(save)){
			    return false;
			}
			base.remove(save);
		    }
		}
	    }
	}
	return true;
    }
    //3 nested for loops more like wow this can be done way more easily 
    //

    public String toString(int[][]a){
	String str="";
	int save =0;
	for(int i=0; i<9; i++){
	    for(int j=0; j<9; j++){
		save = a[i][j];
		if(save==0){
		    str+="_";
		}else{
		str+= "" + a[i][j];	
		}
	    }
	    str+="\n";
	}
	return str;
    }

    public int[][] getSoln(){
	return soln;
    }

    public void printSoln(){ 
	System.out.println(toString(getSoln()));
    }
    public void printBoard(){
	System.out.println(toString(getBoard()));
    }

    public static void main(String[]args){
	Sudoku b = new Sudoku(9,1);
	b.fillBoard();
	b.remove(b.getBoard());
	System.out.println("EASY:\n");
	b.printBoard();
	Sudoku a = new Sudoku(); 
	a.fillBoard();
	a.remove(a.getBoard());
	System.out.println("MEDIUM:\n");
	a.printBoard();
	Sudoku c = new Sudoku(9,3);
	c.fillBoard();
	c.remove(c.getBoard());
	System.out.println("HARD:\n");
	//	c.printSoln();
	c.printBoard();
    }

}

//THIS COMPILES
//THIS WORKS
//i'd like to thank the academy, tina zhang, sashasharks, tea 'n' a coffee, stackoverflow, and also Jesus
