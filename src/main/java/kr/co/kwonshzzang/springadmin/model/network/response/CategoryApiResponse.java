package kr.co.kwonshzzang.springadmin.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoryApiResponse {
    private Long id;
    private String type;
    private String title;
}
