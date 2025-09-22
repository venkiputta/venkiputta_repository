package scripting4;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Calendar;

public class Datatable {
    public static int getRowCount(String filePath, String sheetName){
        FileInputStream fin = null;
        Workbook wb = null;
        Sheet sh = null;
        try{
            fin = new FileInputStream(filePath);
            wb = new XSSFWorkbook(fin);
            sh = wb.getSheet(sheetName);
            if(sh==null){
                System.out.println("The given sheetName '"+sheetName+"' doesnot exist");
                return -1;
            }

            return sh.getPhysicalNumberOfRows()-1;
        }catch(Exception e){
            System.out.println("Exception in 'getRowCount()' method. "+e);
            return -1;
        }
        finally
        {
            try{
                fin.close();
                fin = null;
                sh = null;
                wb.close();
                wb = null;
            }catch(Exception e){
            }
        }
    }


    public static String getCellData(String filePath, String sheetName, String columnName, int rowNum){
        FileInputStream fin = null;
        Workbook wb = null;
        Sheet sh = null;
        Row row = null;
        Cell cell = null;
        int colNum = -1;
        String cellData = null;
        Calendar cal = null;
        try{
            fin = new FileInputStream(filePath);
            wb = new XSSFWorkbook(fin);
            sh = wb.getSheet(sheetName);
            if(sh==null){
                System.out.println("The given sheetName '"+sheetName+"' doesnot exist");
                return null;
            }

            //find the column number based on the column Name
            row = sh.getRow(0);
            for(int c=0; c<row.getPhysicalNumberOfCells(); c++){
                cell = row.getCell(c);
                if(cell.getStringCellValue().equalsIgnoreCase(columnName)){
                    colNum = c;
                    break;
                }
            }

            if(colNum >= 0){
                row = sh.getRow(rowNum);
                cell = row.getCell(colNum);

                switch(cell.getCellType()){
                    case BLANK:
                        cellData = "";
                        break;
                    case STRING:
                        cellData = cell.getStringCellValue();
                        break;
                    case BOOLEAN:
                        cellData = String.valueOf(cell.getBooleanCellValue());
                        break;
                    case NUMERIC:
                        if(DateUtil.isCellDateFormatted(cell) == true){
                            double dt = cell.getNumericCellValue();
                            cal = Calendar.getInstance();
                            cal.setTime(DateUtil.getJavaDate(dt));
                            cellData = cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);
                        }else{
                            cellData = String.valueOf(cell.getNumericCellValue());
                        }
                        break;
                }
            }else{
                System.out.println("Failed to find the given column name '"+columnName+"'");
                return null;
            }
            return cellData;
        }catch(Exception e){
            System.out.println("Exception in 'getCellData()' method. "+e);
            return null;
        }finally{
            try{
                fin.close();
                fin = null;
                cell = null;
                row = null;
                sh = null;
                wb.close();
                wb = null;
                cal = null;
            }catch(Exception e){}
        }
    }
}
