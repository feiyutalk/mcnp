package edu.hitsz.view.robustness.intentionaltest;

import edu.hitsz.utils.CommonUtils;
import edu.hitsz.view.MainFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class IntentionalAttackFrame  extends JFrame{
	
	public static int testState ;//0????  1?????
	
	public static final int WIDTH = 1630;
	
	public static final int HEIGHT = 900;
	
	private JLabel jlbBef = null;
	
	private JLabel jlbAft = null;
	
	public static IntentionalAttackLeftLNPanel intentionalAttackLeftLNPanel = null;
	
	public static IntentionalAttackLeftSNPanel intentionalAttackLeftSNPanel = null;
	
	public static IntentionalAttackTopPanel intentionalAttackTopPanel = null;
	
	public static IntentionalAttackBottomPanel intentionalAttackBottomPanel = null;
	
	public static IntentionalAttackGraphBefPanel intentionalAttackGraphBefPanel = null;
	
	public static IntentionalAttackGraphAftPanel intentionalAttackGraphAftPanel = null;
	
	public static ArrayList<ArrayList<String>> initDatas ;
	
	public static ArrayList<ArrayList<String>> befAttDatas;
	
	public static ArrayList<ArrayList<String>> aftAttDatas;
	
	public IntentionalAttackFrame(){
		
		changeDatas();
		
		init();
		
		addListener();
		
	}
	
	private void addListener() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				
				IntentionalAttackFrame.testState = 0;
				
				
				intentionalAttackBottomPanel.clear();
				
				intentionalAttackGraphBefPanel.clear();
				intentionalAttackGraphAftPanel.clear();
				
				intentionalAttackLeftLNPanel.clear();
				intentionalAttackLeftSNPanel.clear();
				
				intentionalAttackTopPanel.clear();
				
				
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
		jlbBef.setBounds(intentionalAttackLeftLNPanel.WIDTH+intentionalAttackGraphBefPanel.WIDTH/2-10, 80, 100, 20);
		
		jlbAft = new JLabel("攻击后");
		jlbAft.setFont(new Font("Times", 1, 20));
		jlbAft.setBounds(intentionalAttackLeftLNPanel.WIDTH+intentionalAttackGraphBefPanel.WIDTH+intentionalAttackGraphAftPanel.WIDTH/2,
				80, 100, 20);
		
		intentionalAttackLeftLNPanel = new IntentionalAttackLeftLNPanel();
		
		intentionalAttackLeftSNPanel = new IntentionalAttackLeftSNPanel();
		
		intentionalAttackTopPanel = new IntentionalAttackTopPanel();
		
		intentionalAttackBottomPanel = new IntentionalAttackBottomPanel();
		
		ArrayList<Point> locations = CommonUtils.createRandomLocations(IntentionalAttackGraphBefPanel.WIDTH,
				IntentionalAttackGraphBefPanel.HEIGHT, IntentionalAttackGraphBefPanel.DIAMETER);
		
		intentionalAttackGraphBefPanel = new IntentionalAttackGraphBefPanel(locations);
		
		intentionalAttackGraphAftPanel = new IntentionalAttackGraphAftPanel(locations);
		
		intentionalAttackLeftLNPanel.setBounds(0, intentionalAttackLeftSNPanel.HEIGHT,
				IntentionalAttackLeftLNPanel.WIDTH, IntentionalAttackLeftLNPanel.HEIGHT);
		intentionalAttackLeftLNPanel.setBorder(new LineBorder(new Color(0,0,0)));
		
		intentionalAttackLeftSNPanel.setBounds(0,0,
				intentionalAttackLeftSNPanel.WIDTH, intentionalAttackLeftSNPanel.HEIGHT);
		intentionalAttackLeftSNPanel.setBorder(new LineBorder(new Color(0,0,0)));
		
		intentionalAttackTopPanel.setBounds(intentionalAttackLeftLNPanel.WIDTH,0,
				IntentionalAttackTopPanel.WIDTH, IntentionalAttackTopPanel.HEIGHT);
		intentionalAttackTopPanel.setBorder(new LineBorder(new Color(0,0,0)));
		
		intentionalAttackBottomPanel.setBounds(0, IntentionalAttackFrame.HEIGHT- IntentionalAttackBottomPanel.HEIGHT,
				IntentionalAttackBottomPanel.WIDTH, IntentionalAttackBottomPanel.HEIGHT);
		intentionalAttackBottomPanel.setBorder(new LineBorder(new Color(0,0,0)));
		
		intentionalAttackGraphBefPanel.setBounds(intentionalAttackLeftLNPanel.WIDTH, 
				intentionalAttackTopPanel.HEIGHT+40, intentionalAttackGraphBefPanel.WIDTH, intentionalAttackGraphBefPanel.HEIGHT);
		intentionalAttackGraphBefPanel.setBorder(new LineBorder(new Color(0,0,0)));
		
		intentionalAttackGraphAftPanel.setBounds(intentionalAttackLeftLNPanel.WIDTH+intentionalAttackGraphBefPanel.WIDTH,
				intentionalAttackTopPanel.HEIGHT+40, intentionalAttackGraphAftPanel.WIDTH, intentionalAttackGraphAftPanel.HEIGHT);
		intentionalAttackGraphAftPanel.setBorder(new LineBorder(new Color(0,0,0)));
		
		
		testState = 0;
		
		this.add(jlbBef);
		this.add(jlbAft);
		
		this.add(intentionalAttackLeftLNPanel);
		this.add(intentionalAttackLeftSNPanel);
		this.add(intentionalAttackTopPanel);
		this.add(intentionalAttackBottomPanel);
		this.add(intentionalAttackGraphBefPanel);
		this.add(intentionalAttackGraphAftPanel);
		
		this.intentionalAttackLeftSNPanel.repaint();
		this.intentionalAttackLeftLNPanel.repaint();
		this.intentionalAttackBottomPanel.repaint();
		

	
		this.setSize(IntentionalAttackFrame.WIDTH,
				IntentionalAttackFrame.HEIGHT);
		this.setLayout(null);
		this.setResizable(false);
		this.setTitle("intentional attack test");
	}
}
