package kr.co.kwonshzzang.springadmin.controller;

import kr.co.kwonshzzang.springadmin.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {
//    HTML <Form>
//    ajax 검색
//    http post body -> data
//    json, xml, multipart-form / text-plain


//    GET        조회(SELECT * READ)    /user/{id}
//    POST       생성(CREATE)           /user
//    PUT/PATCH  수정(UPDATE) * CREATE  /user
//    DELETE     삭제(DELETE)           /user/{1}

//    @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    @PostMapping(value = "/postMethod", produces = {"application/json"})
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {
        return searchParam;
    }

    @PutMapping("/putMethod")
    public void put() {

    }

    @PatchMapping("/patchMethod")
    public void patch() {

    }
}
