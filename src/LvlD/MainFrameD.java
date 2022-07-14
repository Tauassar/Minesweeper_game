package LvlD;

import LvlC.GamePanel;
import LvlC.GridC;
import LvlC.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameD extends MainFrame {
	private FormPanelD formPanel;
	private int bombs;
	private int rows;
	private int cols;
	public GamePanel scores; 
	
	public MainFrameD() {
		super("Minesweeper(D)");
		setLayout(new BorderLayout());
		formPanel=new FormPanelD();
		sbmt=new JButton();
		button(sbmt);
		add(formPanel, BorderLayout.CENTER);
		add(sbmt, BorderLayout.SOUTH);
		setSize(300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}
	protected void startGame() {
			scores=new GamePanel(p1,p2);
	        statusbar = new JLabel("");
	        turnbar = new JLabel("");
	        turnbar.setHorizontalAlignment(SwingConstants.CENTER);
	        statusbar.setHorizontalAlignment(SwingConstants.CENTER);
	        add(turnbar, BorderLayout.NORTH);
	        add(statusbar, BorderLayout.SOUTH);
	        GridC gameboard=new GridC(p1,p2,1,statusbar,turnbar,rows,cols,bombs);
	        add(gameboard,BorderLayout.CENTER);  
	        add(scores,BorderLayout.EAST);
	        setResizable(false);
	        setMinimumSize(new Dimension(150,150));
	        pack();	
	}
	
	protected void button(JButton btn) {
		try {
        btn.setText("Submit");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bombs=Integer.valueOf(formPanel.getBombs())-1;
                cols=Integer.valueOf(formPanel.getCols());
                rows=Integer.valueOf(formPanel.getRows());
                if(cols*rows<=bombs)
                    throw new ArrayIndexOutOfBoundsException();
                if(cols>90||rows>40)
                	throw new ArrayIndexOutOfBoundsException();
                p1=formPanel.getP1();
                p2=formPanel.getP2();
                    if(p1.length()<1||p1.length()<1)
                        throw new NullPointerException();
                remove(sbmt);
                remove(formPanel);
                startGame();
            }
        
        });        }
      catch(NumberFormatException e){
          add(formPanel, BorderLayout.CENTER);
          add(sbmt, BorderLayout.SOUTH);
    }
      catch(ArrayIndexOutOfBoundsException e){
              add(formPanel, BorderLayout.CENTER);
              add(sbmt, BorderLayout.SOUTH);
        }
      catch(NullPointerException e){
              add(formPanel, BorderLayout.CENTER);
              add(sbmt, BorderLayout.SOUTH);
        }
	 catch(Exception e){
 		add(formPanel, BorderLayout.CENTER);
 		add(sbmt, BorderLayout.SOUTH);
	}
    
    }
    public static void main(String[] args) {
    	MainFrameD ex = new MainFrameD();
    }
}
