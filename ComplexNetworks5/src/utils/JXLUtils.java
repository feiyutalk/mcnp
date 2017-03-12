package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class JXLUtils {
	/**
	 * @param args
	 * @throws IOException 
	 * @throws BiffException 
	 */
	private JXLUtils(){
		
	}
	
	public static ArrayList<ArrayList<String>> readFile(String filename, int sheetNumber) throws BiffException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		
		Workbook rwb = null;
		
		Cell cell = null;
		
		File file = new File(filename);

		InputStream input = new FileInputStream(file);
		
		rwb = Workbook.getWorkbook(input);
		
		Sheet sheet = rwb.getSheet(sheetNumber);
		
		for(int i = 0; i<sheet.getRows(); i++){
			ArrayList<String> row = new ArrayList<String>();
			for(int j=0; j<sheet.getColumns();j++){
				cell = sheet.getCell(j, i);
				row.add(cell.getContents());
			}
			list.add(row);
		}
		return list;
	}

}
