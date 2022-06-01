package kr.co.kwonshzzang.springadmin.model.network.request;

import kr.co.kwonshzzang.springadmin.model.enumClass.UserRole;
import kr.co.kwonshzzang.springadmin.model.enumClass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AdminUserApiRequest {
    private Long id;
    private String account;
    private String password;
    private UserStatus status;
    private UserRole role;
    private LocalDateTime lastLoginAt;
    private LocalDateTime passwordUpdatedAt;
    private int loginFailCount;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;

}
