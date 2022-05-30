package kr.co.kwonshzzang.springadmin.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemStatus {
    REGISTERED(0, "등록", "상품등록 상태"),
    UNREGISTERED(1, "해지", "상품해지 상태"),
    WAITING(2, "검수(대기)", "상품검수 상태")
    ;

    private Integer id;
    private String title;
    private String description;
}
