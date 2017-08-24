package edu.hitsz.view.degreedistr;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

import edu.hitsz.utils.GraphUtils;
import edu.hitsz.view.MainFrame;

public class DegreeDistributionPanel extends JPanel{
		
	private ArrayList<Integer> degrees;
	
	public void showDegreeDistribution(ArrayList<Integer> degrees){
		this.degrees = degrees;
		repaint();
	}
	
	protected void paintComponent(Graphics g){
		if(degrees == null) return;
		
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
		int interval = (width - 40) / degrees.size();
		int individualWidth = (int)(((width - 40)/MainFrame.dataNumbers) * 0.6);
		
		int maxDegree = Collections.max(degrees);
		
		
		int x = 60;
		
		g.drawLine(10, height - 45, width-10, height - 45);
		
		for(int i = 0; i < degrees.size(); i++){
			int barHeight = 
				(int)(((double)degrees.get(i)/(double)maxDegree) * (height-75));
			
			g.drawRect(x, height - 45 -barHeight, individualWidth, barHeight);
			
			g.drawString((1+i) + "", x, height - 30);
			
			g.drawString(degrees.get(i)+"", x, height - 45 -barHeight-10);
			
			x+=interval;
		}
		Color oldColor = g.getColor();
		Font oldFont = g.getFont();
		
		g.setFont(new Font("Times",1,15));
		g.drawString("ƽ������:"+GraphUtils.getAverageDegreeByDegrees(degrees),
				width-300, 20);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(1300, 500);
	}
}
