package LvlC;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	protected JTextField p1_field;
	protected JTextField p2_field;
	protected JLabel p1_label;
	protected JLabel p2_label;

	public FormPanel() {
		initWin();
	}
	protected void initWin() {
		Dimension dim=getPreferredSize();	
		dim.width=250;
		setPreferredSize(dim);
		
		p1_label=new JLabel("Name of the first player  ");
		p2_label=new JLabel("Name of the second player ");
		p1_field=new JTextField(10);
		p2_field=new JTextField(10);
		
		Border innerBorder= BorderFactory.createTitledBorder("Add player name");
		Border outerBorder= BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc=new GridBagConstraints();

		gc.weightx=1;
		gc.weighty=1;
		
		//First row
		addrow1(gc);
		//second row
		addrow2(gc);
	}
	protected void addrow1(GridBagConstraints gc) {
		gc.gridx=0;
		gc.gridy=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(p1_label, gc);
		
		gc.gridx=1;
		gc.gridy=0;
		gc.anchor=GridBagConstraints.LINE_START;
		add(p1_field, gc);
	}
	protected void addrow2(GridBagConstraints gc) {
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridx=0;
		gc.gridy=1;
		gc.anchor=GridBagConstraints.LINE_END;
		add(p2_label, gc);
		
		gc.gridx=1;
		gc.gridy=1;
		gc.anchor=GridBagConstraints.LINE_START;
		add(p2_field, gc);
	}
	public String getP1() {
		return p1_field.getText();
	}
	public String getP2() {
		return p2_field.getText();
	}
}
