package kr.co.kwonshzzang.springadmin.service;

import kr.co.kwonshzzang.springadmin.ifs.CRUDInterface;
import kr.co.kwonshzzang.springadmin.model.network.Header;
import kr.co.kwonshzzang.springadmin.model.network.request.ItemApiRequest;
import kr.co.kwonshzzang.springadmin.model.network.response.ItemApiResponse;
import kr.co.kwonshzzang.springadmin.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemApiService implements CRUDInterface<ItemApiRequest, ItemApiResponse> {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {
        return null;
    }

    @Override
    public Header<ItemApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }
}
