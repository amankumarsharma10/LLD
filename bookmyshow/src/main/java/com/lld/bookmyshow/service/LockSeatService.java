package com.lld.bookmyshow.service;

import com.lld.bookmyshow.model.SeatLock;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class LockSeatService {
    public LockSeatService() {
        // Start cleanup task to remove expired locks
        cleanupExecutor.scheduleAtFixedRate(this::cleanupExpiredLocks, 1, 1, TimeUnit.MINUTES);
    }
     public Map<String, SeatLock> activeLocks = new ConcurrentHashMap<>();
     private ScheduledExecutorService cleanupExecutor    = Executors.newScheduledThreadPool(1);

     public boolean lockSeat(String showId, List<String> seatIds, int timeoutMinutes, String userId){
         String lock = generateLockKey(showId, seatIds);
         for (String seatId : seatIds) {
             if (isSeatLocked(showId, seatId)) {
                 return false;
             }
         }

         LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(timeoutMinutes);
         SeatLock seatLock = new SeatLock(showId, seatIds, expiryTime, userId);

         activeLocks.put(lock,seatLock);
        return true;

     }

    private boolean isSeatLocked(String showId, String seatId) {
        return activeLocks.values().stream()
                .anyMatch(lock -> lock.getShowId().equals(showId) &&
                        lock.getSeatIds().contains(seatId) &&
                        !lock.isExpired());
    }

    private String generateLockKey(String showId, List<String> seatIds) {
        Collections.sort(seatIds); // Ensure consistent ordering
        return showId + "_" + String.join(",", seatIds);
    }

    private void cleanupExpiredLocks() {
        activeLocks.entrySet().removeIf(entry -> entry.getValue().isExpired());
    }

    public void releaseSeats(String showId, List<String> seatIds) {
        String lockKey = generateLockKey(showId, seatIds);
        activeLocks.remove(lockKey);
    }

    public boolean confirmSeatBooking(String showId, List<String> seatIds) {
        String lockKey = generateLockKey(showId, seatIds);
        SeatLock lock = activeLocks.get(lockKey);

        if (lock != null && !lock.isExpired()) {
            activeLocks.remove(lockKey);
            return true;
        }
        return false;
    }
}
