package com.app.stockapp.Controller;

import com.app.stockapp.DTO.AnalysisDto;
import com.app.stockapp.entity.Analysis;
import com.app.stockapp.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockAnalysisController {

    @Autowired
    AnalysisService analysisService;


    @GetMapping("/get-analysis/{userId}/{stockId}")
    public ResponseEntity<List<Analysis>> getAllAnalysisByAuthorAndStock(@PathVariable(value = "userId") Long userId,
                                                                         @PathVariable(value = "stockId") String stockId){
        if(userId != null && stockId != null){
            List<Analysis> analysisList = analysisService.getAllAnalysisByAuthorAndStock(userId,stockId);
            return new ResponseEntity<>(analysisList, HttpStatus.OK);
        }
        else return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add-analysis")
    public ResponseEntity<Analysis> addAnalysisForStock(@RequestBody AnalysisDto analysisDto){
        if(analysisDto.getuserId()!= null && analysisDto.getStockId() != null){
            Analysis analysis = analysisService.addStockAnalysis(analysisDto);
            return new ResponseEntity(analysis, HttpStatus.OK);
        }
        else return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete-analysis/{analysisId}")
    public ResponseEntity<String> deleteAnalysis(@PathVariable(value = "analysisId") Long analysisId){
        if(analysisId != null) {
            String result = analysisService.deleteAnalysis(analysisId);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }
        else return new ResponseEntity<>("Invalid id",HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update-analysis/{analysisId}")
    public ResponseEntity<Analysis> updateAnalysis(@PathVariable(value = "analysisId") Long analysisId,
                                                   @RequestBody AnalysisDto analysisDto){
        if(analysisId != null ){
            Analysis analysis = analysisService.updateAnalysis(analysisId,analysisDto);
            return new ResponseEntity<>(analysis,HttpStatus.OK);
        }
        else return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
}
