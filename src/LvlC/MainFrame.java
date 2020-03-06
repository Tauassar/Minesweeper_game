package LvlC;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {
	protected JLabel statusbar;
	protected JButton sbmt;
	protected FormPanel formPanel;
	protected JLabel turnbar;
	public String p1;
	public String p2;
	
		public MainFrame() {
		this("Minesweeper(C)");
		setLayout(new BorderLayout());
		formPanel=new FormPanel();
		sbmt=new JButton();
		button(sbmt);
		add(formPanel, BorderLayout.CENTER);
		add(sbmt, BorderLayout.SOUTH);
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public MainFrame(String name) {
		super(name);		
	}

	
	protected void startGame() {
	        statusbar = new JLabel("");
	        turnbar = new JLabel("");
	        turnbar.setHorizontalAlignment(SwingConstants.CENTER);
	        statusbar.setHorizontalAlignment(SwingConstants.CENTER);
	        add(turnbar, BorderLayout.NORTH);
	        add(statusbar, BorderLayout.SOUTH);
	        GridC gameBoard=new GridC(p1,p2,statusbar,turnbar);
	        add(gameBoard,BorderLayout.CENTER);  
	        add(new GamePanel(p1,p2),BorderLayout.EAST);
	        setResizable(false);
	        pack();
	}
	
	protected void button(JButton btn) {
		btn.setText("Submit");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setP1(formPanel.getP1());
				setP2(formPanel.getP2());
                if((formPanel.getP1().length()<1)||(formPanel.getP2().length()<1))
                    throw new NullPointerException();
				remove(sbmt);
				remove(formPanel);
				startGame();
			}
			
		});
	}
	
	
	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}	
	
    public static void main(String[] args) {
    	MainFrame ex = new MainFrame();
    }


}
