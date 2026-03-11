package com.mediahub.user_service.service.impl;

import com.mediahub.user_service.client.MediaServiceClient;
import com.mediahub.user_service.domain.WatchHistory;
import com.mediahub.user_service.repository.WatchHistoryRepository;
import com.mediahub.user_service.service.WatchHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WatchHistoryServiceImpl implements WatchHistoryService {

    private final WatchHistoryRepository watchHistoryRepository;
    private final MediaServiceClient mediaServiceClient;

    @Override
    public WatchHistory registerWatch(Long userId, Long mediaId) {
        // Implementation of Consulter l’historique de visionnage
        // Verify if media exists
        try {
            Object media = mediaServiceClient.findById(mediaId);
            if (media == null) {
                throw new RuntimeException("Media not found with id: " + mediaId);
            }
        } catch (Exception e) {
            throw new RuntimeException("Media service error or media not found: " + mediaId);
        }

        WatchHistory history = WatchHistory.builder()
                .userId(userId)
                .mediaId(mediaId)
                .build();
        return watchHistoryRepository.save(history);
    }

    @Override
    public List<WatchHistory> getHistoryByUserId(Long userId) {
        return watchHistoryRepository.findByUserIdOrderByWatchedAtDesc(userId);
    }
}
