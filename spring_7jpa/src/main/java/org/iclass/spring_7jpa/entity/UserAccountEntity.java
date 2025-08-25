package org.iclass.spring_7jpa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name="user_account")
@Entity
public class UserAccountEntity {

  // @Enumerated(EnumType.STRING) // 열거형 타입 상수이름으로 문자열 처리

  @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY) -> 안쓰는 이유
  private String userid;

  @Column(nullable = false)
  private String username;

  @Column
  private String password;

  @Column
  private LocalDate birth;

  @Column
  private String gender;

  @Column
  private String email;

  @Column
  private LocalDateTime regdate;

  @PrePersist // sql insert 전에 컬럼 값을 먼저 저장
  public void regdate() {
    this.regdate = LocalDateTime.now(); // 현재 날짜의 시간
  }

}

/*
 * userid , username -> not null
 */