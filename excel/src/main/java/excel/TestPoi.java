package excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.FillPatternType;

public class TestPoi {

	public static void main(String[] args) {

        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet firstSheet = workbook.createSheet("Sheet 1");
        CellStyle style = workbook.createCellStyle();

        style.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        for (int i = 0; i < 20; i++) {
            Row row = firstSheet.createRow(i);         
			for(int j=0; j<20; j++) {
	            Cell cell = row.createCell(j);
	            cell.setCellValue((i+1)*(j+1));
	            cell.setCellStyle(style);
			}              
        }

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File("/home/andrey/test.xls"));
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}

}
