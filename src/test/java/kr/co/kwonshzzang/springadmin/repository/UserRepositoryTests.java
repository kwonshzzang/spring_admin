package kr.co.kwonshzzang.springadmin.repository;

import kr.co.kwonshzzang.springadmin.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTests {

    //DI : Dependency Injection(의존성의 주입)
    //DI의 기본은 Singleton
    @Autowired
    private UserRepository userRepository;

    @Test
    void create() {
        String account = "Test03";
        String password = "Test03";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-333";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
//        user.setCreatedAt(createdAt);
//        user.setCreatedBy(createdBy);

        User u = User.builder()
                .account(account)
                .password(password)
                .status(status)
                .email(email)
                .build();

        User newUser = userRepository.save(user);

        assertNotNull(newUser);
        assertEquals(newUser.getAccount(), account);
        assertEquals(newUser.getPassword(), password);
    }

    @Test
    @Transactional
    void read() {
        String phoneNumber = "010-1111-2222";

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc(phoneNumber);

        user.setEmail("").setPhoneNumber("").setStatus("");
        User u = new User().setAccount("").setPassword("").setPassword("");

        user.getOrderGroupList().stream().forEach(orderGroup -> {

            System.out.println("------------------ 주문 묶음 ------------------") ;
            System.out.println("수령인 : " + orderGroup.getRevName());
            System.out.println("수정지 : " + orderGroup.getRevAddress());
            System.out.println("총금액 : " + orderGroup.getTotalPrice());
            System.out.println("총수량 : " + orderGroup.getTotalQuantity());
            System.out.println("주문일자 : " + orderGroup.getOrderAt());
            System.out.println("도착일 : " + orderGroup.getArrivalDate());

            System.out.println("------------------ 주문 상세 ------------------") ;
            orderGroup.getOrderDetailList().stream().forEach(orderDetail -> {
                System.out.println("주문의 상태 : " + orderDetail.getStatus());
                System.out.println("도착예정일자 : " + orderDetail.getArrivalDate());
                System.out.println("------------------ 주문 상품 ------------------");
                System.out.println("주문상품 이름 : " +  orderDetail.getItem().getName());
                System.out.println("주문상품 브랜드 : " +  orderDetail.getItem().getBrandName());

                System.out.println("------------------ 파트너사  ------------------");
                System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                System.out.println("파트너사 고객센터 : " + orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("파트너사 주소 : " + orderDetail.getItem().getPartner().getAddress());
                System.out.println("파트너사 대표자 이름 : " + orderDetail.getItem().getPartner().getCeoName());

                System.out.println("------------------ 카테고리  ------------------");
                System.out.println("카테고리 이름 : " + orderDetail.getItem().getPartner().getCategory().getTitle());



            });


        });

        assertNotNull(user);
    }



    @Test
    @Transactional
    void update() {
        Optional<User> user = userRepository.findById(2L);
        user.ifPresent(selectUser -> {
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional
    void delete() {
        Optional<User> user = userRepository.findById(3L);

        assertTrue(user.isPresent());  //true

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        assertFalse(deleteUser.isPresent()); //false
    }

}