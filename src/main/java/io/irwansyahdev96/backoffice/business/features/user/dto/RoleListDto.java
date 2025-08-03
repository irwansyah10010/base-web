package io.irwansyahdev96.backoffice.business.features.user.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RoleListDto {
    private String roleName;
    private LocalDateTime createdDate;
    private String action;
}
