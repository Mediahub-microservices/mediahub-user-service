package com.mediahub.user_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "media-service")
public interface MediaServiceClient {

    @GetMapping("/api/media/{id}")
    Object findById(@PathVariable("id") Long id);
}
