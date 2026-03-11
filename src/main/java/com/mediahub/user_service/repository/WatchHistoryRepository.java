package com.mediahub.user_service.repository;

import com.mediahub.user_service.domain.WatchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WatchHistoryRepository extends JpaRepository<WatchHistory, Long> {
    List<WatchHistory> findByUserId(Long userId);

    List<WatchHistory> findByUserIdOrderByWatchedAtDesc(Long userId);
}
