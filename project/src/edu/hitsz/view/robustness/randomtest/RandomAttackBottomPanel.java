package edu.hitsz.view.robustness.randomtest;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jxl.read.biff.BiffException;
import edu.hitsz.utils.CommonUtils;
import edu.hitsz.utils.GraphUtils;
import edu.hitsz.utils.JXLUtils;
import edu.hitsz.view.MainFrame;

public class RandomAttackBottomPanel extends JPanel{
	
	int attackNodeNumber;
	
	public static final int WIDTH = RandomAttackFrame.WIDTH;
	public static final int HEIGHT = 340;
	private JLabel jlbNodes = null;
	private JTextField jtfNodes = null;
	private JLabel jlbedges = null;
	private JTextField jtfEdges = null;
	
	private JLabel jlbClusBef = null;
	private JTextField jtfClusBef = null;
	private JLabel jlbConnBef = null;
	private JTextField jtfConnBef = null;
	private JLabel jlbDegBef = null;
	private JTextField jtfDegBef = null;
	private JLabel jlbPathBef = null;
	private JTextField jtfPathBef = null;
	private JLabel jlbSizeBef = null;
	private JTextField jtfSizeBef = null;
	private JButton jbtAttBefDeg = null;
	private JLabel jlbNodesBef = null;
	private JTextField jtfNodesBef = null;
	private JLabel jlbEdgesBef = null;
	private JTextField jtfEdgesBef = null;
	
	private JLabel jlbClusAft = null;
	private JTextField jtfClusAft = null;
	private JLabel jlbConnAft = null;
	private JTextField jtfConnAft = null;
	private JLabel jlbDegAft = null;
	private JTextField jtfDegAft = null;
	private JLabel jlbPathAft = null;
	private JTextField jtfPathAft = null;
	private JLabel jlbSizeAft = null;
	private JTextField jtfSizeAft = null;
	private JButton jbtAttAftDeg = null;
	private JLabel jlbNodesAft = null;
	private JTextField jtfNodesAft = null;
	private JLabel jlbEdgesAft = null;
	private JTextField jtfEdgesAft = null;
	
	private JButton jbtReady = null;
	private JButton jbtStart = null;
	private JButton jbtReset = null;
	
	
	public RandomAttackBottomPanel(){
		
		setLayout(null);
		
		jlbNodes = new JLabel("ʣ��ڵ�:");
		jlbNodes.setFont(new Font("Times",1, 15));
		jlbNodes.setBounds(20, 10, 80, 50);
		
		jtfNodes = new JTextField();
		jtfNodes.setEditable(false);
		jtfNodes.setFont(new Font("Times",1,15));
		jtfNodes.setBorder(null);
		jtfNodes.setBounds(100, 10, 20, 50);
		
		jlbedges = new JLabel("ʣ�����:");
		jlbedges.setFont(new Font("Times", 1, 15));
		jlbedges.setBounds(140, 10, 80, 50);
		
		jtfEdges = new JTextField();
		jtfEdges.setEditable(false);
		jtfEdges.setFont(new Font("Times",1,15));
		jtfEdges.setBorder(null);
		jtfEdges.setBounds(220, 10, 40, 50);
		
		jlbClusBef = new JLabel("Clustering coefficient:");
		jlbClusBef.setFont(new Font("Times",1 , 15));
		jlbClusBef.setBounds(350, 20, 200, 50);
		
		jtfClusBef = new JTextField();
		jtfClusBef.setEditable(false);
		jtfClusBef.setFont(new Font("Times", 1, 15));
		jtfClusBef.setBorder(null);
		jtfClusBef.setBounds(520, 20, 40, 50);
		
		jlbConnBef = new JLabel("��ͨ��֧��:");
		jlbConnBef.setFont(new Font("Times",1,15));
		jlbConnBef.setBounds(350, 60, 200, 50);
		
		jtfConnBef = new JTextField();
		jtfConnBef.setEditable(false);
		jtfConnBef.setFont(new Font("Times",1 ,15));
		jtfConnBef.setBorder(null);
		jtfConnBef.setBounds(520, 60, 40, 50);
		
		jlbDegBef = new JLabel("ƽ������:");
		jlbDegBef.setFont(new Font("Times", 1, 15));
		jlbDegBef.setBounds(350, 100, 200, 50);
		
		jtfDegBef = new JTextField();
		jtfDegBef.setEditable(false);
		jtfDegBef.setFont(new Font("Times", 1, 15));
		jtfDegBef.setBorder(null);
		jtfDegBef.setBounds(520, 100, 40, 50);
		
		jlbPathBef = new JLabel("ƽ�����·��:");
		jlbPathBef.setFont(new Font("Times", 1, 15));
		jlbPathBef.setBounds(350, 140, 200, 50);
		
		jtfPathBef = new JTextField();
		jtfPathBef.setEditable(false);
		jtfPathBef.setFont(new Font("Times", 1, 15));
		jtfPathBef.setBorder(null);
		jtfPathBef.setBounds(520, 140, 40, 50);
		
		jlbSizeBef = new JLabel("��ͼ���ڵ���:");
		jlbSizeBef.setFont(new Font("Times", 1, 15));
		jlbSizeBef.setBounds(350, 180, 200, 50);
		
		jtfSizeBef = new JTextField();
		jtfSizeBef.setEditable(false);
		jtfSizeBef.setFont(new Font("Times", 1, 15));
		jtfSizeBef.setBorder(null);
		jtfSizeBef.setBounds(520, 180,40,50 );
		
		jlbNodesBef = new JLabel("�ڵ���");
		jlbNodesBef.setFont(new Font("Times", 1, 15));
		jlbNodesBef.setBounds(620, 20, 200, 50);
		
		jtfNodesBef = new JTextField();
		jtfNodesBef.setEditable(false);
		jtfNodesBef.setFont(new Font("Times", 1, 15));
		jtfNodesBef.setBorder(null);
		jtfNodesBef.setBounds(790, 20, 40, 50);
		
		jlbEdgesBef = new JLabel("�� ��:");
		jlbEdgesBef.setFont(new Font("Times", 1, 15));
		jlbEdgesBef.setBounds(620, 60, 200, 50);
		
		jtfEdgesBef = new JTextField();
		jtfEdgesBef.setEditable(false);
		jtfEdgesBef.setFont(new Font("Times", 1, 15));
		jtfEdgesBef.setBorder(null);
		jtfEdgesBef.setBounds(790, 60, 40, 50);
		
//		jbtAttBefDeg = new JButton("��ʾ�ȵķֲ�");
//		jbtAttBefDeg.setFont(new Font("Times", 1, 15));
//		jbtAttBefDeg.setBounds(620, 180, 200, 40);
		
		jlbClusAft = new JLabel("Clustering coefficient:");
		jlbClusAft.setFont(new Font("Times", 1, 15));
		jlbClusAft.setBounds(350+RandomAttackGraphBefPanel.WIDTH, 20, 200, 50);
		
		jtfClusAft = new JTextField();
		jtfClusAft.setEditable(false);
		jtfClusAft.setFont(new Font("Times", 1, 15));
		jtfClusAft.setBorder(null);
		jtfClusAft.setBounds(350+RandomAttackGraphBefPanel.WIDTH+170, 20, 40, 50);
		
		jlbConnAft = new JLabel("��ͨ��֧��:");
		jlbConnAft.setFont(new Font("Times", 1, 15));
		jlbConnAft.setBounds(350+RandomAttackGraphBefPanel.WIDTH, 60, 200, 50);
		
		jtfConnAft = new JTextField();
		jtfConnAft.setEditable(false);
		jtfConnAft.setFont(new Font("Times", 1, 15));
		jtfConnAft.setBorder(null);
		jtfConnAft.setBounds(350+RandomAttackGraphBefPanel.WIDTH+170, 60, 40, 50);
		
		jlbDegAft = new JLabel("ƽ������:");
		jlbDegAft.setFont(new Font("Times", 1, 15));
		jlbDegAft.setBounds(350+RandomAttackGraphBefPanel.WIDTH, 100, 200, 50);
		
		jtfDegAft = new JTextField();
		jtfDegAft.setEditable(false);
		jtfDegAft.setFont(new Font("Times", 1, 15));
		jtfDegAft.setBorder(null);
		jtfDegAft.setBounds(350+RandomAttackGraphBefPanel.WIDTH+170, 100, 40, 50);
		
		jlbPathAft = new JLabel("ƽ�����·��:");
		jlbPathAft.setFont(new Font("Times", 1, 15));
		jlbPathAft.setBounds(350+RandomAttackGraphBefPanel.WIDTH, 140, 200, 50);
		
		jtfPathAft = new JTextField();
		jtfPathAft.setEditable(false);
		jtfPathAft.setFont(new Font("Times", 1, 15));
		jtfPathAft.setBorder(null);
		jtfPathAft.setBounds(350+RandomAttackGraphBefPanel.WIDTH+170, 140, 40, 50);
		
		jlbSizeAft = new JLabel("��ͼ���ڵ���:");
		jlbSizeAft.setFont(new Font("Times", 1, 15));
		jlbSizeAft.setBounds(350+RandomAttackGraphBefPanel.WIDTH, 180, 200, 50);
		
		jtfSizeAft = new JTextField();
		jtfSizeAft.setEditable(false);
		jtfSizeAft.setFont(new Font("Times", 1, 15));
		jtfSizeAft.setBorder(null);
		jtfSizeAft.setBounds(350+RandomAttackGraphBefPanel.WIDTH+170, 180, 40, 50);
		
		jlbNodesAft = new JLabel("�ڵ���:");
		jlbNodesAft.setFont(new Font("Times", 1, 15));
		jlbNodesAft.setBounds(350+RandomAttackGraphBefPanel.WIDTH+170+100, 20, 200, 50);
		
		jtfNodesAft = new JTextField();
		jtfNodesAft.setEditable(false);
		jtfNodesAft.setFont(new Font("Times",1 , 15));
		jtfNodesAft.setBorder(null);
		jtfNodesAft.setBounds(350+RandomAttackGraphBefPanel.WIDTH+170+270, 20, 40, 50);
		
		jlbEdgesAft = new JLabel("�� ��:");
		jlbEdgesAft.setFont(new Font("Times", 1, 15));
		jlbEdgesAft.setBounds(350+RandomAttackGraphBefPanel.WIDTH+170+100, 60, 200, 50);
		
		jtfEdgesAft = new JTextField();
		jtfEdgesAft.setEditable(false);
		jtfEdgesAft.setFont(new Font("Times", 1, 15));
		jtfEdgesAft.setBorder(null);
		jtfEdgesAft.setBounds(350+RandomAttackGraphBefPanel.WIDTH+170+270, 60, 40, 50);
		
//		jbtAttAftDeg = new JButton("��ʾ�ȵķֲ�");
//		jbtAttAftDeg.setFont(new Font("Times", 1, 15));
//		jbtAttAftDeg.setBounds(350+RandomAttackGraphBefPanel.WIDTH+170+100, 180, 200, 40);
		
		jbtReady = new JButton("׼������");
		jbtReady.setFont(new Font("Times", 1, 20));
		jbtReady.setBounds(30, 120, 200, 30);	
		
		jbtStart = new JButton("��ʼ����");
		jbtStart.setFont(new Font("Times", 1, 20));
		jbtStart.setBounds(30, 170, 200, 30);
		
		jbtReset = new JButton("�ص���ʼ");
		jbtReset.setFont(new Font("Times", 1, 20));
		jbtReset.setBounds(30, 220, 200, 30);
		
		this.add(jlbNodes);
		this.add(jtfNodes);
		this.add(jlbedges);
		this.add(jtfEdges);
		this.add(jlbClusBef);
		this.add(jtfClusBef);
		this.add(jlbConnBef);
		this.add(jtfConnBef);
		this.add(jlbDegBef);
		this.add(jtfDegBef);
		this.add(jlbPathBef);
		this.add(jtfPathBef);
		this.add(jlbSizeBef);
		this.add(jtfSizeBef);
//		this.add(jbtAttBefDeg);
		this.add(jlbClusAft);
		this.add(jtfClusAft);
		this.add(jlbConnAft);
		this.add(jtfConnAft);
		this.add(jlbDegAft);
		this.add(jtfDegAft);
		this.add(jlbPathAft);
		this.add(jtfPathAft);
		this.add(jlbSizeAft);
		this.add(jtfSizeAft);
//		this.add(jbtAttAftDeg);
		this.add(jlbNodesBef);
		this.add(jtfNodesBef);
		this.add(jlbEdgesBef);
		this.add(jtfEdgesBef);
		this.add(jlbNodesAft);
		this.add(jtfNodesAft);
		this.add(jlbEdgesAft);
		this.add(jtfEdgesAft);
		this.add(jbtReady);
		this.add(jbtStart);
		this.add(jbtReset);

		repaint();
		
		jbtReady.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					
					attackNodeNumber = (int)(Math.random()*55)+1;
					while(RandomAttackFrame.befAttDatas.get(attackNodeNumber-1).get(attackNodeNumber-1).equals("x")){
						attackNodeNumber = (int)(Math.random()*55)+1;
					}
					
					int numberOfNodes = GraphUtils.getNumberOfNodes(RandomAttackFrame.befAttDatas);
					jtfNodes.setText(numberOfNodes+"");
					
					jtfNodesBef.setText(numberOfNodes+"");
					
					int numberOfEdges = GraphUtils.getNumberOfEdges(RandomAttackFrame.befAttDatas);
					jtfEdges.setText(numberOfEdges+"");
					
					jtfEdgesBef.setText(numberOfEdges+"");
					
					double clusteringCoefficient = GraphUtils
							.getAverageClusteringCoefficient(RandomAttackFrame.befAttDatas);
					jtfClusBef.setText(String.format("%.2f", clusteringCoefficient));
					
					int connBranNums = GraphUtils
							.getConnectedBranchNumber(RandomAttackFrame.befAttDatas);
					jtfConnBef.setText(connBranNums+"");
					
					double aveDegree = GraphUtils
							.getAverageDegree(RandomAttackFrame.befAttDatas);
					jtfDegBef.setText(String.format("%.2f", aveDegree));
					
					double avePath = GraphUtils
							.getAverageShortestPath(RandomAttackFrame.befAttDatas);
					jtfPathBef.setText(String.format("%.2f", avePath));
					
					int maxSizeOfSubgraph = GraphUtils
							.sizeOfLargestSubgraph(RandomAttackFrame.befAttDatas);
					jtfSizeBef.setText(maxSizeOfSubgraph+"");
					
RandomAttackFrame.befAttDatas = CommonUtils.cloneMyArray(RandomAttackFrame.aftAttDatas);
										
					RandomAttackFrame.randomAttackGraphPanelBef.isPaint = true;
					
					RandomAttackFrame.randomAttackGraphPanelBef.setDatas(RandomAttackFrame.befAttDatas);
					
					RandomAttackFrame.randomAttackGraphPanelBef.removedNode = attackNodeNumber;
					
					RandomAttackFrame.randomAttackGraphPanelBef.repaint();
					
					RandomAttackFrame.randomAttackGraphPanelAft.isPaint = false;
					
					RandomAttackFrame.randomAttackGraphPanelAft.repaint();

					clearAftDatas();

						
			}
		});
		
		jbtStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if( RandomAttackFrame.aftAttDatas.size()>0 && 
						!GraphUtils.isRemoved(RandomAttackFrame.aftAttDatas, attackNodeNumber)){
					
					GraphUtils.randomAttack(RandomAttackFrame.aftAttDatas,attackNodeNumber);
					
					RandomAttackTopPanel.addAttackNodesAndShow(attackNodeNumber);
					
					
					RandomAttackFrame.befAttDatas = CommonUtils.cloneMyArray(RandomAttackFrame.aftAttDatas);
					
					int numberOfNodes = GraphUtils.getNumberOfNodes(RandomAttackFrame.aftAttDatas);
					jtfNodes.setText(numberOfNodes+"");
					
					jtfNodesAft.setText(numberOfNodes+"");
					
					int numberOfEdges = GraphUtils.getNumberOfEdges(RandomAttackFrame.aftAttDatas);
					jtfEdges.setText(numberOfEdges+"");
					
					jtfEdgesAft.setText(numberOfEdges+"");
					
					double clusteringCoefficient = GraphUtils
							.getAverageClusteringCoefficient(RandomAttackFrame.aftAttDatas);
					jtfClusAft.setText(String.format("%.2f", clusteringCoefficient));
					
					int connBranNums = GraphUtils
							.getConnectedBranchNumber(RandomAttackFrame.aftAttDatas);
					jtfConnAft.setText(connBranNums+"");
					
					double aveDegree = GraphUtils
							.getAverageDegree(RandomAttackFrame.aftAttDatas);
					jtfDegAft.setText(String.format("%.2f", aveDegree));
					
					double avePath = GraphUtils
							.getAverageShortestPath(RandomAttackFrame.aftAttDatas);
					jtfPathAft.setText(String.format("%.2f", avePath));
					
					int maxSizeOfSubgraph = GraphUtils
							.sizeOfLargestSubgraph(RandomAttackFrame.aftAttDatas);
					jtfSizeAft.setText(maxSizeOfSubgraph+"");
					
					RandomAttackFrame.randomAttackLeftSNPanel
						.addNodesAndShowSN(maxSizeOfSubgraph);
					
					RandomAttackFrame.randomAttackLeftLNPanel
						.addNodesAndShowLN(avePath);
					
					RandomAttackFrame.randomAttackGraphPanelAft.isPaint = true;
					
					RandomAttackFrame.randomAttackGraphPanelAft.setDatas(RandomAttackFrame.aftAttDatas);
					
					RandomAttackFrame.randomAttackGraphPanelAft.repaint();
					
				}
			}
		});
		
		jbtReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RandomAttackFrame.testState = 0;
				RandomAttackFrame.reset();
				clear();
				RandomAttackTopPanel.clear();
				
				RandomAttackFrame.randomAttackGraphPanelBef.clear();
				RandomAttackFrame.randomAttackGraphPanelAft.clear();
				
				RandomAttackFrame.randomAttackLeftLNPanel.clear();
				RandomAttackFrame.randomAttackLeftSNPanel.clear();
			}
		});
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawLine(RandomAttackLeftLNPanel.WIDTH,0,
				RandomAttackLeftLNPanel.WIDTH, RandomAttackBottomPanel.HEIGHT);
		g.drawLine(0, 80, RandomAttackLeftLNPanel.WIDTH, 80);
		g.drawLine(RandomAttackLeftLNPanel.WIDTH+RandomAttackGraphBefPanel.WIDTH, 0,
				RandomAttackLeftLNPanel.WIDTH+RandomAttackGraphBefPanel.WIDTH, RandomAttackBottomPanel.HEIGHT);
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
	
	public void clearBefDatas(){
		jtfClusBef.setText("");
		
		jtfConnBef.setText("");
		
		jtfDegBef.setText("");
		
		jtfPathBef.setText("");
		
		jtfSizeBef.setText("");
		
		jtfNodesBef.setText("");
		
		jtfEdgesBef.setText("");
	}
	
	public void clearAftDatas(){
		jtfClusAft.setText("");
		
		jtfConnAft.setText("");
		
		jtfDegAft.setText("");
		
		jtfPathAft.setText("");
		
		jtfSizeAft.setText("");
		
		jtfNodesAft.setText("");
		
		jtfEdgesAft.setText("");
	}
	
	public void clearLeftTopDatas(){
		jtfNodes.setText("");
		jtfEdges.setText("");
	}
	
	public void clear(){
		clearLeftTopDatas();
		clearBefDatas();
		clearAftDatas();
	}
}
