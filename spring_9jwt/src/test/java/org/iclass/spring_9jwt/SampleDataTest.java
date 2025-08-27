package org.iclass.spring_9jwt;

import static org.mockito.ArgumentMatchers.isNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.iclass.spring_9jwt.entity.BoardEntity;
import org.iclass.spring_9jwt.entity.Role;
import org.iclass.spring_9jwt.entity.UsersEntity;
import org.iclass.spring_9jwt.repository.BoardRepository;
import org.iclass.spring_9jwt.repository.UserRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SampleDataTest {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BoardRepository boardRepository;

  static List<String> users = new ArrayList<>();

  @Test
  @Order(2)
  void createBoards() {
    boardRepository.deleteAll();
    IntStream.rangeClosed(1, 20).forEach(i -> {
      LocalDateTime baseTime = LocalDateTime.of(2025, 7, 10, 0, 0, 0);
      BoardEntity board = BoardEntity.builder()
          .title("오늘의 명언 " + i)
          .content("하늘은 스스로 돕는자를 돕는다.")
          .username(users.get(i % 5))

          .build();
      boardRepository.save(board); // insert
      board.setCreatedAt(baseTime.plusDays(i + 10).plusHours(i).plusMinutes(i));
      // board.setUpdatedAt(board.getCreatedAt().plusHours(i + 5)); // @PreUpdate 때문에 동작안함
      boardRepository.save(board); // update
    });

  }

  @Test
  @Order(1)
  void createUsers() { // 이름,
                       // 패스워드
                       // eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwb3BwbGUxMTAxQG5hdmVyLmNvbSIsImlzcyI6Im9yZy5pY2xhc3MiLCJpYXQiOjE3NTYyNzM4MjEsImV4cCI6MTc1NjM2MDIyMX0.a32kH_0jCDKfpV0BBjV3QRlQRK82wN3EDZCTzVZnEzOBUfbgMrw15_Qfp1kjbsKzVdqAgmNjv460zr13yFFMPQ,
                       // username, role
    UsersEntity user = UsersEntity.builder()
        .name("홍길동")
        .password(
            "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwb3BwbGUxMTAxQG5hdmVyLmNvbSIsImlzcyI6Im9yZy5pY2xhc3MiLCJpYXQiOjE3NTYyNzM4MjEsImV4cCI6MTc1NjM2MDIyMX0.a32kH_0jCDKfpV0BBjV3QRlQRK82wN3EDZCTzVZnEzOBUfbgMrw15_Qfp1kjbsKzVdqAgmNjv460zr13yFFMPQ")
        .username("gd@naver.com").role(Role.USER)
        .build();
    users.add(user.getUsername());
    userRepository.save(user);

    user = UsersEntity.builder()
        .name("김준우")
        .password(
            "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwb3BwbGUxMTAxQG5hdmVyLmNvbSIsImlzcyI6Im9yZy5pY2xhc3MiLCJpYXQiOjE3NTYyNzM4MjEsImV4cCI6MTc1NjM2MDIyMX0.a32kH_0jCDKfpV0BBjV3QRlQRK82wN3EDZCTzVZnEzOBUfbgMrw15_Qfp1kjbsKzVdqAgmNjv460zr13yFFMPQ")
        .username("popple1101@naver.com").role(Role.USER)
        .build();
    users.add(user.getUsername());
    userRepository.save(user);

    user = UsersEntity.builder()
        .name("김유나")
        .password(
            "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwb3BwbGUxMTAxQG5hdmVyLmNvbSIsImlzcyI6Im9yZy5pY2xhc3MiLCJpYXQiOjE3NTYyNzM4MjEsImV4cCI6MTc1NjM2MDIyMX0.a32kH_0jCDKfpV0BBjV3QRlQRK82wN3EDZCTzVZnEzOBUfbgMrw15_Qfp1kjbsKzVdqAgmNjv460zr13yFFMPQ")
        .username("yn02@google.com").role(Role.ADMIN)
        .build();
    users.add(user.getUsername());
    userRepository.save(user);

    user = UsersEntity.builder()
        .name("임은상")
        .password(
            "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwb3BwbGUxMTAxQG5hdmVyLmNvbSIsImlzcyI6Im9yZy5pY2xhc3MiLCJpYXQiOjE3NTYyNzM4MjEsImV4cCI6MTc1NjM2MDIyMX0.a32kH_0jCDKfpV0BBjV3QRlQRK82wN3EDZCTzVZnEzOBUfbgMrw15_Qfp1kjbsKzVdqAgmNjv460zr13yFFMPQ")
        .username("im86@daum.net").role(Role.USER)
        .build();
    users.add(user.getUsername());
    userRepository.save(user);

    user = UsersEntity.builder()
        .name("구로의심장")
        .password(
            "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwb3BwbGUxMTAxQG5hdmVyLmNvbSIsImlzcyI6Im9yZy5pY2xhc3MiLCJpYXQiOjE3NTYyNzM4MjEsImV4cCI6MTc1NjM2MDIyMX0.a32kH_0jCDKfpV0BBjV3QRlQRK82wN3EDZCTzVZnEzOBUfbgMrw15_Qfp1kjbsKzVdqAgmNjv460zr13yFFMPQ")
        .username("gusim@naver.com").role(Role.USER)
        .build();
    users.add(user.getUsername());
    userRepository.save(user);
  }

}
