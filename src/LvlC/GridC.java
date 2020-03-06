package LvlC;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import LvlB.Grid;

public class GridC extends Grid {
    protected PositionC g=new PositionC();
    protected final JLabel turnbar;
    protected static boolean turn=false;
    protected static int score1;
    protected static int score2;
	public String p1;
	public String p2;
    
    
    
        public GridC(String p1,String p2,JLabel statusbar, JLabel turnbar) {
        super();
        this.p1=p1;
        this.p2=p2;
    	this.statusbar = statusbar;
    	this.turnbar = turnbar;
        initBoard();
    }
        public GridC(String p1,String p2,int check, JLabel statusbar, JLabel turnbar, int rows, int cols, int bombs) {
        super();
        this.p1=p1;
        this.p2=p2;
    	this.statusbar = statusbar;
    	this.turnbar = turnbar;
    	changeParameters(rows,cols,bombs);
        initBoard();
    }
    protected void newGame() {
    	score1=0;
    	score2=0;
    	turn=false;
    	turnCounter();
    	minesLeft=g.getN_MINES()+1;
    	inGame=true;
		statusbar.setText("Marks left: "+minesLeft);
		
    	g.createSkull();
    	g.createSkin();
    }
    public void paintComponent(Graphics y) {
        for (int i = 0; i < g.get_ROWS(); i++) {
            for (int j = 0; j < g.get_COLS(); j++) {
                y.drawImage(img[g.getGrid()[i][j]], (j * CELL_SIZE),
                        (i * CELL_SIZE), this);                	
            }
        }
        statusB();
    }
    public void printMines() {
      	 for (int i = 0; i < g.get_ROWS(); i++) {
               for (int j = 0; j < g.get_COLS(); j++) {
              	if(g.getBoard()[i][j]==-1&&g.getGrid()[i][j]!=MARK)
              		g.getGrid()[i][j]=MINE;
              	else if(g.getBoard()[i][j]==-1&&g.getGrid()[i][j]==MARK)
              		g.getGrid()[i][j]=MARK;
              	else if(g.getBoard()[i][j]!=-1&&g.getGrid()[i][j]==MARK)
              		g.getGrid()[i][j]=WRONG_MARK;
               }
      	 }
      }
    protected void statusB() {
        String msg;
    	if (g.checkWin()==true && inGame) {
            inGame = false;
            statusbar.setText("You win. Congrats!");
            if(score1>score2) {
            	msg=new String("Player "+p1+" won, Congrats!!!");
            }
            else if(score1<score2) {
            	msg=new String("Player "+p2+" won, Congrats!!!");
            } else {
            	msg=new String("Both players did well, you got equal scores");
            }
            turnbar.setText(msg);
        }
        	else if (inGame==false) {
            	if(turn==false)
            		msg=new String("Player "+p1+" lose, so sad :(");
            	else
            		msg=new String("Player "+p2+" lose, so sad :(");
                statusbar.setText("Oops! You lose");
                turnbar.setText(msg);
        	}
    }

    protected void click(MouseEvent e) {
    	int x = e.getX();
        int y = e.getY();
        int cCol = x / CELL_SIZE;
        int cRow = y / CELL_SIZE;
        
        if (inGame==false) {
            newGame();
            repaint();
        }
        
        if ((x < g.get_COLS() * CELL_SIZE) && (y < g.get_ROWS() * CELL_SIZE)) {
            if (e.getButton() == MouseEvent.BUTTON3) {
            	rightclick(cRow,cCol);
            } else {
            	leftclick(cRow,cCol);
            }
               repaint();
        }
        	GamePanel.screenScores(score1, score2);
    }
    protected void rightclick(int row, int col) {
        if (g.getGrid()[row][col]!=MARK&&g.getGrid()[row][col]==COVER) {
            if (minesLeft > 0) {
            	g.getGrid()[row][col]=MARK;
                minesLeft--;
                statusbar.setText("Marks left: "+minesLeft);
            } else {
                statusbar.setText("No marks left");
            }
        } else if(g.getGrid()[row][col]==MARK){

        	g.getGrid()[row][col]=COVER;
            minesLeft++;
            statusbar.setText("Marks left: "+minesLeft);
	    }
	}

	protected void leftclick(int row, int col) {
			if(g.getGrid()[row][col]!=MARK&&g.getGrid()[row][col]==COVER) {
						turnCounter();
				if(g.getBoard()[row][col]==-1) {
					inGame=false;
					g.getGrid()[row][col]=MINE;
					printMines();
				}
				if(g.getBoard()[row][col]!=-1) {
					if(g.getBoard()[row][col]==0) {
						g.zeros(row, col);
					}
					else {
						g.getGrid()[row][col]=g.getBoard()[row][col];
						scoreCounter();
					}
				}
			}
	}
    
	 static void scoreCounter() {
		 if(turn==false) {
	     		score1++;
	     	}
	     	else if(turn==true) {
	     		score2++;
	     	}
	 }
	 public int getScore_p1() {
		 return score1;
	 }
	 public int getScore_p2() {
		 return score2;
	 }
	 
	 void turnCounter() {
		 if(turn==false) {
     		turnbar.setText("It is "+p1+"'s turn");
     		turn=true;
     	}
     	else {
     		turnbar.setText("It is "+p2+"'s turn");
     		turn=false;
     	}
	 }
	 void changeParameters(int rows, int cols, int bombs){
	    	g.set_ROWS(rows);
	    	g.set_COLS(cols);
	    	g.setN_MINES(bombs);
	    	g.setBoard(new int[rows][cols]);
	    	g.setgrid(new int[rows][cols]);
	    	g.refreshZeros();
	    	BOARD_WIDTH = cols * CELL_SIZE + 1;
	    	BOARD_HEIGHT = rows * CELL_SIZE + 1;
	 }
}


