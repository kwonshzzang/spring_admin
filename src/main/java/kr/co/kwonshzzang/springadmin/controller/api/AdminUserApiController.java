package kr.co.kwonshzzang.springadmin.controller.api;

import kr.co.kwonshzzang.springadmin.ifs.CRUDInterface;
import kr.co.kwonshzzang.springadmin.model.network.Header;
import kr.co.kwonshzzang.springadmin.model.network.request.AdminUserApiRequest;
import kr.co.kwonshzzang.springadmin.model.network.response.AdminUserApiResponse;
import kr.co.kwonshzzang.springadmin.service.AdminUserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController implements CRUDInterface<AdminUserApiRequest, AdminUserApiResponse> {
    @Autowired
    private AdminUserApiLogicService adminUserApiLogicService;

    @Override
    @PostMapping("")
    public Header<AdminUserApiResponse> create(@RequestBody Header<AdminUserApiRequest> request) {
        return adminUserApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<AdminUserApiResponse> read(@PathVariable Long id) {
        return adminUserApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<AdminUserApiResponse> update(@RequestBody Header<AdminUserApiRequest> request) {
        return adminUserApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return adminUserApiLogicService.delete(id);
    }
}
