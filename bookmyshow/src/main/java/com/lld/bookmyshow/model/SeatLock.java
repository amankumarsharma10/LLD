package com.lld.bookmyshow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SeatLock {
    private String showId;
    private List<String> seatIds;
    private LocalDateTime lockTime;
    private LocalDateTime expiryTime;
    private String userId;

    public SeatLock(String showId, List<String> seatIds, LocalDateTime expiryTime, String userId) {
        this.showId = showId;
        this.seatIds = new ArrayList<>(seatIds);
        this.lockTime = LocalDateTime.now();
        this.expiryTime = expiryTime;
        this.userId = userId;
    }
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiryTime);
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public List<String> getSeatIds() {
        return seatIds;
    }

    public void setSeatIds(List<String> seatIds) {
        this.seatIds = seatIds;
    }

    public LocalDateTime getLockTime() {
        return lockTime;
    }

    public void setLockTime(LocalDateTime lockTime) {
        this.lockTime = lockTime;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

