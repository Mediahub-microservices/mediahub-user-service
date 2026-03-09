package com.mediahub.user_service.service;

import com.mediahub.user_service.domain.Role;
import com.mediahub.user_service.dto.RoleUpdateDto;
import com.mediahub.user_service.dto.UserRequestDto;
import com.mediahub.user_service.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto request);

    UserResponseDto getUserById(Long id);

    List<UserResponseDto> getAllUsers();

    UserResponseDto updateUser(Long id, UserRequestDto request);

    void deleteUser(Long id);

    UserResponseDto updateUserRole(Long id, RoleUpdateDto request);

    List<UserResponseDto> getUsersByRole(Role role);
}
