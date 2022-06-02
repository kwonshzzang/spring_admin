package kr.co.kwonshzzang.springadmin.model.network.response;

import kr.co.kwonshzzang.springadmin.model.enumClass.OrderType;
import kr.co.kwonshzzang.springadmin.model.enumClass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PartnerApiResponse {
    private Long id;
    private String name;
    private UserStatus status;
    private String address;
    private String callCenter;
    private String partnerNumber;
    private String businessNumber;
    private String ceoName;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    private Long categoryId;
}
