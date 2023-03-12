package com.app.stockapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Analysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String stockId;

    private LocalDateTime localDateTime;

    @Lob
    private String content;

    public Analysis() {
    }

    public Analysis(Long id, Long userId, String stockId, LocalDateTime localDateTime, String content) {
        this.id = id;
        this.userId = userId;
        this.stockId = stockId;
        this.localDateTime = localDateTime;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
