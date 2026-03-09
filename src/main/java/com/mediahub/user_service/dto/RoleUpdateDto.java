package com.mediahub.user_service.dto;

import com.mediahub.user_service.domain.Role;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleUpdateDto {
    @NotNull(message = "Role is required")
    private Role role;
}
