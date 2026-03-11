package com.mediahub.user_service.service;

import com.mediahub.user_service.domain.WatchHistory;
import java.util.List;

public interface WatchHistoryService {
    WatchHistory registerWatch(Long userId, Long mediaId);

    List<WatchHistory> getHistoryByUserId(Long userId);
}
