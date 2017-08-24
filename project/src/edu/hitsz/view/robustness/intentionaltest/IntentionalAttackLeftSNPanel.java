package edu.hitsz.view.robustness.intentionaltest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import edu.hitsz.view.MainFrame;

public class IntentionalAttackLeftSNPanel extends JPanel{
	
	public static final int WIDTH = 270;
	public static final int HEIGHT = 280;
	public static final int BOTTOMWIDTH = 20;
	
	private int sizeOfLargestSubgraph ;
	private ArrayList<Integer> removedNodesSize ;
	
	public IntentionalAttackLeftSNPanel(){
		removedNodesSize = new ArrayList<Integer>();
	}
	
	public void addNodesAndShowSN(int sizeOfLargestSubgraph){
		this.sizeOfLargestSubgraph = sizeOfLargestSubgraph;
		removedNodesSize.add(sizeOfLargestSubgraph);
		repaint();
	}
	
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
		int interval = (width - 40) / MainFrame.dataNumbers;
		
		int maxSizeOfLargestSubgraph = MainFrame.dataNumbers;
		
		int x = 20;
		
		Font oldFont = g.getFont();
		g.setFont(new Font("Times", 1, 17));
		g.drawString("size of the largest subgraph", 25, 30);
		g.setFont(oldFont);
		
		g.drawLine(10, height - BOTTOMWIDTH, width-30, height - BOTTOMWIDTH);
		
		g.drawLine(10, 50, 10, this.HEIGHT-BOTTOMWIDTH);
		
		int xLength = width-30 - 10;
		
		int yLength = this.HEIGHT-BOTTOMWIDTH - 50;
		
		g.drawString("0.2", (int)(xLength*0.2),  height - BOTTOMWIDTH+10);
		
		g.drawString("0.4", (int)(xLength*0.4),  height - BOTTOMWIDTH+10);
		
		g.drawString("0.6", (int)(xLength*0.6),  height - BOTTOMWIDTH+10);
		
		g.drawString("0.8", (int)(xLength*0.8),  height - BOTTOMWIDTH+10);
		
		g.drawString("1.0", (int)(xLength*1.0),  height - BOTTOMWIDTH+10);
		
		
		g.drawString("1.0", 20, (int)(50+yLength*(1.0-1.0)));
		
		g.drawString("0.8", 20, (int)(50+yLength*(1.0-0.8)));
		
		g.drawString("0.6", 20, (int)(50+yLength*(1.0-0.6)));
		
		g.drawString("0.4", 20, (int)(50+yLength*(1.0-0.4)));
		
		g.drawString("0.2", 20, (int)(50+yLength*(1.0-0.2)));
		
		for(int i = 0; i < removedNodesSize.size(); i++){
			int barHeight = 
				(int)(((double)removedNodesSize.get(i)/(double)maxSizeOfLargestSubgraph) * (height-75));
			Color oldColor = g.getColor();
			g.setColor(Color.RED);
			g.fillRect(x, height - BOTTOMWIDTH -barHeight, 4, 4);
			g.setColor(oldColor);
			x+=interval;
		}
	}
	
	public void clear(){
		removedNodesSize.clear();
		this.repaint();
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(1300, 500);
	}
}
