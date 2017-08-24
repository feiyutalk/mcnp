package edu.hitsz.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import edu.hitsz.utils.GraphUtils;
import edu.hitsz.utils.JXLUtils;

import jxl.read.biff.BiffException;


public class MenuPanel extends JPanel{
	
	public static final int WIDTH = 500;
	public static final int HEIGHT= 900;
	
	private JLabel jlbDatas = null;
	private JLabel jlbClus = null;
	private JLabel jlbNode = null;
	private JButton jbtClus = null;
	private JTextField jtfClus = null;
	private JLabel jlbCore = null;
	private JButton jbtCore = null;
	private JLabel jlbCoreNode = null;
	private JTextField jtfCore = null;
	private JLabel jlbCoreGraph = null;
	private JButton jbtCoreGraph = null;
	private JTextField jtfCoreGraph = null;
	private JLabel jlbDegree = null;
	private JLabel jlbDegreeNode = null;
	private JButton jbtDegreeDistr = null;
	private JButton jbtDegree = null;
	private JTextField jtfDegree = null;
	private JLabel jlbPath = null;
	private JButton jbtPath = null;
	private JTextField jtfPath = null;
	private JButton jbtDatas = null;
	private JButton jbtAveClus = null;
	private JTextField jtfAveClus = null;
	private JLabel jlbRbs = null;
	private JButton jbtRbsRd = null;
	private JButton jbtRbsIt = null;
	
	private JComboBox jcbDatas = null;
	private JComboBox jcbClusNodes = null;
	private JComboBox jcbCoreNodes = null;
	private JComboBox jcbDegreeNodes = null;
	
	public MenuPanel(){
		//���ò���
		setLayout(null);
		
		//��ʼ����� ����λ��
		jlbDatas = new JLabel("ѡ�����ݼ�:");
		jlbDatas.setFont(new Font("Times",1, 15));
		jlbDatas.setBounds(20, 20, 100, 50);
		
		jbtDatas = new JButton("��ͼ:");
		jbtDatas.setFont(new Font("Times",1, 15));
		jbtDatas.setBounds(350, 40, 70, 30);
		
		jlbClus = new JLabel("����clustering coefficient:");
		jlbClus.setFont(new Font("Times",1, 20));
		jlbClus.setBounds(20, 80, 300, 50);
		
		jlbNode = new JLabel("ѡ�񶥵�:");
		jlbNode.setFont(new Font("Times",1, 15));
		jlbNode.setBounds(20, 120, 100,50);
		
		jbtClus = new JButton("���:");
		jbtClus.setFont(new Font("Times",1,15));
		jbtClus.setBounds(200, 140, 70, 30);
		
		jtfClus = new JTextField(10);
		jtfClus.setEditable(false);
		jtfClus.setBounds(300, 140, 140, 30);
		
		jbtAveClus = new JButton("ƽ��:");
		jbtAveClus.setFont(new Font("Times",1,15));
		jbtAveClus.setBounds(200, 180, 70, 30);
		
		jtfAveClus = new JTextField();
		jtfAveClus.setEditable(false);
		jtfAveClus.setBounds(300,180,140,30);
		
		

		
		jlbCore = new JLabel("����coreness:");
		jlbCore.setFont(new Font("Times",1, 20));
		jlbCore.setBounds(20, 200, 300, 50);
		
		jlbCoreNode = new JLabel("ѡ�񶥵�:");
		jlbCoreNode.setFont(new Font("Times",1, 15));
		jlbCoreNode.setBounds(20, 240, 100, 50);
		
		jbtCore = new JButton("���");
		jbtCore.setFont(new Font("Times", 1, 15));
		jbtCore.setBounds(200, 260, 70, 30);
		
		jtfCore = new JTextField(10);
		jtfCore.setEditable(false);
		jtfCore.setBounds(300, 260, 140, 30);
		
		jlbCoreGraph = new JLabel("����ͼ��coreness:");
		jlbCoreGraph.setFont(new Font("Times", 1, 15));
		jlbCoreGraph.setBounds(20, 300, 200, 50);
		
		jbtCoreGraph = new JButton("���");
		jbtCoreGraph.setFont(new Font("Times", 1, 15));
		jbtCoreGraph.setBounds(200, 330, 70, 30);
		
		jtfCoreGraph = new JTextField(10);
		jtfCoreGraph.setEditable(false);
		jtfCoreGraph.setBounds(300, 330, 140, 30);
		
		jlbDegree = new JLabel("����Degree:");
		jlbDegree.setFont(new Font("Times", 1, 20));
		jlbDegree.setBounds(20, 370, 300, 50);
		
		jlbDegreeNode = new JLabel("ѡ�񶥵�:");
		jlbDegreeNode.setFont(new Font("Times", 1, 15));
		jlbDegreeNode.setBounds(20, 410, 100, 50);
		
		jbtDegree = new JButton("���");
		jbtDegree.setFont(new Font("Times",1 , 15));
		jbtDegree.setBounds(200, 430, 70, 30);
		
		jtfDegree = new JTextField(10);
		jtfDegree.setEditable(false);
		jtfDegree.setBounds(300, 430, 140, 30);
		
		jbtDegreeDistr = new JButton("��ʾ�ȵķֲ�");
		jbtDegreeDistr.setFont(new Font("Times", 1, 15));
		jbtDegreeDistr.setBounds(140, 480, 200, 40);
		
		jlbPath = new JLabel("����ƽ�����·��:");
		jlbPath.setFont(new Font("Times", 1, 20));
		jlbPath.setBounds(20, 520, 300, 50);
		
		jbtPath = new JButton("���");
		jbtPath.setFont(new Font("Times", 1, 15));
		jbtPath.setBounds(40, 580, 70, 30);
		
		jtfPath = new JTextField(10);
		jtfPath.setEditable(false);
		jtfPath.setBounds(140, 580, 140, 30);
		
		jlbRbs = new JLabel("����ͼ��³����:");
		jlbRbs.setFont(new Font("Times", 1, 20));
		jlbRbs.setBounds(20, 630, 300, 50);
		
		jbtRbsRd = new JButton("����Ĺ�������");
		jbtRbsRd.setFont(new Font("Times", 1, 20));
		jbtRbsRd.setBounds(60, 690, 300, 50);
		
		jbtRbsIt = new JButton("����Ĺ�������");
		jbtRbsIt.setFont(new Font("Times",1 , 20));
		jbtRbsIt.setBounds(60, 760, 300, 50);
		
		String strDatas[] ={"acquaintance", "hometown", "dialect"};
		jcbDatas = new JComboBox(strDatas);
		jcbDatas.setBounds(150, 20, 150, 50);
		
		String strNodes[]={"1","2","3","4","5","6","7","8","9","10",
				"11","12","13","14","15","16","17","18","19","20",
				"21","22","23","24","25","26","27","28","29","30",
				"31","32","33","34","35","36","37","38","39","40",
				"41","42","43","44","45","46","47","48","49","50",
				"51","52","53","54","55"};
		jcbClusNodes = new JComboBox(strNodes);
		JScrollPane jScrollPane = new JScrollPane(jcbClusNodes);
		jScrollPane.setBounds(120, 140, 50, 30);
		
		jcbCoreNodes = new JComboBox(strNodes);
		JScrollPane jScrollPane2 = new JScrollPane(jcbCoreNodes);
		jScrollPane2.setBounds(120, 260, 50, 30);
		
		jcbDegreeNodes = new JComboBox(strNodes);
		JScrollPane jScrollPane3 = new JScrollPane(jcbDegreeNodes);
		jScrollPane3.setBounds(120, 430,50,30);
		
		this.add(jlbDatas);
		this.add(jcbDatas);
		this.add(jlbClus);
		this.add(jlbNode);
		this.add(jScrollPane);
		this.add(jbtClus);
		this.add(jtfClus);
		this.add(jlbCore);
		this.add(jbtCore);
		this.add(jlbCoreNode);
		this.add(jScrollPane2);
		this.add(jtfCore);
		this.add(jlbCoreGraph);
		this.add(jbtCoreGraph);
		this.add(jtfCoreGraph);
		this.add(jlbDegree);
		this.add(jlbDegreeNode);
		this.add(jScrollPane3);
		this.add(jbtDegreeDistr);
		this.add(jbtDegree);
		this.add(jtfDegree);
		this.add(jlbPath);
		this.add(jbtPath);
		this.add(jtfPath);
		this.add(jbtDatas);
		this.add(jbtAveClus);
		this.add(jtfAveClus);
		this.add(jlbRbs);
		this.add(jbtRbsRd);
		this.add(jbtRbsIt);
		
		jbtDatas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tableName = (String) jcbDatas.getSelectedItem();
				if(tableName.equals("acquaintance")){
					MainFrame.xlsNumbers = 0;
					MainFrame.paintGraph();
				}else if(tableName.equals("hometown")){
					MainFrame.xlsNumbers = 1;
					MainFrame.paintGraph();
				}else{
					MainFrame.xlsNumbers = 2;
					MainFrame.paintGraph();
				}
			}
		});
		
		jbtClus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<ArrayList<String>> datas = getDatas();
				String selectNum = (String) jcbClusNodes.getSelectedItem();
				double clusteringCoefficient = GraphUtils.getClusteringCoefficient(datas, 
						Integer.parseInt(selectNum));
				jtfClus.setText(""+clusteringCoefficient);
			}
		});
		
		jbtAveClus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<ArrayList<String>> datas = getDatas();
				double aveClusteringCoefficient = GraphUtils.getAverageClusteringCoefficient(datas);
				jtfAveClus.setText(""+aveClusteringCoefficient);
			}
		});
		
		jbtCore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<ArrayList<String>> datas = getDatas();
				String selectNum = (String) jcbCoreNodes.getSelectedItem();
				System.out.println(selectNum);
				int coreness = GraphUtils.getNodeCoreness(datas, Integer.parseInt(selectNum));
				jtfCore.setText(""+coreness);
			}
		});
		
		jbtCoreGraph.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<ArrayList<String>> datas = getDatas();
				int graphCoreness = GraphUtils.getGraphCoreness(datas);
				jtfCoreGraph.setText(""+graphCoreness);
			}

		});
		
		jbtDegree.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<ArrayList<String>> datas = getDatas();
				String selectNum = (String) jcbDegreeNodes.getSelectedItem();
				int degree = GraphUtils.getNodeDegree(datas, Integer.parseInt(selectNum));
				jtfDegree.setText(""+degree);
			}
		});
		
		jbtPath.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<ArrayList<String>> datas = getDatas();
				double path = GraphUtils.getAverageShortestPath(datas);
				jtfPath.setText(""+path);
			}
		});
		
		jcbDatas.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					String tableName = (String) jcbDatas.getSelectedItem();
					if(tableName.equals("acquaintance")){
						MainFrame.xlsNumbers = 0;
						MainFrame.randomAttackFrame.changeDatas();
					}else if(tableName.equals("hometown")){
						MainFrame.xlsNumbers = 1;
						MainFrame.randomAttackFrame.changeDatas();
					}else{
						MainFrame.xlsNumbers = 2;
						MainFrame.randomAttackFrame.changeDatas();
					}
					
				}
				
			}
		});
		
		jbtDegreeDistr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<ArrayList<String>> datas = getDatas();
				ArrayList<Integer> degrees = GraphUtils.getAllNodesDegree(datas);
				
				MainFrame.degreeDistributionPanel.showDegreeDistribution(degrees);
				
				MainFrame.histogramFrame.setVisible(true);
			}
		});
		
		jbtRbsRd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrame.randomAttackFrame.randomAttackBottomPanel.repaint();
				MainFrame.randomAttackFrame.changeDatas();
				MainFrame.randomAttackFrame.setVisible(true);
			}
		});
		
		jbtRbsIt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrame.intentionalAttackFrame.intentionalAttackBottomPanel.repaint();
				MainFrame.intentionalAttackFrame.changeDatas();
				MainFrame.intentionalAttackFrame.setVisible(true);
			}
		});
		
		
		MainFrame.histogramFrame.add(MainFrame.degreeDistributionPanel);
		MainFrame.histogramFrame.pack();
		MainFrame.histogramFrame.setTitle("degree distribution");
		
		
	}
	
	
	private ArrayList<ArrayList<String>> getDatas() {
		ArrayList<ArrayList<String>> datas = null;
		try {
			datas = JXLUtils.readFile(MainFrame.filename, MainFrame.xlsNumbers);
		} catch (BiffException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return datas;
	}
}
