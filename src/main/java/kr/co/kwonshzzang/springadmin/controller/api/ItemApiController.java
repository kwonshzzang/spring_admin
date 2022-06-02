package kr.co.kwonshzzang.springadmin.controller.api;
import kr.co.kwonshzzang.springadmin.controller.CrudController;
import kr.co.kwonshzzang.springadmin.model.entity.Item;
import kr.co.kwonshzzang.springadmin.model.network.request.ItemApiRequest;
import kr.co.kwonshzzang.springadmin.model.network.response.ItemApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

}
