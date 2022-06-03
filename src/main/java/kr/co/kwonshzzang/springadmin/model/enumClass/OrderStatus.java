package kr.co.kwonshzzang.springadmin.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    ORDERING(0, "ORDERING", "주문중"),
    COMPLETE(1, "COMPLETE", "주문완"),
    CONFIRM(2, "CONFIRM", "주문확정")
    ;

    private Integer id;
    private String title;
    private String description;
}
