package kr.co.kwonshzzang.springadmin.controller.api;

import kr.co.kwonshzzang.springadmin.controller.CrudController;
import kr.co.kwonshzzang.springadmin.model.entity.User;
import kr.co.kwonshzzang.springadmin.model.network.Header;
import kr.co.kwonshzzang.springadmin.model.network.request.UserApiRequest;
import kr.co.kwonshzzang.springadmin.model.network.response.UserApiResponse;
import kr.co.kwonshzzang.springadmin.model.network.response.UserOrderInfoApiResponse;
import kr.co.kwonshzzang.springadmin.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User> {
    @GetMapping("{id}/orderInfo")
    public Header<UserOrderInfoApiResponse> orderInfo(@PathVariable Long id) {
        return ((UserApiLogicService)baseService).orderInfo(id);

    }
}
