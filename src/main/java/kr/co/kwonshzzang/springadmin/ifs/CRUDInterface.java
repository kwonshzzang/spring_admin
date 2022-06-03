package kr.co.kwonshzzang.springadmin.ifs;


import kr.co.kwonshzzang.springadmin.model.network.Header;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CRUDInterface<Req, Res>{
    Header<Res> create(Header<Req> request);

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header delete(Long id);

    Header<List<Res>> search(Pageable pageable);
}
