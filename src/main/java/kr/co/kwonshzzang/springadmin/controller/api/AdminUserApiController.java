package kr.co.kwonshzzang.springadmin.controller.api;

import kr.co.kwonshzzang.springadmin.controller.CrudController;
import kr.co.kwonshzzang.springadmin.model.entity.AdminUser;
import kr.co.kwonshzzang.springadmin.model.network.request.AdminUserApiRequest;
import kr.co.kwonshzzang.springadmin.model.network.response.AdminUserApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController extends CrudController<AdminUserApiRequest, AdminUserApiResponse, AdminUser> {
}
