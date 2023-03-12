package com.app.stockapp.repository;

import com.app.stockapp.entity.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalysisRepo extends JpaRepository<Analysis,Long> {

    @Query(value = "SELECT * FROM Analysis al WHERE al.user_id =:userId AND al.stock_id = :stockId",nativeQuery = true)
    List<Analysis> findAllByAuthorIdAndStockId(@Param(value = "userId")Long userId, @Param(value = "stockId") String stockId );
}
