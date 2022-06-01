package kr.co.kwonshzzang.springadmin.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    SUPER(0, "SUPER", "슈퍼 사용자"),
    ADMIN(1, "ADMIN", "관리자"),
    GENERAL(2, "GENERAL", "일반 사용자")
    ;

    private Integer id;
    private String title;
    private String description;

}
