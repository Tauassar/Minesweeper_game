package LvlB;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWin extends JFrame{
	protected JLabel statusbar;
	
	 public MainWin() {
	    }
    public MainWin(String name) {
    	super(name);
    	initBoard();
    }
    protected void initBoard(){
    	statusbar = new JLabel("");
        add(statusbar, BorderLayout.SOUTH);
        add(new Grid(statusbar));        
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


