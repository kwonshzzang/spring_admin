package kr.co.kwonshzzang.springadmin.repository;

import kr.co.kwonshzzang.springadmin.model.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void create() {
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);
        assertNotNull(newCategory);
        assertEquals(newCategory.getType(), type);
        assertEquals(newCategory.getTitle(), title);
    }

    @Test
    void readById() {
        Optional<Category> optionalCategory = categoryRepository.findById(1L);

        optionalCategory.ifPresent(c -> {
            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());
        });
    }

    @Test
    void readByType() {
        String type = "COMPUTER";
        Optional<Category> optionalCategory = categoryRepository.findByType(type);
        //select * from category where type = 'COMPUTER'
        assertTrue(optionalCategory.isPresent());

        optionalCategory.ifPresent(c -> {
            assertEquals(c.getType(), type);
            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());
        });
    }

}