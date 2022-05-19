package kr.co.kwonshzzang.springadmin.controller.api;

import kr.co.kwonshzzang.springadmin.ifs.CRUDInterface;
import kr.co.kwonshzzang.springadmin.model.network.Header;
import kr.co.kwonshzzang.springadmin.model.network.request.UserApiRequest;
import kr.co.kwonshzzang.springadmin.model.network.response.UserApiResponse;
import kr.co.kwonshzzang.springadmin.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CRUDInterface<UserApiRequest, UserApiResponse> {
    @Autowired
    private UserApiLogicService userApiLogicService;

    @Override
    @PostMapping("") //api/user
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}", request);
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") //api/user/{id}
    public Header<UserApiResponse> read(@PathVariable Long id) {
        log.info("read id : {}", id);
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("")  //api/user/
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        log.info("{}", request);
        return userApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}") //api/user/{id}
    public Header<UserApiResponse> delete(@PathVariable Long id) {
        return null;
    }
}
