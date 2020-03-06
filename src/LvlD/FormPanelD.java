package LvlD;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

import LvlC.FormPanel;


public class FormPanelD extends FormPanel {

	private JLabel width_label;
	private JLabel height_label;
	private JLabel bombs_label;
	public JLabel error;
	private JTextField width_field;
	private JTextField height_field;
	private JTextField bombs_field;
	MaskFormatter mask = null;	

	public FormPanelD() {
		super();
	}
	protected void initWin(){
		Dimension dim=getPreferredSize();	
		dim.width=250;
		setPreferredSize(dim);
		
		p1_label=new JLabel("Name of the first player  ");
		error=new JLabel("");
		p2_label=new JLabel("Name of the second player ");
		height_label=new JLabel("Number of rows ");
		width_label=new JLabel("Number of columns ");
		bombs_label=new JLabel("Number of bombs ");
		p1_field=new JTextField(10);
		p2_field=new JTextField(10);
		width_field=new JTextField(3);
		height_field=new JTextField(3);
		bombs_field=new JTextField(3);
		
		
		
		
		
		Border innerBorder= BorderFactory.createTitledBorder("Settings");
		Border outerBorder= BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc=new GridBagConstraints();
		
		//First row
		addrow1(gc);
		//second row
		addrow2(gc);
		//third row
		addrow3(gc);
		//fourth row
		addrow4(gc);
		//fifth row
		addrow5(gc);
		addrow6(gc);
	}

	protected void addrow3(GridBagConstraints gc) {
		gc.gridx=0;
		gc.gridy=2;
		gc.anchor=GridBagConstraints.LINE_END;
		add(height_label, gc);
		
		gc.gridx=1;
		gc.gridy=2;
		gc.anchor=GridBagConstraints.LINE_START;
		add(height_field, gc);
	}
	protected void addrow4(GridBagConstraints gc) {
		gc.gridx=0;
		gc.gridy=3;
		gc.anchor=GridBagConstraints.LINE_END;
		add(width_label, gc);
		
		gc.gridx=1;
		gc.gridy=3;
		gc.anchor=GridBagConstraints.LINE_START;
		add(width_field, gc);
	}
	protected void addrow5(GridBagConstraints gc) {
		gc.gridx=0;
		gc.gridy=4;
		gc.anchor=GridBagConstraints.LINE_END;
		add(bombs_label, gc);
		
		gc.gridx=1;
		gc.gridy=4;
		gc.anchor=GridBagConstraints.LINE_START;
		add(bombs_field, gc);
	}
	protected void addrow6(GridBagConstraints gc) {
		gc.gridx=0;
		gc.gridy=5;
		gc.anchor=GridBagConstraints.CENTER;
		error.setForeground(Color.red);
		error.setFont(new Font("Calibri", Font.PLAIN, 12));
		add(error, gc);
	}
	public String getRows() {
		return height_field.getText();
	}
	public String getCols() {
		return width_field.getText();
	}	
	public String getBombs() {
		return bombs_field.getText();
	}
}
