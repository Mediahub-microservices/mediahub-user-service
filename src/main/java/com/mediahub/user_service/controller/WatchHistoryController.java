package com.mediahub.user_service.controller;

import com.mediahub.user_service.domain.WatchHistory;
import com.mediahub.user_service.service.WatchHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/history")
@RequiredArgsConstructor
public class WatchHistoryController {

    private final WatchHistoryService watchHistoryService;

    @PostMapping("/watch/{userId}/{mediaId}")
    public ResponseEntity<WatchHistory> registerWatch(
            @PathVariable Long userId,
            @PathVariable Long mediaId) {
        WatchHistory history = watchHistoryService.registerWatch(userId, mediaId);
        return ResponseEntity.ok(history);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WatchHistory>> getHistoryByUserId(@PathVariable Long userId) {
        List<WatchHistory> history = watchHistoryService.getHistoryByUserId(userId);
        return ResponseEntity.ok(history);
    }
}
