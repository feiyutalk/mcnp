package edu.hitsz.view.robustness.intentionaltest;

import edu.hitsz.utils.CommonUtils;
import edu.hitsz.utils.GraphUtils;
import edu.hitsz.utils.JXLUtils;
import edu.hitsz.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class IntentionalAttackBottomPanel extends JPanel{
	
	public static final int WIDTH = IntentionalAttackFrame.WIDTH;
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
	private JTextField input = null;
	private JLabel jlbOr = null;
	private JButton jbtMaxDeg = null;
	private JButton jbtMaxCore = null;
	private JButton jbtMaxNodeBet = null;
	
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
	
	
	public IntentionalAttackBottomPanel(){
		
		setLayout(null);
		
		jlbNodes = new JLabel("剩余节点:");
		jlbNodes.setFont(new Font("Times",1, 15));
		jlbNodes.setBounds(20, 10, 80, 50);
		
		jtfNodes = new JTextField();
		jtfNodes.setEditable(false);
		jtfNodes.setFont(new Font("Times",1,15));
		jtfNodes.setBorder(null);
		jtfNodes.setBounds(100, 10, 20, 50);
		
		jlbedges = new JLabel("剩余边数:");
		jlbedges.setFont(new Font("Times", 1, 15));
		jlbedges.setBounds(140, 10, 80, 50);
		
		jtfEdges = new JTextField();
		jtfEdges.setEditable(false);
		jtfEdges.setFont(new Font("Times",1,15));
		jtfEdges.setBorder(null);
		jtfEdges.setBounds(220, 10, 40, 50);
		
		jlbClusBef = new JLabel("clustering coefficient: ");
		jlbClusBef.setFont(new Font("Times",1 , 15));
		jlbClusBef.setBounds(350, 20, 200, 50);
		
		jtfClusBef = new JTextField();
		jtfClusBef.setEditable(false);
		jtfClusBef.setFont(new Font("Times", 1, 15));
		jtfClusBef.setBorder(null);
		jtfClusBef.setBounds(520, 20, 40, 50);
		
		jlbConnBef = new JLabel("连通分支数: ");
		jlbConnBef.setFont(new Font("Times",1,15));
		jlbConnBef.setBounds(350, 60, 200, 50);
		
		jtfConnBef = new JTextField();
		jtfConnBef.setEditable(false);
		jtfConnBef.setFont(new Font("Times",1 ,15));
		jtfConnBef.setBorder(null);
		jtfConnBef.setBounds(520, 60, 40, 50);
		
		jlbDegBef = new JLabel("平均度数: ");
		jlbDegBef.setFont(new Font("Times", 1, 15));
		jlbDegBef.setBounds(350, 100, 200, 50);
		
		jtfDegBef = new JTextField();
		jtfDegBef.setEditable(false);
		jtfDegBef.setFont(new Font("Times", 1, 15));
		jtfDegBef.setBorder(null);
		jtfDegBef.setBounds(520, 100, 40, 50);
		
		jlbPathBef = new JLabel("平均最短路径: ");
		jlbPathBef.setFont(new Font("Times", 1, 15));
		jlbPathBef.setBounds(350, 140, 200, 50);
		
		jtfPathBef = new JTextField();
		jtfPathBef.setEditable(false);
		jtfPathBef.setFont(new Font("Times", 1, 15));
		jtfPathBef.setBorder(null);
		jtfPathBef.setBounds(520, 140, 40, 50);
		
		jlbSizeBef = new JLabel("子图最大节点数:");
		jlbSizeBef.setFont(new Font("Times", 1, 15));
		jlbSizeBef.setBounds(350, 180, 200, 50);
		
		jtfSizeBef = new JTextField();
		jtfSizeBef.setEditable(false);
		jtfSizeBef.setFont(new Font("Times", 1, 15));
		jtfSizeBef.setBorder(null);
		jtfSizeBef.setBounds(520, 180,40,50 );
		
		jlbNodesBef = new JLabel("节点数");
		jlbNodesBef.setFont(new Font("Times", 1, 15));
		jlbNodesBef.setBounds(620, 20, 200, 50);
		
		jtfNodesBef = new JTextField();
		jtfNodesBef.setEditable(false);
		jtfNodesBef.setFont(new Font("Times", 1, 15));
		jtfNodesBef.setBorder(null);
		jtfNodesBef.setBounds(790, 20, 40, 50);
		
		jlbEdgesBef = new JLabel("边 数:");
		jlbEdgesBef.setFont(new Font("Times", 1, 15));
		jlbEdgesBef.setBounds(620, 60, 200, 50);
		
		jtfEdgesBef = new JTextField();
		jtfEdgesBef.setEditable(false);
		jtfEdgesBef.setFont(new Font("Times", 1, 15));
		jtfEdgesBef.setBorder(null);
		jtfEdgesBef.setBounds(790, 60, 40, 50);
		
		jbtAttBefDeg = new JButton("显示度分布:");
		jbtAttBefDeg.setFont(new Font("Times", 1, 15));
		jbtAttBefDeg.setBounds(620, 180, 200, 40);		
		
		jlbClusAft = new JLabel("clustering coefficient:");
		jlbClusAft.setFont(new Font("Times", 1, 15));
		jlbClusAft.setBounds(350+IntentionalAttackGraphBefPanel.WIDTH, 20, 200, 50);
		
		jtfClusAft = new JTextField();
		jtfClusAft.setEditable(false);
		jtfClusAft.setFont(new Font("Times", 1, 15));
		jtfClusAft.setBorder(null);
		jtfClusAft.setBounds(350+IntentionalAttackGraphBefPanel.WIDTH+170, 20, 40, 50);
		
		jlbConnAft = new JLabel("连通分支数: ");
		jlbConnAft.setFont(new Font("Times", 1, 15));
		jlbConnAft.setBounds(350+IntentionalAttackGraphBefPanel.WIDTH, 60, 200, 50);
		
		jtfConnAft = new JTextField();
		jtfConnAft.setEditable(false);
		jtfConnAft.setFont(new Font("Times", 1, 15));
		jtfConnAft.setBorder(null);
		jtfConnAft.setBounds(350+IntentionalAttackGraphBefPanel.WIDTH+170, 60, 40, 50);
		
		jlbDegAft = new JLabel("平均度数: ");
		jlbDegAft.setFont(new Font("Times", 1, 15));
		jlbDegAft.setBounds(350+IntentionalAttackGraphBefPanel.WIDTH, 100, 200, 50);
		
		jtfDegAft = new JTextField();
		jtfDegAft.setEditable(false);
		jtfDegAft.setFont(new Font("Times", 1, 15));
		jtfDegAft.setBorder(null);
		jtfDegAft.setBounds(350+IntentionalAttackGraphBefPanel.WIDTH+170, 100, 40, 50);
		
		jlbPathAft = new JLabel("平均最短路径: ");
		jlbPathAft.setFont(new Font("Times", 1, 15));
		jlbPathAft.setBounds(350+IntentionalAttackGraphBefPanel.WIDTH, 140, 200, 50);
		
		jtfPathAft = new JTextField();
		jtfPathAft.setEditable(false);
		jtfPathAft.setFont(new Font("Times", 1, 15));
		jtfPathAft.setBorder(null);
		jtfPathAft.setBounds(350+IntentionalAttackGraphBefPanel.WIDTH+170, 140, 40, 50);
		
		jlbSizeAft = new JLabel("子图最大节点数:");
		jlbSizeAft.setFont(new Font("Times", 1, 15));
		jlbSizeAft.setBounds(350+IntentionalAttackGraphBefPanel.WIDTH, 180, 200, 50);
		
		jtfSizeAft = new JTextField();
		jtfSizeAft.setEditable(false);
		jtfSizeAft.setFont(new Font("Times", 1, 15));
		jtfSizeAft.setBorder(null);
		jtfSizeAft.setBounds(350+IntentionalAttackGraphBefPanel.WIDTH+170, 180, 40, 50);
		
		jlbNodesAft = new JLabel("节点数: ");
		jlbNodesAft.setFont(new Font("Times", 1, 15));
		jlbNodesAft.setBounds(350+IntentionalAttackGraphBefPanel.WIDTH+170+100, 20, 200, 50);
		
		jtfNodesAft = new JTextField();
		jtfNodesAft.setEditable(false);
		jtfNodesAft.setFont(new Font("Times",1 , 15));
		jtfNodesAft.setBorder(null);
		jtfNodesAft.setBounds(350+IntentionalAttackGraphBefPanel.WIDTH+170+270, 20, 40, 50);
		
		jlbEdgesAft = new JLabel("边数: ");
		jlbEdgesAft.setFont(new Font("Times", 1, 15));
		jlbEdgesAft.setBounds(350+IntentionalAttackGraphBefPanel.WIDTH+170+100, 60, 200, 50);
		
		jtfEdgesAft = new JTextField();
		jtfEdgesAft.setEditable(false);
		jtfEdgesAft.setFont(new Font("Times", 1, 15));
		jtfEdgesAft.setBorder(null);
		jtfEdgesAft.setBounds(350+IntentionalAttackGraphBefPanel.WIDTH+170+270, 60, 40, 50);
		
		jbtAttAftDeg = new JButton("????????");
		jbtAttAftDeg.setFont(new Font("Times", 1, 15));
		jbtAttAftDeg.setBounds(350+IntentionalAttackGraphBefPanel.WIDTH+170+100, 180, 200, 40);
		
		jbtReady = new JButton("准备攻击");
		jbtReady.setFont(new Font("Times", 1, 20));
		jbtReady.setBounds(30, 180, 200, 30);	
		
		jbtStart = new JButton("开始攻击");
		jbtStart.setFont(new Font("Times", 1, 20));
		jbtStart.setBounds(30, 220, 200, 30);
		
		jbtReset = new JButton("回到开始");
		jbtReset.setFont(new Font("Times", 1, 20));
		jbtReset.setBounds(30, 260, 200, 30);
		
		jlbOr = new JLabel("输入或选择最大度数的节点:");
		jlbOr.setFont(new Font("Times", 1, 15));
		jlbOr.setBounds(10, 70, 200, 30);
		
		input = new JTextField();
		input.setFont(new Font("Times", 1, 15));
		input.setBounds(10, 110, 50, 30);
		
		jbtMaxDeg = new JButton("最大度");
		jbtMaxDeg.setFont(new Font("Times", 1, 13));
		jbtMaxDeg.setBounds(60, 110, 85, 30);
		
		jbtMaxCore = new JButton("最大coreness");
		jbtMaxCore.setFont(new Font("Times",1, 13));
		jbtMaxCore.setBounds(145, 110, 125, 30);
		
		jbtMaxNodeBet = new JButton("最大node-betweenness");
		jbtMaxNodeBet.setFont(new Font("Times", 1, 13));
		jbtMaxNodeBet.setBounds(60, 140, 210, 30);
		jbtMaxNodeBet.setEnabled(false);
		
		
		
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
		this.add(jlbOr);
		this.add(input);
		this.add(jbtMaxDeg);
		this.add(jbtMaxCore);
		this.add(jbtMaxNodeBet);

		repaint();
		
		jbtReady.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(IntentionalAttackFrame.testState == 0 && !input.getText().equals("")){
					IntentionalAttackFrame.testState = 1;
					
					IntentionalAttackFrame.intentionalAttackGraphBefPanel
						.removedNode = Integer.parseInt(input.getText());
					
					input.setEditable(false);
					
					int numberOfNodes = GraphUtils.getNumberOfNodes(IntentionalAttackFrame.befAttDatas);
					jtfNodes.setText(numberOfNodes+"");
					
					jtfNodesBef.setText(numberOfNodes+"");
					
					int numberOfEdges = GraphUtils.getNumberOfEdges(IntentionalAttackFrame.befAttDatas);
					jtfEdges.setText(numberOfEdges+"");
					
					jtfEdgesBef.setText(numberOfEdges+"");
					
					double clusteringCoefficient = GraphUtils
							.getAverageClusteringCoefficient(IntentionalAttackFrame.befAttDatas);
					jtfClusBef.setText(String.format("%.2f", clusteringCoefficient));
					
					int connBranNums = GraphUtils
							.getConnectedBranchNumber(IntentionalAttackFrame.befAttDatas);
					jtfConnBef.setText(connBranNums+"");
					
					double aveDegree = GraphUtils
							.getAverageDegree(IntentionalAttackFrame.befAttDatas);
					jtfDegBef.setText(String.format("%.2f", aveDegree));
					
					double avePath = GraphUtils
							.getAverageShortestPath(IntentionalAttackFrame.befAttDatas);
					jtfPathBef.setText(String.format("%.2f", avePath));
					
					int maxSizeOfSubgraph = GraphUtils
							.sizeOfLargestSubgraph(IntentionalAttackFrame.befAttDatas);
					jtfSizeBef.setText(maxSizeOfSubgraph+"");
					
IntentionalAttackFrame.befAttDatas = CommonUtils.cloneMyArray(IntentionalAttackFrame.aftAttDatas);
										
					IntentionalAttackFrame.intentionalAttackGraphBefPanel.isPaint = true;
					
					IntentionalAttackFrame.intentionalAttackGraphBefPanel.setDatas(IntentionalAttackFrame.befAttDatas);
					
					IntentionalAttackFrame.intentionalAttackGraphBefPanel.repaint();
					
					IntentionalAttackFrame.intentionalAttackGraphAftPanel.isPaint = false;
					
					IntentionalAttackFrame.intentionalAttackGraphAftPanel.repaint();

					clearAftDatas();

				}		
			}
		});
		
		jbtStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(IntentionalAttackFrame.testState == 1
						&& !GraphUtils.isRemoved(IntentionalAttackFrame.aftAttDatas,
								Integer.parseInt(input.getText()))){
					IntentionalAttackFrame.testState = 0;
					
				 GraphUtils.intentionalAttack(IntentionalAttackFrame.aftAttDatas,
							Integer.parseInt(input.getText()));
					
				 	input.setEditable(true);
				 
					IntentionalAttackFrame.befAttDatas = CommonUtils.cloneMyArray(IntentionalAttackFrame.aftAttDatas);
					IntentionalAttackTopPanel.addAttackNodesAndShow(Integer.parseInt(input.getText()));
					
					int numberOfNodes = GraphUtils.getNumberOfNodes(IntentionalAttackFrame.aftAttDatas);
					jtfNodes.setText(numberOfNodes+"");
					
					jtfNodesAft.setText(numberOfNodes+"");
					
					int numberOfEdges = GraphUtils.getNumberOfEdges(IntentionalAttackFrame.aftAttDatas);
					jtfEdges.setText(numberOfEdges+"");
					
					jtfEdgesAft.setText(numberOfEdges+"");
					
					double clusteringCoefficient = GraphUtils
							.getAverageClusteringCoefficient(IntentionalAttackFrame.aftAttDatas);
					jtfClusAft.setText(String.format("%.2f", clusteringCoefficient));
					
					int connBranNums = GraphUtils
							.getConnectedBranchNumber(IntentionalAttackFrame.aftAttDatas);
					jtfConnAft.setText(connBranNums+"");
					
					double aveDegree = GraphUtils
							.getAverageDegree(IntentionalAttackFrame.aftAttDatas);
					jtfDegAft.setText(String.format("%.2f", aveDegree));
					
					double avePath = GraphUtils
							.getAverageShortestPath(IntentionalAttackFrame.aftAttDatas);
					jtfPathAft.setText(String.format("%.2f", avePath));
					
					int maxSizeOfSubgraph = GraphUtils
							.sizeOfLargestSubgraph(IntentionalAttackFrame.aftAttDatas);
					jtfSizeAft.setText(maxSizeOfSubgraph+"");
					
					
					
					IntentionalAttackFrame.intentionalAttackLeftSNPanel
						.addNodesAndShowSN(maxSizeOfSubgraph);
					
					IntentionalAttackFrame.intentionalAttackLeftLNPanel
						.addNodesAndShowLN(avePath);
					
					IntentionalAttackFrame.intentionalAttackGraphAftPanel.isPaint = true;
					
					IntentionalAttackFrame.intentionalAttackGraphAftPanel.setDatas(IntentionalAttackFrame.aftAttDatas);
					
					IntentionalAttackFrame.intentionalAttackGraphAftPanel.repaint();
					
					IntentionalAttackFrame.intentionalAttackGraphBefPanel.repaint();
					
				}
			}
		});
		
		jbtReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				IntentionalAttackFrame.testState = 0;
				IntentionalAttackFrame.reset();
				clear();
				IntentionalAttackTopPanel.clear();
				
				IntentionalAttackFrame.intentionalAttackGraphBefPanel.clear();
				IntentionalAttackFrame.intentionalAttackGraphAftPanel.clear();
				
				IntentionalAttackFrame.intentionalAttackLeftLNPanel.clear();
				IntentionalAttackFrame.intentionalAttackLeftSNPanel.clear();
			}
		});
		
		jbtMaxDeg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				if(input.isEditable()){
					int maxDegreeNodeNumber = GraphUtils
							.getMaxDegreeNodeNumber(IntentionalAttackFrame.befAttDatas);
					input.setText(maxDegreeNodeNumber+"");
					
					IntentionalAttackFrame.intentionalAttackGraphBefPanel
					.removedNode = Integer.parseInt(input.getText());
					
IntentionalAttackFrame.intentionalAttackGraphBefPanel.isPaint = true;
					
					IntentionalAttackFrame.intentionalAttackGraphBefPanel.setDatas(IntentionalAttackFrame.befAttDatas);
					
					IntentionalAttackFrame.intentionalAttackGraphBefPanel.repaint();
					
//					IntentionalAttackFrame.intentionalAttackGraphAftPanel.clear();
//					IntentionalAttackFrame.intentionalAttackGraphBefPanel
//						.removedNode = Integer.parseInt(input.getText());
//					IntentionalAttackFrame.intentionalAttackGraphBefPanel.repaint();
//				}	
			}
		});
		
		jbtMaxCore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int maxNodeCoreness = GraphUtils
						.getMaxCorenessNodeNumber(IntentionalAttackFrame.befAttDatas);
				input.setText(maxNodeCoreness+"");
				IntentionalAttackFrame.intentionalAttackGraphBefPanel
				.removedNode = Integer.parseInt(input.getText());
				IntentionalAttackFrame.intentionalAttackGraphBefPanel.isPaint = true;
				
				IntentionalAttackFrame.intentionalAttackGraphBefPanel.setDatas(IntentionalAttackFrame.befAttDatas);
				IntentionalAttackFrame.intentionalAttackGraphBefPanel.repaint();
			}
		});
		
		jbtMaxNodeBet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				int maxNodeBetweeness = GraphUtils
//						.getMaxNodeBetweennessNodeNumber(IntentionalAttackFrame.befAttDatas);
				double maxNodeBetweeness = GraphUtils
						.getNodeBetweenness(IntentionalAttackFrame.befAttDatas, 1);
				
				IntentionalAttackFrame.intentionalAttackGraphBefPanel
				.removedNode = Integer.parseInt(input.getText());
				IntentionalAttackFrame.intentionalAttackGraphBefPanel.isPaint = true;
				
				IntentionalAttackFrame.intentionalAttackGraphBefPanel.setDatas(IntentionalAttackFrame.befAttDatas);
				IntentionalAttackFrame.intentionalAttackGraphBefPanel.repaint();
			}
		});
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawLine(IntentionalAttackLeftLNPanel.WIDTH,0,
				IntentionalAttackLeftLNPanel.WIDTH, IntentionalAttackBottomPanel.HEIGHT);
		g.drawLine(0, 60, IntentionalAttackLeftLNPanel.WIDTH, 60);
		g.drawLine(IntentionalAttackLeftLNPanel.WIDTH+IntentionalAttackGraphBefPanel.WIDTH, 0,
				IntentionalAttackLeftLNPanel.WIDTH+IntentionalAttackGraphBefPanel.WIDTH, IntentionalAttackBottomPanel.HEIGHT);
	}
	
	private ArrayList<ArrayList<String>> getDatas() {
		ArrayList<ArrayList<String>> datas = null;
		try {
			datas = JXLUtils.readFile(MainFrame.filename, MainFrame.xlsNumbers);
		} catch (Exception e1) {
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
		input.setText("");
		input.setEditable(true);
		clearLeftTopDatas();
		clearBefDatas();
		clearAftDatas();
	}
}
