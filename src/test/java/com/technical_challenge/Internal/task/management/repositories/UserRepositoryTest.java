package com.technical_challenge.Internal.task.management.repositories;

import com.technical_challenge.Internal.task.management.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
// Usar o mesmo banco Mysql
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// application-test.properties
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("Deve retornar false quando o e-mail não existe no banco de dados ")
    void existsByEmailReturnFalseWhenEmailDoesNotExist() {
        boolean existsEmail = userRepository.existsByEmail("Eduardo@gmail.com");

        assertThat(existsEmail).isFalse();
    }

    @Test
    @DisplayName("Deve retornar true quando o e-mail já existe no banco de dados")
    void existsByEmailReturnTrueWhenEmailExists() {
        User user = new User();
        user.setName("Eduardo");
        user.setEmail("Eduardo@gmail.com");
        em.persistAndFlush(user);

        boolean existsEmail = userRepository.existsByEmail("Eduardo@gmail.com");

        assertThat(existsEmail).isTrue();
    }
}