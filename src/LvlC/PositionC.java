package LvlC;

import LvlB.Position;

public class PositionC extends Position{
	 public void zeros(int n1, int n2) {
		 if(getGrid()[n1][n2]==COVER) {
			 if(getBoard()[n1][n2]==0) {
				 getGrid()[n1][n2]=getBoard()[n1][n2];
				 GridC.scoreCounter();
				 if(n2<finaly)
					zeros(n1,n2+1);
				 if(n2>0)
					 zeros(n1,n2-1);
				 if(n1<finalx)
					zeros(n1+1,n2);
				 if(n1>0)
					zeros(n1-1,n2);
				 if(n1<finalx&&n2<finaly)
					zeros(n1+1,n2+1);
				 if(n1<finalx&&n2>0)
					zeros(n1+1,n2-1);
				 if(n1>0&&n2<finaly)
					zeros(n1-1,n2+1);
				 if(n1>0&&n2>0)
					zeros(n1-1,n2-1);
						}
				 else {
					 GridC.scoreCounter();					 
					 getGrid()[n1][n2]=getBoard()[n1][n2]; 
				 }
		 }	 
	 }
	public void setGrid(int n1, int n2,int n3) {
		grid[n1][n2]=n3;
	}
}