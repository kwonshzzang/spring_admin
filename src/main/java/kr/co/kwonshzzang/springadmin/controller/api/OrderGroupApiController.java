package kr.co.kwonshzzang.springadmin.controller.api;

import kr.co.kwonshzzang.springadmin.controller.CrudController;
import kr.co.kwonshzzang.springadmin.model.entity.OrderGroup;
import kr.co.kwonshzzang.springadmin.model.network.request.OrderGroupApiRequest;
import kr.co.kwonshzzang.springadmin.model.network.response.OrderGroupApiResponse;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {
}
