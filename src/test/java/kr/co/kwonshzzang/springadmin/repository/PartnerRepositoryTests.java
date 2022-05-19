package kr.co.kwonshzzang.springadmin.repository;

import kr.co.kwonshzzang.springadmin.model.entity.Partner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PartnerRepositoryTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    void create() {
        String name = "Partner01";
        String status = "REGISTERED";
        String address = "서울시 강남구";
        String callCenter = "070-1111-2222";
        String partnerNumber = "010-1111-2222";
        String businessNumber = "1234567890123";
        String ceoName = "홍길동";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        Long categoryId = 1L;

        Partner partner = new Partner();
        partner.setName(name);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setPartnerNumber(partnerNumber);
        partner.setBusinessNumber(businessNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registeredAt);
        partner.setCreatedAt(createdAt);
        partner.setCreatedBy(createdBy);
//        partner.setCategoryId(categoryId);

        Partner newPartner = partnerRepository.save(partner);

        assertNotNull(newPartner);
        assertEquals(newPartner.getName(), name);
    }

    @Test
    void read() {
        Long partnerId = 1L;
        Optional<Partner> optionalPartner = partnerRepository.findById(partnerId);

        assertTrue(optionalPartner.isPresent());

        optionalPartner.ifPresent(p -> {
            System.out.println(p.getName());
            System.out.println(p.getAddress());
            System.out.println(p.getCeoName());
        });
    }

}