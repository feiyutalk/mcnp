package edu.hitsz.view;

import edu.hitsz.utils.CommonUtils;
import edu.hitsz.utils.JXLUtils;
import jxl.read.biff.BiffException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


public class MainGraphPanel extends JPanel{
	public static final int WIDTH = 1300;
	public static final int HEIGHT = 850;
	public static final int DIAMETER = 25;
	
	private ArrayList<ArrayList<String>> datas;
	public ArrayList<Point> locations = new ArrayList<Point>();
	
	public MainGraphPanel(){
		locations = CommonUtils.createRandomLocations(this.WIDTH, this.HEIGHT, this.DIAMETER);
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		datas = readFile(MainFrame.filename, MainFrame.xlsNumbers);
		paintNodes(g);
		paintedges(g, datas);
		paintNodesName(g);
	}
	
	private void paintNodesName(Graphics g) {
		for(int i =0; i<locations.size()-1; i++){
			Point point = locations.get(i);
			String str = ""+(i+1);
			FontMetrics fontMetrics = g.getFontMetrics();
			Color oldColor = g.getColor();
			Font oldFont = g.getFont();
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Times", Font.BOLD, DIAMETER-10));
			int strWidth = fontMetrics.stringWidth(str);
			int strHeight = fontMetrics.getHeight();
			g.drawString(str, (int)point.getX()+DIAMETER/2-strWidth/2, (int)point.getY()+DIAMETER/2+3);
			
			g.setColor(oldColor);
			g.setFont(oldFont);
		}
		
	}



	private void paintedges(Graphics g, ArrayList<ArrayList<String>> datas) {
		for(int i = 0; i<datas.size(); i++){
			for(int j = i+1; j<datas.get(i).size(); j++){
				if(datas.get(i).get(j).equals("y")){
					Point point1 = locations.get(i);
					Point point2 = locations.get(j);
					g.drawLine((int)(point1.getX())+DIAMETER/2, (int)(point1.getY())+DIAMETER/2,
							(int)(point2.getX())+DIAMETER/2, (int)(point2.getY())+DIAMETER/2);
				}
			}
		}
	}



	private void paintNodes(Graphics g) {
		for(int i =0; i<locations.size()-1; i++){
			Point point = locations.get(i);
			g.fillOval((int)point.getX(), (int)point.getY(), DIAMETER, DIAMETER);
			
		}
	}

	public ArrayList<ArrayList<String>> readFile(String filename, int number){
		ArrayList<ArrayList<String>> datas = null;
		try {
			 datas = JXLUtils.readFile(filename, number);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
	}
	
	
}
