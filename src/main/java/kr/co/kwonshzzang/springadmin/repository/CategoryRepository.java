package kr.co.kwonshzzang.springadmin.repository;

import kr.co.kwonshzzang.springadmin.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByType(String type);
}
