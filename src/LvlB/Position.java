package LvlB;

import LvlA.LvlA;

public class Position extends LvlA{
	protected int[][] grid=new int[N_ROWS][N_COLS];
	protected int finalx=N_ROWS-1;
	protected int finaly=N_COLS-1;
	
    public void setgrid(int[][] grid) {
		this.grid= grid;
	}
    
	public int getN_MINES() {
		return N_MINES;
	}

	public void setN_MINES(int n_MINES) {
		N_MINES = n_MINES;
	}
	public int get_ROWS() {
		return N_ROWS;
	}

	public void set_ROWS(int n_ROWS) {
		N_ROWS = n_ROWS;
	}
	public void refreshZeros() {
		finalx=N_ROWS-1;
		finaly=N_COLS-1;
	}

	public int get_COLS() {
		return N_COLS;
	}

	public void set_COLS(int n_COLS) {
		N_COLS = n_COLS;
	}
	 public void zeros(int n1, int n2) {
		 if(getGrid()[n1][n2]==COVER) {
			 if(getBoard()[n1][n2]==0) {
				 getGrid()[n1][n2]=getBoard()[n1][n2];
				 if(n2<finalx)
					zeros(n1,n2+1);
				 if(n2>0)
					 zeros(n1,n2-1);
				 if(n1<finaly)
					zeros(n1+1,n2);
				 if(n1>0)
					zeros(n1-1,n2);
				 if(n1<finaly&&n2<finalx)
					zeros(n1+1,n2+1);
				 if(n1<finaly&&n2>0)
					zeros(n1+1,n2-1);
				 if(n1>0&&n2<finalx)
					zeros(n1-1,n2+1);
				 if(n1>0&&n2>0)
					zeros(n1-1,n2-1);
						}
				 else {
					 getGrid()[n1][n2]=getBoard()[n1][n2]; 
				 }
		 }	 
	 }
	    public boolean checkWin() {
	      	 for (int i = 0; i < get_ROWS(); i++) {
	               for (int j = 0; j < get_COLS(); j++) {
	              	if(getGrid()[i][j]==COVER)
	              		return false;
	               }
	      	 }
	      	 return true;
	      }
		 public void createSkin() {
		    	for(int i=0;i<get_ROWS();i++) {
		    		for(int k=0;k<get_COLS();k++) {
		    			getGrid()[i][k]=COVER;
		    			int counter=0;
		    			if(getBoard()[i][k]==-1)
		    				continue;
		    			else {
		    				if((i>0)&&(getBoard()[i-1][k]==-1))
		    					counter++;	
		    				if((i>0)&&(k<get_COLS()-1)&&(getBoard()[i-1][k+1]==-1))
		    					counter++;	
		    				if((k>0)&&(getBoard()[i][k-1]==-1))
		    						counter++;
		    				if((i>0)&&(k>0)&&(getBoard()[i-1][k-1]==-1))
		    						counter++;	
		    				if((k>0)&&(i<get_ROWS()-1)&&(getBoard()[i+1][k-1]==-1))
		    						counter++;
		    				if((i<get_ROWS()-1)&&(getBoard()[i+1][k]==-1))
		    						counter++;	
		    				if((i<get_ROWS()-1)&&(k<get_COLS()-1)&&(getBoard()[i+1][k+1]==-1))
		    						counter++;
		    				if((k<get_COLS()-1)&&(getBoard()[i][k+1]==-1))
		    						counter++;				
		    			getBoard()[i][k]=counter;
		    		}
		    	}}			 
		 }
		 public void openBombs(){
			 for(int i=0;i<getN_MINES();i++) {
					for(int k=0;k<getN_MINES();k++) {
						if(getBoard()[i][k]==-1) {
							getGrid()[i][k]=-1;
						}
					}
			 }
		 }

		public int[][] getGrid() {
			return grid;
		}
		 public void printBoard() {
				for(int a=0;a<9;a++) {
					for(int z=0;z<9;z++) {
						System.out.print(grid[a][z]+" ");
					}
					System.out.println();}
			}
}
