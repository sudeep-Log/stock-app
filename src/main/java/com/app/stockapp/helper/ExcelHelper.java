package com.app.stockapp.helper;

import com.app.stockapp.entity.Stock;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

//    Check whether excel file is provided or not
    public static boolean checkExcelFileOrNot(MultipartFile file){
        String contentType = file.getContentType();
        if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            return true;
        }else
        {
            return false;
        }
    }

    public static List<Stock> saveExcelToSql(InputStream is){

        List<Stock> listOfStocks = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("Equity");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()){

                Row row = iterator.next();

                if(rowNumber ==0 || rowNumber < 23){
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cells = row.iterator();
                int cid = 0;

                Stock stock = new Stock();
                while(cells.hasNext()){
                    Cell cell = cells.next();

                    switch (cid){
                        case 0: stock.setSymbol(cell.getStringCellValue());
                        break;
                        case 2: stock.setSector(cell.getStringCellValue());
                        break;
                        case 3: stock.setQuantity((int)cell.getNumericCellValue());
                        break;
                        case 9: stock.setAveragePrice((double)cell.getNumericCellValue());
                        break;
                        default:
                            break;
                    }
                    cid++;
                }
                listOfStocks.add(stock);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listOfStocks;
    }



}
