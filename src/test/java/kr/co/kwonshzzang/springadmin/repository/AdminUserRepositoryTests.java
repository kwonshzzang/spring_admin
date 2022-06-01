package kr.co.kwonshzzang.springadmin.repository;


import kr.co.kwonshzzang.springadmin.model.entity.AdminUser;
import kr.co.kwonshzzang.springadmin.model.enumClass.UserRole;
import kr.co.kwonshzzang.springadmin.model.enumClass.UserStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AdminUserRepositoryTests {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    void create() {
        AdminUser adminUser = new AdminUser();

        adminUser.setAccount("AdminUser04");
        adminUser.setPassword("AdminUser04");
        adminUser.setStatus(UserStatus.REGISTERED);
        adminUser.setRole(UserRole.SUPER);
//        adminUser.setCreatedAt(LocalDateTime.now());
//        adminUser.setCreatedBy("AdminServer");

        AdminUser newAdminUser = adminUserRepository.save(adminUser);
        assertNotNull(newAdminUser);

        newAdminUser.setAccount("CHANGE");
        adminUserRepository.save(newAdminUser);
    }

}