package kr.co.kwonshzzang.springadmin.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {
    CARD(0, "CARD", "지불수단 카드"),
    CASH(1, "CASH", "지불수단 현금")
    ;

    private Integer id;
    private String title;
    private String description;
}
