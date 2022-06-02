package kr.co.kwonshzzang.springadmin.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    PAYMENT(0, "결제", "결제완료 상태"),
    DELIVERY(1, "배송", "배송중 상태"),
    COMPLETE(2, "배송완료", "배송완료 상태")
    ;

    private Integer id;
    private String title;
    private String description;
}
