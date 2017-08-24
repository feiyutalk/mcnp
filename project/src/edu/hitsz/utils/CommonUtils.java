package edu.hitsz.utils;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import jxl.read.biff.BiffException;

public class CommonUtils {
	
	public static ArrayList<ArrayList<String>> cloneMyArray(ArrayList<ArrayList<String>> list){
		ArrayList<ArrayList<String>> listClone = new ArrayList<ArrayList<String>>();
		for(int i =0; i<list.size(); i++){
			ArrayList<String> row = new ArrayList<String>();
			for(int j=0; j<list.get(i).size(); j++){
				row.add(list.get(i).get(j));
			}
			listClone.add(row);
		}
		return listClone;
	}
	
	public static Stack<Integer> cloneMyStack(Stack<Integer> stack){
		Stack<Integer> cloneStack = new Stack<Integer>();
		while(!stack.isEmpty()){	
			Integer item  = stack.pop();
			cloneStack.push(item);
		}
		return cloneStack;
	}
	
	public  static ArrayList<ArrayList<String>> readFile(String filename, int number){
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
	
	public static ArrayList<Point> createRandomLocations(int width, int height, int diameter) {
		int xInterval = width/8;
		int yInterval = height/7;
		ArrayList<Point> locations = new ArrayList<Point>();
		for(int i =0; i<8; i++){
			for(int j=0; j<7; j++){
				int x = i*xInterval+(int)(Math.random()*xInterval);
				if(x<0)
					x=0+diameter;
				if(x>width-diameter)
					x=width-diameter;
					
				int y = j*yInterval+(int)(Math.random()*yInterval);
				if(y<0)
					y=0+diameter;
				if(y>height-diameter)
					y=height-diameter;
				Point point = new Point(x, y);
				locations.add(point);
			}
		}
		return locations;
	}
	
}
