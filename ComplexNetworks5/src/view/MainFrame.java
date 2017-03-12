package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.lang.Thread.State;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import view.degreedistr.DegreeDistributionPanel;
import view.robustness.intentionaltest.IntentionalAttackFrame;
import view.robustness.randomtest.RandomAttackFrame;
import view.robustness.randomtest.RandomAttackLeftLNPanel;

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
	
	public static final String filename = "./src/data.xls";
	
	public static final int dataNumbers = 55;
	
	public static int xlsNumbers = 0;
	
	public MainFrame(){
		init();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mainFrame = new MainFrame();
	}

	public void init() {
		this.setLayout(null);
		
		graphPanel.setSize(1300, 900);
		graphPanel.setBounds(0, 0, 1300, 900);
		graphPanel.setBorder(new LineBorder(new Color(0,0,0)));
		
		menuPanel.setBounds(1300, 0, 
				MenuPanel.WIDTH,MenuPanel.HEIGHT);
		menuPanel.setBorder(new LineBorder(new Color(0,0,0)));
		
		this.add(graphPanel);
		this.add(menuPanel);
		
		this.setLocation(30, 30);
		this.setSize(1800,900);
		this.setTitle("ComplexNetwork Project2016 ICES_16S151521_²Ì´Ï»³");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void paintGraph(){
		graphPanel.repaint();
	}
}
