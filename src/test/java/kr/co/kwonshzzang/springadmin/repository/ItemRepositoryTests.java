package kr.co.kwonshzzang.springadmin.repository;


import kr.co.kwonshzzang.springadmin.model.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepositoryTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void create() {
        Item item = new Item();
        item.setStatus("UNREGISTERED");
        item.setName("삼성노트북");
        item.setTitle("삼성노트북 A100");
        item.setContent("2022년형 노트북 입니다.");
        item.setPrice(900000.0);
        item.setBrandName("삼성");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
//        item.setPartnerId(1L);

        Item newItem = itemRepository.save(item);
        assertNotNull(newItem);
        assertEquals(newItem.getName(), "삼성노트북");
    }

    @Test
    @Transactional
    void read() {
        Optional<Item> optionalItem = itemRepository.findById(1L);

        assertTrue(optionalItem.isPresent());
        optionalItem.ifPresent(i -> {
            System.out.println(i.getName());
            System.out.println(i.getContent());
            System.out.println(i.getPrice());
        });
    }

}