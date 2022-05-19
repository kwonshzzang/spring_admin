package kr.co.kwonshzzang.springadmin.ifs;


import kr.co.kwonshzzang.springadmin.model.network.Header;

public interface CRUDInterface<Req, Res>{
    Header<Res> create(Header<Req> request);

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header<Res> delete(Long id);
}
