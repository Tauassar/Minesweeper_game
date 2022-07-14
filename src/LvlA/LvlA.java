package LvlA;

import java.util.Random;
import java.util.Scanner;

public class LvlA{
	
	protected int N_MINES = 9;
	protected int N_ROWS = 9;
    protected int N_COLS = 9;
    protected char COVER = 10;
	
    protected char[][] grid=new char[N_ROWS][N_COLS];
    protected int[][] Board=new int[N_ROWS][N_COLS];
    
    Scanner scan=new Scanner(System.in);
    
    public static void main(String[] args) {
    	LvlA st=new LvlA();
    	st.play();
    }
	 
	 public void play() {
	 createSkull();
	 createSkin();
	while(true) {
		if(checkWin()==true) {
			System.out.println("You won!!\nCongrats!!!\nWould you like to play again? (1/0):");
			int decision;
			decision=scan.nextInt();
			if(decision==1)
				 play();
			else
				break;
		}
		System.out.println();
	printGrid();
	System.out.println("Enter your move (row[1-9] column[1-9]): ");
	int n1=0;
	int n2=0;
 try {
		n1=scan.nextInt();
		n2=scan.nextInt();
		if((n1<1)||(n1>9)||(n2<1)||(n2>9)) {
			throw new Exception();}}
	catch (Exception e) { System.out.println("You have entered the wrong input, please try again");
	scan.next();
	continue;}
		 n1--;
		 n2--;
		//open zeros
	if(getBoard()[n1][n2]==0) {
		zeros(n1,n2);
			}
	grid[n1][n2]=Character.forDigit(getBoard()[n1][n2], getN_MINES()+1);
	
		//open bomb
	if(getBoard()[n1][n2]==-1) {
		openBombs();
		printGrid();
		System.out.println("Oops! You lose. Would you like to play again? (1/0):");
		int decision;
		decision=scan.nextInt();
		if(decision==1)
			 play();
		else
			break;
			}
		}
	 }
	 	
	 	
	 protected void printGrid() {
			for(int a=0;a<9;a++) {
				for(int z=0;z<9;z++) {
					System.out.print(grid[a][z]+" ");
				}
				System.out.println();}
		}

	protected void zeros(int n1, int n2) {
		 if(grid[n1][n2]=='#') {
			 if(getBoard()[n1][n2]==0) {
				 grid[n1][n2]=Character.forDigit(getBoard()[n1][n2], getN_MINES()+1);
				 if(n2<8)
					zeros(n1,n2+1);
				 if(n2>0)
					 zeros(n1,n2-1);
				 if(n1<8)
					zeros(n1+1,n2);
				 if(n1>0)
					zeros(n1-1,n2);
				 if(n1<8&&n2<8)
					zeros(n1+1,n2+1);
				 if(n1<8&&n2>0)
					zeros(n1+1,n2-1);
				 if(n1>0&&n2<8)
					zeros(n1-1,n2+1);
				 if(n1>0&&n2>0)
					zeros(n1-1,n2-1);
						}
				 else {
					 grid[n1][n2]=Character.forDigit(getBoard()[n1][n2], getN_MINES()+1); 
				 }
		 }	 
	 }
	 	protected boolean checkWin() {
	 		int counter=0;
	      	 for (int i = 0; i < N_ROWS; i++) {
	               for (int j = 0; j < N_COLS; j++) {
	            	   if(grid[i][j]=='#') 
	            		   counter++;
	               }
	      	 }	      
	      	 if(counter==10)
	      		 return true;
	      	 else
	      		 return false;
	      }
	 	public void createSkin() {
			for(int a=0;a<9;a++) {
				for(int z=0;z<9;z++) {
					grid[a][z]='#';
				}
			}
	 	}
		 public void openBombs(){
			 for(int i=0;i<N_ROWS;i++) {
					for(int k=0;k<N_COLS;k++) {
						if(getBoard()[i][k]==-1) {
							grid[i][k]='B';
						}
					}
			 }
		 }
		 	public void placeBombs(){
				Random random = new Random();
				for(int i=0;i<=getN_MINES();i++) {
		    		int x=random.nextInt(N_ROWS);
		    		int y=random.nextInt(N_COLS);
		    		if(getBoard()[x][y]==-1)
		    			i--;
		    		if(getBoard()[x][y]!=-1)
		    			getBoard()[x][y]=-1;
		    		}
				 }
			 public void clearSkull(){
				 for(int i=0;i<N_ROWS;i++) {
						for(int k=0;k<N_COLS;k++) {
							Board[i][k]=0;
						}
				 }
			 }
			 public void createSkull(){
				 clearSkull();
				 placeBombs();
				 for(int i=0;i<N_ROWS;i++) {
						for(int k=0;k<N_COLS;k++) {
							int counter=0;
							if(getBoard()[i][k]==-1)
								continue;
							else {
								if((i>0)&&(getBoard()[i-1][k]==-1))
									counter++;	
								if((i>0)&&(k<N_COLS-1)&&(getBoard()[i-1][k+1]==-1))
									counter++;	
								if((k>0)&&(getBoard()[i][k-1]==-1))
										counter++;
								if((i>0)&&(k>0)&&(getBoard()[i-1][k-1]==-1))
										counter++;	
								if((k>0)&&(i<N_ROWS-1)&&(getBoard()[i+1][k-1]==-1))
										counter++;
								if((i<N_ROWS-1)&&(getBoard()[i+1][k]==-1))
										counter++;	
								if((i<N_ROWS-1)&&(k<N_COLS-1)&&(getBoard()[i+1][k+1]==-1))
										counter++;
								if((k<N_COLS-1)&&(getBoard()[i][k+1]==-1))
										counter++;				
							getBoard()[i][k]=counter;
						}
					}}
			 }

			public int[][] getBoard() {
				return Board;
			}

			public void setBoard(int[][] board) {
				Board = board;
			}

			public int getN_MINES() {
				return N_MINES;
			}

			public void setN_MINES(int n_MINES) {
				N_MINES = n_MINES;
			}
			
}
