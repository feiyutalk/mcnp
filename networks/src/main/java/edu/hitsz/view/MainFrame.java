package edu.hitsz.view;

import edu.hitsz.view.degreedistr.DegreeDistributionPanel;
import edu.hitsz.view.robustness.intentionaltest.IntentionalAttackFrame;
import edu.hitsz.view.robustness.randomtest.RandomAttackFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MainFrame extends JFrame{
	/**
	 * @param args
	 */
	private MenuPanel menuPanel = new MenuPanel();

	public static MainGraphPanel graphPanel = new MainGraphPanel();
	
	public static DegreeDistributionPanel degreeDistributionPanel = new DegreeDistributionPanel();
	
	public static JFrame histogramFrame = new JFrame();
	
	public static RandomAttackFrame randomAttackFrame = new RandomAttackFrame();
	
	public static IntentionalAttackFrame intentionalAttackFrame = new IntentionalAttackFrame();
	
	public static final String filename = "../data/data.xls";
	
	public static final int dataNumbers = 55;
	
	public static int xlsNumbers = 0;
	
	public MainFrame(){
		init();
	}
	
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
	}

	public void init() {
		this.setLayout(null);
		
		graphPanel.setSize(1300, 900);
		graphPanel.setBounds(0, 0, 1300, 900);
		graphPanel.setBorder(new LineBorder(new Color(0,0,0)));
		
		menuPanel.setBounds(1300, 0, 
				MenuPanel.WIDTH, MenuPanel.HEIGHT);
		menuPanel.setBorder(new LineBorder(new Color(0,0,0)));
		
		this.add(graphPanel);
		this.add(menuPanel);
		
		this.setLocation(30, 30);
		this.setSize(1800,900);
		this.setTitle("ComplexNetwork Project2016");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void paintGraph(){
		graphPanel.repaint();
	}
}
