package kr.co.kwonshzzang.springadmin.repository;

import kr.co.kwonshzzang.springadmin.model.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
}
