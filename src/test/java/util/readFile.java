package util;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class readFile {

    public static XSSFWorkbook workbook;
    public static XSSFSheet worksheet;
    public static DataFormatter formatter = new DataFormatter();
    public static String fileLocation = System.getProperty("user.dir") + "/resources/test-data.xlsx";
    static String SheetName = "Sheet1";

    public Object[][] readData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileLocation); //Excel sheet file location get mentioned here
        workbook = new XSSFWorkbook(fileInputStream); //get my workbook
        worksheet = workbook.getSheet(SheetName);// get my sheet from workbook
        XSSFRow Row = worksheet.getRow(1);   //get my Row which start from 1

        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum = Row.getLastCellNum(); // get last ColNum

        Object Data[][] = new Object[RowNum - 1][ColNum]; // pass my  count data in array
        for (int i = 0; i < RowNum - 1; i++) //Loop work for Rows
        {
            XSSFRow row = worksheet.getRow(i + 1);

            for (int j = 0; j < ColNum; j++) //Loop work for colNum
            {
                if (row == null)
                    Data[i][j] = "";
                else {
                    XSSFCell cell = row.getCell(j);
                    if (cell == null)
                        Data[i][j] = ""; //if it gets Null value it pass no data
                    else {
                        String value = formatter.formatCellValue(cell);
                        Data[i][j] = value; //This formatter get my all values as string i.e integer, float all type data value
                    }
                }
            }
        }
        return Data;
    }

}

