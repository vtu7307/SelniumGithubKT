package reusableComponents;

import java.io.File;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {
	public static void main(String[] args) {
		
	}
	String filePath;
	Sheet sh;
	public ExcelOperations( String SheetName) {
		try {
			filePath = System.getProperty("user.dir")+propertiesOperations.getPropertyValueByKey("testDataLocation");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Open File - workbook
				File testDatafile = new File(filePath);
				Workbook wb = null;
				try {
					wb = WorkbookFactory.create(testDatafile);
				}  catch (Exception e) {
					e.printStackTrace();
				}
				sh =wb.getSheet(SheetName);
	}
	//Get Test data  from test data sheet in HashMap based on row number
	@SuppressWarnings("deprecation")
	public HashMap<String, String> getTestDatainMap(int rowNum) throws Exception {
		HashMap<String, String> hm = new HashMap<String , String>();
		
		for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
			sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNum).getCell(i).toString());
		}
		
		return hm;
	}
	//Get row count
	public int getrowCount() {
		return sh.getLastRowNum();
	//Get column count
	}
	public int getColcount() {
		
		return sh.getRow(0).getLastCellNum();
		
		
	}
}
    
