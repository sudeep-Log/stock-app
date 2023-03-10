package com.app.stockapp.Controller;

import com.app.stockapp.helper.ExcelHelper;
import com.app.stockapp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/stock/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file){
        if(ExcelHelper.checkExcelFileOrNot(file)){
            stockService.saveStock(file);
            return ResponseEntity.status(HttpStatus.OK).body("File is successfully uploaded.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enter a valid excel file");
    }

    @GetMapping("/get-all-stocks")
    public java.util.List<com.app.stockapp.entity.Stock> getAllStocks(){
        return this.stockService.getAllStocks();
    }

}
