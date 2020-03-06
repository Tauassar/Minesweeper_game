package LvlC;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GamePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel p1_label;
	private JLabel p2_label;
	private static JLabel p1_score;
	private static JLabel p2_score;
	
	public GamePanel(String p1,String p2) {
		Dimension dim=getPreferredSize();	
		dim.width=120;
		setPreferredSize(dim);
		
		Border innerBorder= BorderFactory.createTitledBorder("Game statistics:");
		Border outerBorder= BorderFactory.createEmptyBorder(1,1,1,1);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		p1_label=new JLabel(p1);
		p2_label=new JLabel(p2);
		p1_score=new JLabel("0");
		p2_score=new JLabel("0");
			
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc=new GridBagConstraints();

		//First row
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridx=0;
		gc.gridy=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		add(p1_label, gc);
		
		gc.gridx=0;
		gc.gridy=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(p1_score, gc);
		
		//second row
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridx=0;
		gc.gridy=1;
		gc.anchor=GridBagConstraints.LINE_START;
		add(p2_label, gc);	
		
		gc.gridx=0;
		gc.gridy=1;
		gc.anchor=GridBagConstraints.LINE_END;
		add(p2_score, gc);
	}

	public static void screenScores(int score_1, int score_2) {
		p1_score.setText(Integer.toString(score_1));
		p2_score.setText(Integer.toString(score_2));
	}
}
