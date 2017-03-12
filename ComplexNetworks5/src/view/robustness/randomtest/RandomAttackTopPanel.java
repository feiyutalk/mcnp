package view.robustness.randomtest;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RandomAttackTopPanel extends JPanel{
	
	public static final int WIDTH = RandomAttackFrame.WIDTH - RandomAttackLeftLNPanel.WIDTH;
	
	public static final int HEIGHT = 70;
	
	public static String attackNodeString = "";
	
	private JLabel jlb = null;
	
	public  static  JTextField jtf = new JTextField();
	
	public RandomAttackTopPanel(){
		setLayout(null);
		
		jlb = new JLabel("被攻击的节点序列:");
		jlb.setFont(new Font("Times", 1, 15));
		jlb.setBounds(20, 15, 150, 50);
		
		jtf.setFont(new Font("Times", 1, 15));
		jtf.setBorder(null);
		jtf.setEditable(false);
		jtf.setBounds(150, 25, 1150,
				30);
		
		this.add(jlb);
		this.add(jtf);
		
	}
	
	public static void addAttackNodesAndShow(int nodeNumber){
		attackNodeString += (nodeNumber +" ");
		jtf.setText(attackNodeString);
	}
	
	public static void clear(){
		attackNodeString = "";
		jtf.setText(attackNodeString);
	}
	
}
