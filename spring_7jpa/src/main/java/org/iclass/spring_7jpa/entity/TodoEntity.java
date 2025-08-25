package org.iclass.spring_7jpa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "todo_test") // 따로 설정하지 않으면 테이블명은 TO
@Entity
public class TodoEntity {

  @Id // PK
  @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 의 정수값 생성 방법(전략)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String username;

  @Column(name = "done")
  private boolean checked;

  @Column(nullable = false)
  private LocalDate todo_date;

  // createdAt (camel case) 는 컬럼명이 created_at(snake case) 로 만들어집니다.
  private LocalDateTime createdAt;

  @PrePersist // sql insert 전에 컬럼 값을 먼저 저장
  public void createdDateandChecked() {
    this.createdAt = LocalDateTime.now(); // 현재 날짜의 시간
    this.checked = false;
  }

}
