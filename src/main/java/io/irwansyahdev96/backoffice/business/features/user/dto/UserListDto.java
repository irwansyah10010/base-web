package io.irwansyahdev96.backoffice.business.features.user.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserListDto {

    private String username;
    private String fullName;
    private String status;
    private boolean isLogin;
    private LocalDateTime createdDate;
    private LocalDateTime lastLoginDate;
    private String action;
}
