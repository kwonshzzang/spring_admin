package kr.co.kwonshzzang.springadmin.controller.api;
import kr.co.kwonshzzang.springadmin.ifs.CRUDInterface;
import kr.co.kwonshzzang.springadmin.model.network.Header;
import kr.co.kwonshzzang.springadmin.model.network.request.ItemApiRequest;
import kr.co.kwonshzzang.springadmin.model.network.response.ItemApiResponse;
import kr.co.kwonshzzang.springadmin.service.ItemApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController implements CRUDInterface<ItemApiRequest, ItemApiResponse> {
    @Autowired
    private ItemApiService itemApiService;

    @Override
    @PostMapping("") // /api/item
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
        return itemApiService.create(request);
    }

    @Override
    @GetMapping("{id}") // /api/item/1
    public Header<ItemApiResponse> read(@PathVariable Long id) {
        return itemApiService.read(id);
    }

    @Override
    @PutMapping("") // /api/item
    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
        return itemApiService.update(request);
    }

    @Override
    @DeleteMapping("{id}") // /api/item/1
    public Header delete(@PathVariable Long id) {
        return itemApiService.delete(id);
    }
}
