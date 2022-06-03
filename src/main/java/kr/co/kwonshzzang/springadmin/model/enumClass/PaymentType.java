package kr.co.kwonshzzang.springadmin.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {
    BANK_TRANSFER(0, "BANK_TRANSFER", "계좌이체"),
    CARD(1, "CARD", "신용카드"),
    CHECK_CARD(2, "CHECK_CARD", "체크카드")
    ;

    private Integer id;
    private String title;
    private String description;
}
