package LvlB;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Grid extends JPanel {
    protected Position g=new Position();
  //to import
    protected int NUM_IMAGES = 13;
    protected int CELL_SIZE = 15;
    //images
    protected int MINE = 9;
    protected int COVER = 10;
    protected int MARK = 11;
    protected int WRONG_MARK = 12;
    //board data
    protected int BOARD_WIDTH = g.get_ROWS() * CELL_SIZE + 1;
    protected int BOARD_HEIGHT = g.get_COLS() * CELL_SIZE + 1;
    public Dimension d;
    
    protected boolean inGame=false;
    protected int minesLeft;
    protected Image[] img;

    protected JLabel statusbar;
    
    protected Grid() {
    }
    protected Grid(JLabel statusbar) {
        this.statusbar = statusbar;
        initBoard();
    }

	protected void initBoard() {
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        img = new Image[NUM_IMAGES];
        loadImages(img);
        addMouseListener(new mouseClick());
        newGame();
    }
    protected void newGame() {
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

    protected void statusB() {
    	if (g.checkWin()==true && inGame) {
            inGame = false;
            statusbar.setText("You win. Congrats!");
        }
        	else if (inGame==false) {
            statusbar.setText("Oops! You lose");
        }
    }
    
    protected class mouseClick extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {

            click(e);
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
    }

	protected void leftclick(int row, int col) {
	    if(g.getGrid()[row][col]!=MARK&&g.getGrid()[row][col]==COVER) {
	    	if(g.getBoard()[row][col]==-1) {
	    		inGame=false;
	    		g.getGrid()[row][col]=MINE;
	    		printMines();
	    	}
	    	else {
	    		if(g.getBoard()[row][col]==0) {
	    			g.zeros(row, col);
	    		}
	    		else {
	    			g.getGrid()[row][col]=g.getBoard()[row][col];
	    		}
	    	}
	    }
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
    
    protected void loadImages(Image[] img) {

        for (int i = 0; i < NUM_IMAGES; i++) {
            String path = "icons/j" + i + ".gif";
            img[i] = (new ImageIcon(path)).getImage();
        }
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
}


