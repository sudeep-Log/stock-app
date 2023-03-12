package com.app.stockapp.service;

import com.app.stockapp.DTO.AnalysisDto;
import com.app.stockapp.entity.Analysis;
import com.app.stockapp.repository.AnalysisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnalysisService {

    @Autowired
    AnalysisRepo analysisRepository;

    public Analysis addStockAnalysis(AnalysisDto analysisDto){
        LocalDateTime timeStamp = LocalDateTime.now();
        Analysis analysis = new Analysis();
        analysis.setUserId(Long.valueOf(analysisDto.getuserId()));
        analysis.setStockId(analysisDto.getStockId());
        analysis.setLocalDateTime(timeStamp);
        analysis.setContent(analysisDto.getContent());
        analysis = analysisRepository.save(analysis);
        return analysis;
    }

    public List<Analysis> getAllAnalysisByAuthorAndStock(Long userId, String stockId){
        List<Analysis> analysisList = analysisRepository.findAllByAuthorIdAndStockId(userId,stockId);
        return analysisList;
    }

    public String deleteAnalysis(Long analysisId){
        Analysis analysis = analysisRepository.findById(analysisId).orElse(null);
        analysisRepository.delete(analysis);
        return "Analysis Removed";
    }

    public Analysis updateAnalysis(Long analysisId, AnalysisDto analysisDto){
        Analysis analysis = analysisRepository.findById(analysisId).orElse(null);
        if(analysis != null){
            analysis.setContent(analysisDto.getContent());
            analysis = analysisRepository.save(analysis);
        }
        return analysis;
    }
}
