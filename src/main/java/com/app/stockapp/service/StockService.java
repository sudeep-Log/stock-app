package com.app.stockapp.service;

import com.app.stockapp.entity.Stock;
import com.app.stockapp.entity.User;
import com.app.stockapp.helper.ExcelHelper;
import com.app.stockapp.repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepo stockRepo;

    public void saveStock(MultipartFile file, User user){
        try{
           List<Stock> stockList = ExcelHelper.saveExcelToSql(file.getInputStream(), user);
           stockRepo.saveAll(stockList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Stock> getAllStocks(){
        List<Stock> stockList = stockRepo.findAll();
        return stockList;
    }
}
