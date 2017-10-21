package edu.hitsz.view.robustness.randomtest;

import edu.hitsz.utils.CommonUtils;
import edu.hitsz.view.MainFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class RandomAttackFrame  extends JFrame{
	
	public static int testState ;//0Ϊ׼��  1Ϊ����
	
	public static final int WIDTH = 1630;
	
	public static final int HEIGHT = 900;
	
	private JLabel jlbBef = null;
	
	private JLabel jlbAft = null;
	
	public static RandomAttackLeftLNPanel randomAttackLeftLNPanel = null;
	
	public static RandomAttackLeftSNPanel randomAttackLeftSNPanel = null;
	
	public static RandomAttackTopPanel randomAttackTopPanel = null;
	
	public static RandomAttackBottomPanel randomAttackBottomPanel = null;
	
	public static RandomAttackGraphBefPanel randomAttackGraphPanelBef = null;
	
	public static RandomAttackGraphAftPanel randomAttackGraphPanelAft = null;
	
	public static ArrayList<ArrayList<String>> initDatas ;
	
	public static ArrayList<ArrayList<String>> befAttDatas;
	
	public static ArrayList<ArrayList<String>> aftAttDatas;
	
	public RandomAttackFrame(){
		
		changeDatas();
		
		init();
		
		addListener();
		
	}
	
	private void addListener() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				
				RandomAttackFrame.testState = 0;
				
				randomAttackGraphPanelBef.removedNode = -1;
				
				randomAttackBottomPanel.clear();
				
				randomAttackGraphPanelBef.clear();
				randomAttackGraphPanelAft.clear();
				
				randomAttackLeftLNPanel.clear();
				randomAttackLeftSNPanel.clear();
				
				randomAttackTopPanel.clear();
				
				reset();
			}
		});
	}
	
	public static void reset(){
		befAttDatas = CommonUtils.cloneMyArray(initDatas);
		aftAttDatas = CommonUtils.cloneMyArray(initDatas);
	}

	public static void changeDatas(){
		initDatas = CommonUtils.readFile(MainFrame.filename,
				MainFrame.xlsNumbers);
		
		befAttDatas = CommonUtils.readFile(MainFrame.filename,
				MainFrame.xlsNumbers);
		
		aftAttDatas = CommonUtils.readFile(MainFrame.filename,
				MainFrame.xlsNumbers);
	}

	private void init() {
		
		jlbBef = new JLabel("攻击前");
		jlbBef.setFont(new Font("Times", 1, 20));
		jlbBef.setBounds(randomAttackLeftLNPanel.WIDTH+randomAttackGraphPanelBef.WIDTH/2-10, 80, 100, 20);
		
		jlbAft = new JLabel("攻击后");
		jlbAft.setFont(new Font("Times", 1, 20));
		jlbAft.setBounds(randomAttackLeftLNPanel.WIDTH+randomAttackGraphPanelBef.WIDTH+randomAttackGraphPanelAft.WIDTH/2,
				80, 100, 20);
		
		randomAttackLeftLNPanel = new RandomAttackLeftLNPanel();
		
		randomAttackLeftSNPanel = new RandomAttackLeftSNPanel();
		
		randomAttackTopPanel = new RandomAttackTopPanel();
		
		randomAttackBottomPanel = new RandomAttackBottomPanel();
		
		ArrayList<Point> locations = CommonUtils.createRandomLocations(RandomAttackGraphBefPanel.WIDTH,
				RandomAttackGraphBefPanel.HEIGHT, RandomAttackGraphBefPanel.DIAMETER);
		
		randomAttackGraphPanelBef = new RandomAttackGraphBefPanel(locations);
		
		randomAttackGraphPanelAft = new RandomAttackGraphAftPanel(locations);
		
		randomAttackLeftLNPanel.setBounds(0, randomAttackLeftSNPanel.HEIGHT,
				RandomAttackLeftLNPanel.WIDTH, RandomAttackLeftLNPanel.HEIGHT);
		randomAttackLeftLNPanel.setBorder(new LineBorder(new Color(0,0,0)));
		
		randomAttackLeftSNPanel.setBounds(0,0,
				randomAttackLeftSNPanel.WIDTH, randomAttackLeftSNPanel.HEIGHT);
		randomAttackLeftSNPanel.setBorder(new LineBorder(new Color(0,0,0)));
		
		randomAttackTopPanel.setBounds(randomAttackLeftLNPanel.WIDTH,0,
				RandomAttackTopPanel.WIDTH, RandomAttackTopPanel.HEIGHT);
		randomAttackTopPanel.setBorder(new LineBorder(new Color(0,0,0)));
		
		randomAttackBottomPanel.setBounds(0, RandomAttackFrame.HEIGHT- RandomAttackBottomPanel.HEIGHT,
				RandomAttackBottomPanel.WIDTH, RandomAttackBottomPanel.HEIGHT);
		randomAttackBottomPanel.setBorder(new LineBorder(new Color(0,0,0)));
		
		randomAttackGraphPanelBef.setBounds(randomAttackLeftLNPanel.WIDTH, 
				randomAttackTopPanel.HEIGHT+40, randomAttackGraphPanelBef.WIDTH, randomAttackGraphPanelBef.HEIGHT);
		randomAttackGraphPanelBef.setBorder(new LineBorder(new Color(0,0,0)));
		
		randomAttackGraphPanelAft.setBounds(randomAttackLeftLNPanel.WIDTH+randomAttackGraphPanelBef.WIDTH,
				randomAttackTopPanel.HEIGHT+40, randomAttackGraphPanelAft.WIDTH, randomAttackGraphPanelAft.HEIGHT);
		randomAttackGraphPanelAft.setBorder(new LineBorder(new Color(0,0,0)));
		
		
		testState = 0;
		
		this.add(jlbBef);
		this.add(jlbAft);
		
		this.add(randomAttackLeftLNPanel);
		this.add(randomAttackLeftSNPanel);
		this.add(randomAttackTopPanel);
		this.add(randomAttackBottomPanel);
		this.add(randomAttackGraphPanelBef);
		this.add(randomAttackGraphPanelAft);
		
		this.randomAttackLeftSNPanel.repaint();
		this.randomAttackLeftLNPanel.repaint();
		this.randomAttackBottomPanel.repaint();
		

	
		this.setSize(RandomAttackFrame.WIDTH,
				RandomAttackFrame.HEIGHT);
		this.setLayout(null);
		this.setResizable(false);
		this.setTitle("random attack test");
	}
}
