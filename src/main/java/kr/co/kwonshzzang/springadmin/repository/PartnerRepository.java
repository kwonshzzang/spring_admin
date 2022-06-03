package kr.co.kwonshzzang.springadmin.repository;

import kr.co.kwonshzzang.springadmin.model.entity.Category;
import kr.co.kwonshzzang.springadmin.model.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    List<Partner> findByCategory(Category category);
}
