package kr.co.kwonshzzang.springadmin.model.network.request;

import kr.co.kwonshzzang.springadmin.model.enumClass.OrderStatus;
import kr.co.kwonshzzang.springadmin.model.enumClass.OrderType;
import kr.co.kwonshzzang.springadmin.model.enumClass.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderGroupApiRequest {
    private Long id;
    private OrderStatus status;
    private OrderType orderType;
    private String revAddress;
    private String revName;
    private PaymentType paymentType;
    private BigDecimal totalPrice;
    private Integer totalQuantity;
    private LocalDateTime orderAt;
    private LocalDate arrivalDate;
    private Long userId;
}
