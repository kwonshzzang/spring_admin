package kr.co.kwonshzzang.springadmin.controller.api;

import kr.co.kwonshzzang.springadmin.controller.CrudController;
import kr.co.kwonshzzang.springadmin.model.entity.OrderDetail;
import kr.co.kwonshzzang.springadmin.model.network.request.OrderDetailApiRequest;
import kr.co.kwonshzzang.springadmin.model.network.response.OrderDetailApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailApiController extends CrudController<OrderDetailApiRequest, OrderDetailApiResponse, OrderDetail> {
}
