//package com.spring.onlineBicycle;
//
//import com.spring.onlineBicycle.administrator.models.User;
//import com.spring.onlineBicycle.administrator.repository.UserrRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//public class UserrRepositoryTests {
//
//    @Autowired
//    private UserrRepository repo;
//
//    @Test
//    private void testAddNew() {
//        User user = new User();
//        user.setEmail("amu70dfgdfg@gmail.com");
//        user.setPassword("password90");
//        user.setFirstName("Ravi");
//        user.setLastName("Kumar");
//
//        User savedUser = repo.save(user);
//
//        assertThat(savedUser).isNotNull();
//        assertThat(savedUser.getId()).isGreaterThan(0);
//    }
//}
