package edu.hitsz.view.robustness.randomtest;

import edu.hitsz.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RandomAttackLeftLNPanel extends JPanel{
	
	public static final int WIDTH = 270;
	public static final int HEIGHT = 280;
	public static final int BOTTOMWIDTH = 20;
	
	private double averageShortestPath ;
	private ArrayList<Double> removedNodesPath ;
	
	public RandomAttackLeftLNPanel(){
		removedNodesPath = new ArrayList<Double>();
	}
	
	public void addNodesAndShowLN(double averageShortestPath){
		this.averageShortestPath = averageShortestPath;
		removedNodesPath.add(averageShortestPath);
		repaint();
	}
	
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
		int interval = (width - 40) / MainFrame.dataNumbers;
		
		
		int maxAverageShortesPath ;
			maxAverageShortesPath = 10;
		
		int x = 20;
		
		Font oldFont = g.getFont();
		g.setFont(new Font("Times", 1, 17));
		g.drawString("average path length", 35, 30);
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
		
		
		g.drawString(maxAverageShortesPath+"", 20, (int)(50+yLength*(1.0-1.0)));
		
		g.drawString(maxAverageShortesPath/2+"", 20, (int)(50+yLength*(1.0-0.5)));
		
		for(int i = 0; i < removedNodesPath.size(); i++){
			int barHeight = 
				(int)(((double)removedNodesPath.get(i)/(double)maxAverageShortesPath) * (height-75));
			Color oldColor = g.getColor();
			g.setColor(Color.BLUE);
			g.fillOval(x, height - BOTTOMWIDTH -barHeight, 4, 4);
			g.setColor(oldColor);
			x+=interval;
		}
	}
	
	public void  clear(){
		removedNodesPath.clear();
		this.repaint();
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(1300, 500);
	}
}
