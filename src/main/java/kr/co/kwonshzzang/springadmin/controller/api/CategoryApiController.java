package kr.co.kwonshzzang.springadmin.controller.api;

import kr.co.kwonshzzang.springadmin.ifs.CRUDInterface;
import kr.co.kwonshzzang.springadmin.model.network.Header;
import kr.co.kwonshzzang.springadmin.model.network.request.CategoryApiRequest;
import kr.co.kwonshzzang.springadmin.model.network.response.CategoryApiResponse;
import kr.co.kwonshzzang.springadmin.service.CategoryApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/category")
public class CategoryApiController implements CRUDInterface<CategoryApiRequest, CategoryApiResponse> {
    @Autowired
    private CategoryApiLogicService categoryApiLogicService;


    @Override
    @PostMapping("")
    public Header<CategoryApiResponse> create(@RequestBody  Header<CategoryApiRequest> request) {
        return categoryApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<CategoryApiResponse> read(@PathVariable Long id) {
        return categoryApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<CategoryApiResponse> update(@RequestBody Header<CategoryApiRequest> request) {
        return categoryApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return categoryApiLogicService.delete(id);
    }
}
